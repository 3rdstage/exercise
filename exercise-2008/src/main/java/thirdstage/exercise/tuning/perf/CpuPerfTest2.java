/**
 * 
 */
package thirdstage.exercise.tuning.perf;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 3rdstage
 *
 */
public class CpuPerfTest2 {

	private int threads = 0;
	private int size = 0;
	private long durationMillis = 0L;

	public CpuPerfTest2(int threads, int size){
		this.threads = threads;
		this.size = size;
	}

	public void test() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(this.threads);

		long startMillis = System.currentTimeMillis();
		CountDownLatch startCntDwn = new CountDownLatch(1);
		CountDownLatch endCntDwn = new CountDownLatch(threads);

		for(int i = 0; i < threads; i++){
			executor.submit(new Fibonacci(startCntDwn, endCntDwn, size));
		}

		startCntDwn.countDown();
		endCntDwn.await();

		this.durationMillis = System.currentTimeMillis() - startMillis;
		this.printResult(System.out);
		executor.shutdown();
	}

	public void printResult(PrintStream ps){
		ps.printf("CPU performance test result\n");
		ps.printf("  Number of threads : %1$,d\n", this.threads);
		ps.printf("  Number of loops per thead : %1$,d\n", this.size);
		ps.printf("  Execution duration in milli-seconds : %1$,d\n", this.durationMillis);
	}

	public static void main(String[] args) throws Exception{
		printMachineSpec(System.out);
		
		new CpuPerfTest2(1, 10000).test();
		new CpuPerfTest2(1, 500000).test();
		new CpuPerfTest2(10, 10000).test();
		new CpuPerfTest2(10, 500000).test();
		new CpuPerfTest2(50, 10000).test();
		new CpuPerfTest2(50, 100000).test();
		new CpuPerfTest2(100, 10000).test();
		new CpuPerfTest2(100, 100000).test();
		new CpuPerfTest2(200, 10000).test();
		new CpuPerfTest2(200, 100000).test();
		//new CpuPerfTest1(50, 500000).test(); //too long on the PC
	}

	public static void printMachineSpec(PrintStream ps){
		
		Properties props = System.getProperties();
		int processors = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
		
		ps.printf("System information : \n");
		ps.printf("  JVM : %1$s %2$s, %3$s\n", props.getProperty("java.vendor"), 
				props.getProperty("java.vm.name"), props.getProperty("java.version"));
		ps.printf("  OS : %1$s %2$s %3$s\n", props.getProperty("os.name"), 
				props.getProperty("os.arch"), props.getProperty("os.version"));
		ps.printf("  Number of processors : %1$,d\n", processors);
	}
}

class Fibonacci implements Callable<Long>{
	
	private CountDownLatch startCountDown = null;
	private CountDownLatch endCountDown = null;
	private int position = 0;
	
	
	public Fibonacci(CountDownLatch startCntDwn, CountDownLatch endCntDwn, int position){
		
		if(position < 2) throw new IllegalArgumentException("Position should be greater than 1.");
		this.startCountDown = startCntDwn;
		this.endCountDown = endCntDwn;
		this.position = position;
	}
	
	public Long call() throws Exception{

		this.startCountDown.await();
		long n0;
		long n1 = 0;
		long n2 = 1;
		
		for(int i = 2; i <= position; i++){
			n0 = n1 + n2; 
		}
		
		this.endCountDown.countDown();		
		return null;
	}
}


