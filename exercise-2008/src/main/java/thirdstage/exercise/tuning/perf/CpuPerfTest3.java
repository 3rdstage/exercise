/**
 * 
 */
package thirdstage.exercise.tuning.perf;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
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
public class CpuPerfTest3 {

	private int threads = 0;
	private int scale = 0;
	private long durationMillis = 0L;
	private BigDecimal pi = null;

	public CpuPerfTest3(int threads, int scale){
		this.threads = threads;
		this.scale = scale;
	}

	public void test() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(this.threads);

		long startMillis = System.currentTimeMillis();
		CountDownLatch startCntDwn = new CountDownLatch(1);
		CountDownLatch endCntDwn = new CountDownLatch(threads);
		Future<BigDecimal> future = null;  

		for(int i = 0; i < threads; i++){
			if(i == 0) future = executor.submit(new PiCalculator(startCntDwn, endCntDwn, scale));
			else executor.submit(new PiCalculator(startCntDwn, endCntDwn, scale));
		}

		startCntDwn.countDown();
		endCntDwn.await();
		
		this.pi = future.get();
		this.durationMillis = System.currentTimeMillis() - startMillis;
		this.printResult(System.out);
		executor.shutdown();
	}

	public void printResult(PrintStream ps){
		ps.printf("PI calculation performance test result\n");
		ps.printf("  Number of threads : %1$,d\n", this.threads);
		ps.printf("  Scale for PI to calculate : %1$,d\n", this.scale);
		ps.printf("  Last number of caculated PI : %1$s\n", this.pi.toPlainString().substring(this.pi.precision()));
		ps.printf("  Scale of caculated PI : %1$,d\n", this.pi.scale());
		ps.printf("  Execution duration in milli-seconds : %1$,d\n", this.durationMillis);
	}

	public static void main(String[] args) throws Exception{
		printMachineSpec(System.out);

		new CpuPerfTest3(1, 1000).test();
		new CpuPerfTest3(1, 5000).test();
		new CpuPerfTest3(10, 1000).test();
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

class PiCalculator implements Callable<BigDecimal>{

	private CountDownLatch startCountDown = null;
	private CountDownLatch endCountDown = null;
	private int scale = 0;


	public PiCalculator(CountDownLatch startCntDwn, CountDownLatch endCntDwn, int scale){

		if(scale < 2) throw new IllegalArgumentException("Scale should be greater than 1.");
		this.startCountDown = startCntDwn;
		this.endCountDown = endCntDwn;
		this.scale = scale;
	}

	public BigDecimal call() throws Exception{
		
		this.startCountDown.await();
		BigDecimal result = this.calculatePi(this.scale);

		this.endCountDown.countDown();		
		return result;
	}
	
	private BigDecimal calculatePi(int scale){
		BigDecimal one, sixteen, four, oneby5, oneby239, atn15, atn239, xsq, powercum, bigpi;

		one = new BigDecimal("1");
		four = new BigDecimal("4");
		sixteen = new BigDecimal("16");
		oneby5 = new BigDecimal("0.2");
		oneby239 = one.divide(new BigDecimal("239"), scale, BigDecimal.ROUND_DOWN);

		// calculate arctan(1/5) to tscale digits of precision:
		// Based on log10(1/5) need about 1.5*tscale maximum exponent.
		atn15 = oneby5; // initialize to first term of arctan series.
		powercum = oneby5; // start with first power.
		xsq = oneby5.multiply(oneby5);

		for (int i = 3; i <= (3 * scale / 2); i += 4) {
			powercum = powercum.multiply(xsq);
			atn15 = atn15.subtract(powercum.divide(new BigDecimal(String
					.valueOf(i)), scale, BigDecimal.ROUND_DOWN));
			powercum = powercum.multiply(xsq);
			atn15 = atn15.add(powercum.divide(new BigDecimal(String
					.valueOf(i + 2)), scale, BigDecimal.ROUND_DOWN));
			atn15 = atn15.setScale(scale, BigDecimal.ROUND_DOWN);
		}

		// calculate arctan(1/239) to tscale digits of precision:
		// Based on log10(1/239) need about 0.5*tscale maximum exponent.
		atn239 = oneby239; // initialize to first term of arctan series.
		powercum = oneby239; // start with first power.
		xsq = oneby239.multiply(oneby239);

		for (int i = 3; i <= scale / 2; i += 4) {
			powercum = (powercum.multiply(xsq)).setScale(scale, BigDecimal.ROUND_DOWN);
			atn239 = atn239.subtract(powercum.divide(
					new BigDecimal(String.valueOf(i)), BigDecimal.ROUND_DOWN));
			powercum = (powercum.multiply(xsq)).setScale(scale, BigDecimal.ROUND_DOWN);
			atn239 = atn239.add(powercum.divide(
					new BigDecimal(String.valueOf(i + 2)), BigDecimal.ROUND_DOWN));
			atn239 = atn239.setScale(scale, BigDecimal.ROUND_DOWN);
		}

		bigpi = sixteen.multiply(atn15);
		bigpi = bigpi.subtract(four.multiply(atn239));		
		
		return bigpi;
	}
}


