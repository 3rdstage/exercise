/**
 * 
 */
package thirdstage.exercise.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author 3rdstage
 * 
 */
public class PerformanceTest{

	public static void main(String[] args){

		PerformanceTest tester = new PerformanceTest();

		String path1 = "C:/temp/test3.gif";
		File file1 = new File("C:/temp/test2.gif");
		long len1 = file1.length();

		long t1c = tester.getMilliSecToLoadByteArrayFromFile(path1, false, false);
		System.out.println("Time to load byte array from file : " + t1c + " milli-second for " + len1 + " bytes");

//		long t1d = tester.getMilliSecToLoadByteArrayFromFile(path1, true, false);
//		System.out.println("Time to load and print byte array from file : " + t1d + " milli-second for " + len1
//				+ " bytes");

		long t1 = tester.getNanoSecToLoadByteArrayFromFile(path1, false, false);
		System.out.println("Time to load byte array from file : " + t1 + " nano-second for " + len1 + " bytes");

//		long t1b = tester.getNanoSecToLoadByteArrayFromFile(path1, true, false);
//		System.out
//				.println("Time to load and print byte array from file : " + t1b + " nano-second for " + len1 + " bytes");
		
		long t1e = tester.getNanoSecToLoadByteArrayFromFile(path1, false, false);
		System.out
				.println("Time to load byte array from file : " + t1e + " nano-second for " + len1 + " bytes");

		long t1f = tester.getNanoSecToLoadByteArrayFromFile(path1, false, true);
		System.out
				.println("Time to load byte array with max buffer from file : " + t1f + " nano-second for " + len1 + " bytes");
		
	}

	public long getNanoSecToLoadByteArrayFromFile(String filePath, boolean prints, boolean setMaxBuffer){

		long t1 = System.nanoTime();

		File file = null;
		BufferedInputStream bis = null;
		byte[] bts = null;
		long len = 0L;

		try{
			file = new File(filePath);
			len = file.length();

			if(setMaxBuffer){
				bis = new BufferedInputStream(new FileInputStream(file), (int) len);
			}else{
				bis = new BufferedInputStream(new FileInputStream(file));
			}
			bts = new byte[(int) len];
			bis.read(bts, 0, (int) len);

			if(prints){
				System.out.println("The bytes are :");
				for(int i = 0; i < len; i += 100){
					System.out.print(bts[i]);
					if(i % 8000 == 0) System.out.println();
				}
				System.out.println();
			}

		}catch(Exception ex){
			throw new RuntimeException(ex);

		}finally{
			if(bis != null){
				try{
					bis.close();
				}catch(Exception ex){}
			}
		}

		return System.nanoTime() - t1;
	}

	public long getMilliSecToLoadByteArrayFromFile(String filePath, boolean prints, boolean setMaxBuffer){

		long t1 = System.currentTimeMillis();

		File file = null;
		BufferedInputStream bis = null;
		byte[] bts = null;
		long len = 0L;

		try{
			file = new File(filePath);
			len = file.length();

			if(setMaxBuffer){
				bis = new BufferedInputStream(new FileInputStream(file), (int) len);
			}else{
				bis = new BufferedInputStream(new FileInputStream(file));
			}
			bts = new byte[(int) len];
			bis.read(bts, 0, (int) len);

			if(prints){
				System.out.println("The bytes are :");
				for(int i = 0; i < len; i += 100){
					System.out.print(bts[i]);
					if(i % 8000 == 0) System.out.println();
				}
				System.out.println();
			}

		}catch(Exception ex){
			throw new RuntimeException(ex);

		}finally{
			if(bis != null){
				try{
					bis.close();
				}catch(Exception ex){}
			}
		}

		return System.currentTimeMillis() - t1;
	}
}
