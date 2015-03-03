/**
 * 
 */
package thirdstage.exercise.lang.serializable.case1;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class SerializationTest{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Shows that the fields of non-serializable superclass will not
	 * serialized with correct values.
	 * 
	 */
	@Test
	public void testMark1Serialization(){
		
		Mark1 mark = new Mark1();
		mark.setX(3);
		mark.setY(1);
		mark.setName("TheHospital");
		mark.setVisible(true);
		
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		String str = null;
		byte[] bytes = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		Mark1 anotherMark = null;
		
		try{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			oos.writeObject(mark);
			bytes = baos.toByteArray();
			
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			
			anotherMark = (Mark1)(ois.readObject());
			
			Assert.assertTrue(mark != anotherMark);
			Assert.assertNotEquals(anotherMark.getX(), mark.getX()); // x is not serialized
			Assert.assertNotEquals(anotherMark.getY(), mark.getY()); // y is not serialized
			Assert.assertEquals(anotherMark.getName(), mark.getName());
			Assert.assertEquals(anotherMark.isVisible(), mark.isVisible());
			
			
			
		}catch(Exception ex){
			this.logger.error(ex.getMessage(), ex);
			throw new RuntimeException(ex);
			
		}finally{
			if(baos != null){ 
				try{ baos.close(); }
				catch(Exception ex){}
			}
			if(oos != null){
				try{ oos.close(); }
				catch(Exception ex){}
			}
			if(bais != null){
				try{ bais.close(); }
				catch(Exception ex){}
			}
			if(ois != null){
				try{ ois.close(); }
				catch(Exception ex){}
			}
		}
	}
	
	
	
	/**
	 * Will always throws Exception. 
	 * Read the API documentation of java.io.Serializable for details.
	 * 
	 * @throws Exception
	 */
	@Test(expectedExceptions={java.io.InvalidClassException.class})
	public void testMark2Serialization() throws Exception{
		
		Mark2 mark = new Mark2();
		mark.setX(3);
		mark.setY(1);
		mark.setName("TheHospital");
		mark.setVisible(true);
		
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		String str = null;
		byte[] bytes = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		Mark2 anotherMark = null;
		
		try{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			oos.writeObject(mark);
			bytes = baos.toByteArray();
			
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			
			anotherMark = (Mark2)(ois.readObject());
			
			Assert.assertTrue(mark != anotherMark);
			Assert.assertNotEquals(anotherMark.getX(), mark.getX()); // x is not serialized
			Assert.assertNotEquals(anotherMark.getY(), mark.getY()); // y is not serialized
			Assert.assertEquals(anotherMark.getName(), mark.getName());
			Assert.assertEquals(anotherMark.isVisible(), mark.isVisible());
			
			
			
		}catch(Exception ex){
			this.logger.error(ex.getMessage(), ex);
			throw ex;
			
		}finally{
			if(baos != null){ 
				try{ baos.close(); }
				catch(Exception ex){}
			}
			if(oos != null){
				try{ oos.close(); }
				catch(Exception ex){}
			}
			if(bais != null){
				try{ bais.close(); }
				catch(Exception ex){}
			}
			if(ois != null){
				try{ ois.close(); }
				catch(Exception ex){}
			}
		}
	}
	
	public class Mark3 implements java.io.Serializable{
		
		private int x;
		private int y;
		private String name;
		private boolean visible;
		
		public Mark3(){ }
		
		public int getX(){ return this.x; }
		public void setX(int x){ this.x = x; }
		public int getY(){ return this.y; }
		public void setY(int y){ this.y = y; }
		public String getName(){ return this.name; }
		public void setName(String name){ this.name = name; }
		public boolean isVisible(){ return this.visible; }
		public void setVisible(boolean is){ this.visible = is; }
	}
	
	@Test
	public void testMark3Serialization() throws Exception{
		
		Mark3 mark = new Mark3();
		mark.setX(3);
		mark.setY(1);
		mark.setName("TheHospital");
		mark.setVisible(true);
		
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		String str = null;
		byte[] bytes = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		Mark3 anotherMark = null;
		
		try{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			oos.writeObject(mark);
			bytes = baos.toByteArray();
			
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			
			anotherMark = (Mark3)(ois.readObject());
			
			Assert.assertTrue(mark != anotherMark);
			Assert.assertNotEquals(anotherMark.getX(), mark.getX()); // x is not serialized
			Assert.assertNotEquals(anotherMark.getY(), mark.getY()); // y is not serialized
			Assert.assertEquals(anotherMark.getName(), mark.getName());
			Assert.assertEquals(anotherMark.isVisible(), mark.isVisible());
			
			
			
		}catch(Exception ex){
			this.logger.error(ex.getMessage(), ex);
			throw ex;
			
		}finally{
			if(baos != null){ 
				try{ baos.close(); }
				catch(Exception ex){}
			}
			if(oos != null){
				try{ oos.close(); }
				catch(Exception ex){}
			}
			if(bais != null){
				try{ bais.close(); }
				catch(Exception ex){}
			}
			if(ois != null){
				try{ ois.close(); }
				catch(Exception ex){}
			}
		}
	}
	

}
