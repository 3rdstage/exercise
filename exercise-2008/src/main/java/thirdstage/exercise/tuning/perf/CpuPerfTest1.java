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
public class CpuPerfTest1 {

	private int numOfThreads = 0;
	private int numOfLoops = 0;
	private long durationMillis = 0L;

	public CpuPerfTest1(int numOfThreads, int numOfLoops){
		this.numOfThreads = numOfThreads;
		this.numOfLoops = numOfLoops;
	}

	public void test() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(this.numOfThreads);

		long startMillis = System.currentTimeMillis();
		CountDownLatch startCntDwn = new CountDownLatch(1);
		CountDownLatch endCntDwn = new CountDownLatch(numOfThreads);

		for(int i = 0; i < numOfThreads; i++){
			executor.submit(new TimestampCollector(startCntDwn, endCntDwn, numOfLoops));
		}

		startCntDwn.countDown();
		endCntDwn.await();

		this.durationMillis = System.currentTimeMillis() - startMillis;
		this.printResult(System.out);
		executor.shutdown();
	}

	public void printResult(PrintStream ps){
		ps.printf("CPU performance test result\n");
		ps.printf("  Number of threads : %1$,d\n", this.numOfThreads);
		ps.printf("  Number of loops per thead : %1$,d\n", this.numOfLoops);
		ps.printf("  Execution duration in milli-seconds : %1$,d\n", this.durationMillis);
	}

	public static void main(String[] args) throws Exception{
		printMachineSpec(System.out);
		
		new CpuPerfTest1(1, 10000).test();
		new CpuPerfTest1(1, 500000).test();
		new CpuPerfTest1(10, 10000).test();
		new CpuPerfTest1(10, 500000).test();
		new CpuPerfTest1(50, 10000).test();
		new CpuPerfTest1(50, 100000).test();
		new CpuPerfTest1(100, 10000).test();
		new CpuPerfTest1(100, 100000).test();
		new CpuPerfTest1(200, 10000).test();
		new CpuPerfTest1(200, 100000).test();
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

class TimestampCollector implements Callable<List<String>>{

	private CountDownLatch startCountDown = null;
	private CountDownLatch endCountDown = null;
	private int numOfTimestamps = 0;

	public TimestampCollector(CountDownLatch startCntDwn, CountDownLatch endCntDwn, int numOfTimestamps){

		if(numOfTimestamps < 0) throw new IllegalArgumentException("numOfTimestamps should be non-negative.");
		this.startCountDown = startCntDwn;
		this.endCountDown = endCntDwn;
		this.numOfTimestamps = numOfTimestamps;
	}

	public List<String> call() throws Exception{

		this.startCountDown.await();
		List<String> timestamps = null;
		timestamps = new ArrayList<String>(this.numOfTimestamps);

		long currentMillis = 0L;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String str = null;
		for(int i = 0; i < this.numOfTimestamps; i++){
			currentMillis = System.currentTimeMillis();
			str = df.format(new Date(currentMillis));
			if(false) timestamps.add(str); //may cause OutOfMemoryError
		}

		this.endCountDown.countDown();
		return timestamps; 
	}
}