/**
 * 
 */
package thirdstage.exercise.findbugs.case1;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * @author 3rdstage
 *
 */
public class EffectiveAndIneffectiveCodes{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private DataSource dataSource = null;
	
	@Required
	public void setDataSource(DataSource ds){ this.dataSource = ds; }
	
	protected DataSource getDataSource(){ return this.dataSource; } 

	
	public void printEmployeesInefficient(Map<String, Employee> emps){
		for(String key : emps.keySet()){ //keys need lookup hereafter -> inefficient
			System.out.println(emps.get(key).toString());
		}
	}
	
	public void printEmployeesEfficient(Map<String, Employee> emps){
		for(Map.Entry<String, Employee> entry : emps.entrySet()){ 
			//iterate the values without lookup -> efficient 
			System.out.println(entry.getValue().toString());
		}
	}
	

	public void writeEmployeesToFileMostUnsafe(@Nonnull List<Employee> emps, String path){
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try{
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos, 1000);
			ps =  new PrintStream(bos, true, "utf-8");
			
			for(Employee emp : emps){
				ps.println(emp.toString());
			}
			
			fos.close(); //may not be executed
			bos.close(); //may not be executed
			ps.close(); //may not be executed
		}catch(Exception ex){
			this.logger.error("Can't write the Employee list", ex);
			throw new RuntimeException("Can't write the Employee list", ex);
		}
	}	
	
	public void writeEmployeesToFileUnsafe(@Nonnull List<Employee> emps, String path){
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try{
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos, 1000);
			ps =  new PrintStream(bos, true, "utf-8"); //may throw UnsupportedEncodingException	
			
			for(Employee emp : emps){
				ps.println(emp.toString());
			}
		}catch(Exception ex){
			this.logger.error("Can't write the Employee list", ex);
			throw new RuntimeException("Can't write the Employee list", ex);
		}finally{
			//This block explicitly closes only ps and does NOT close fos and bos.
			//In usual case, closing ps also closes underlying fos and bos. 
			//But if exception occurrs at new PrintStream in try block, 
			//bos and fos may remain unclosed.
			// -> UNSAFE
			
			if(ps != null){
				try{ ps.close(); }
				catch(Exception ex){ this.logger.error("Can't close a resource", ex); }
			}
		}
	}

	public void writeEmployeesToFileAlsoUnsafe(@Nonnull List<Employee> emps, String path){
		
		PrintStream ps = null;
		
		try{
			//may throw UnsupportedEncodingException
			ps =  new PrintStream(new BufferedOutputStream(
				new FileOutputStream(path), 1000), true, "utf-8");
			
			for(Employee emp : emps){
				ps.println(emp.toString());
			}
		}catch(Exception ex){
			this.logger.error("Can't write the Employee list", ex);
			throw new RuntimeException("Can't write the Employee list", ex);
		}finally{
			//Same with right above case.
			//When the exception occurs creating PrintStream after the underlying
			//BufferedStream and FileOutputStream, the underlying streams would
			//remain unclosed with the following code. 
			// -> UNSAFE

			if(ps != null){
				try{ ps.close(); }
				catch(Exception ex){ this.logger.error("Can't close a resource", ex); }
			}
		}
	}	

	public void writeEmployeesToFileSafe(@Nonnull List<Employee> emps, String path){
		
		//Define the resources as local variables as possible.
		//Avoid to define them as member fields, without definite requirement.
		//And do not handle these variables amongst multiple mehtod passing them.
		//In other word, process all the necessary operations inside this method.
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try{
			//There a PrintStream(File) constructor which dosen't 
			//need to create underlying FileOutputStream or BufferedOutputStream.
			//But, this sample dosen't use it to show the intended code pattern.
			
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos, 1000);
			ps =  new PrintStream(bos, true, "utf-8"); //may throw UnsupportedEncodingException
			
			for(Employee emp : emps){
				ps.println(emp.toString());
			}
			
		}catch(Exception ex){
			this.logger.error("Can't write the Employee list", ex);
			throw new RuntimeException("Can't write the Employee list", ex);
		}finally{
			//take care of order - close the underlying reource first.
			//take care of each try/catch pattern 
			// - close also can throw exception, but shouldn't block the next tries of close.
			
			if(fos != null){
				try{ fos.close(); }
				catch(Exception ex){ this.logger.error("Can't close a resource", ex); }
			}
			if(bos != null){
				try{ bos.close(); }
				catch(Exception ex){ this.logger.error("Can't close a resource", ex); }
			}
			if(ps != null){
				try{ ps.close(); }
				catch(Exception ex){ this.logger.error("Can't close a resource", ex); }
			}
		}
	}
	
	public List<Employee> listEmployees(@Nonnull List<String> ids){
		
		if(ids == null) throw new IllegalArgumentException("ID list should be specified.");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Employee> result = new ArrayList<Employee>(ids.size());
		String qry = "SELECT name, age, height, weight, married FROM emp WHERE id = ?";
		
		Employee emp = null;
		try{
			//In most cases, data-source manages connection pool internally. 
			conn = this.getDataSource().getConnection(); 
			ps = conn.prepareStatement(qry);
			
			for(String id : ids){
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				if(rs.next()){
					emp = new Employee();
					emp.setId(id);
					emp.setAge(rs.getInt("age"));
					emp.setHeight(rs.getDouble("height"));
					emp.setWeight(rs.getDouble("weight"));
					emp.setMarried(rs.getBoolean("married"));
					result.add(emp);
				}
				
				//Close each ResultSet in the iteration
				//Although the spec says that closing of Statement can open only one
				//ResultSet at a time and closing a Statement also close the ResultSet
				//retunred by the Statement, you'd better not trust the implementations 
				//too much.  
				if(rs != null){
					try{ rs.close(); }
					catch(Exception ex){ this.logger.error("Can't close ResultSet object", ex); }
				}
			}
			
		}catch(Exception ex){
			this.logger.error("Can't list specified employees.", ex);
			throw new RuntimeException("Can't list specified employees.", ex);
		}finally{
			//take care of order - reverse of creation order
			//take care of each try/catch pattern 
			// - close also can throw exception, but shouldn't block the next lines.			

			if(rs != null){
				try{ rs.close(); }
				catch(Exception ex){ this.logger.error("Can't close ResultSet object", ex); }
			}
			if(ps != null){
				try{ ps.close(); }
				catch(Exception ex){ this.logger.error("Can't close PreparedStatement object", ex); }
			}
			if(conn != null){
				try{ conn.close(); }
				catch(Exception ex){ this.logger.error("Can't close Connection object", ex); }
			}			
		}
		return result;
	}
}


class Employee{

	private String id;
	private String name;
	private int age;
	private double height;
	private double weight;
	private boolean isMarried;

	public String getId(){ return id; }
	public void setId(String id){ this.id = id; }
	
	public String getName(){ return name; }
	public void setName(String name){ this.name = name; }

	public int getAge(){ return age;	}
	public void setAge(int age){ this.age = age; }

	public double getHeight(){ return height; }
	public void setHeight(double height){ this.height = height; }

	public double getWeight(){ return weight; }
	public void setWeight(double weight){ this.weight = weight; }

	public boolean isMarried(){ return isMarried; }
	public void setMarried(boolean isMarried){ this.isMarried = isMarried; }
}