package sample.server.case2;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectSizeTest {

	
	@Test
	public void testObjectSize() throws Exception{
		
		Properties systemProps = System.getProperties();
		long[] sizes1 = this.getSizeOfObject(systemProps);
		Assert.assertTrue(sizes1[0] > sizes1[1]);
		
		Locale[] locales = Locale.getAvailableLocales();
		long[] sizes2 = this.getSizeOfObject(locales);
		Assert.assertTrue(sizes2[0] > sizes2[1]);
		
		String str = "gzip is a software application used for file compression and decompression. The program was created by Jean-Loup Gailly and Mark Adler as a free software replacement for the compress program used in early Unix systems";
		long[] sizes3 = this.getSizeOfObject(str);
		Assert.assertTrue(sizes3[0] > sizes3[1]);
		
	}
	
	public long[] getSizeOfObject(Object obj){

		ByteArrayOutputStream baos1 = null, baos2 = null, baos3 = null;
		ObjectOutputStream oos1 = null, oos2 = null, oos3 = null;
		GZIPOutputStream gzos2 = null;
		BZip2CompressorOutputStream bzos3 = null;
		long n1 = 0, n2 = 0, n3 = 0;
		
		try{
			
			baos1 = new ByteArrayOutputStream();
			oos1 = new ObjectOutputStream(baos1);
			oos1.writeObject(obj);

			byte[] bytes1 = baos1.toByteArray();
			n1 = bytes1.length;
			System.out.printf("The size of byte array without compression is %1$d\n", n1);
		
			baos2 = new ByteArrayOutputStream();
			gzos2 = new GZIPOutputStream(baos2);
			oos2 = new ObjectOutputStream(gzos2);
			oos2.writeObject(obj);
			gzos2.finish(); //don't miss this

			byte[] bytes2 = baos2.toByteArray();
			n2 = bytes2.length;
			System.out.printf("The size of byte array compress with GZIP is %1$d\n", n2);
			
			baos3 = new ByteArrayOutputStream();
			bzos3 = new BZip2CompressorOutputStream(baos3);
			oos3 = new ObjectOutputStream(bzos3);
			oos3.writeObject(obj);
			bzos3.finish(); //don't miss this

			byte[] bytes3 = baos3.toByteArray();
			n3 = bytes3.length;
			System.out.printf("The size of byte array compress with BZIP2 is %1$d\n", n3);
			
			
		}
		catch(Exception ex){
			
		}
		finally{
			if(baos1 != null) try{ baos1.close(); }catch(Exception ex){}
			if(oos1 != null) try{ oos1.close(); }catch(Exception ex){}
			if(baos2 != null) try{ baos2.close(); }catch(Exception ex){}
			if(gzos2 != null) try{ gzos2.close(); }catch(Exception ex){}
			if(oos2 != null) try{ oos2.close(); }catch(Exception ex){}
		}
		
		return new long[]{n1, n2, n3};
	}
	
}
