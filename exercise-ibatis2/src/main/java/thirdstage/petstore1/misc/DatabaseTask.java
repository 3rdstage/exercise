package thirdstage.petstore1.misc;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseTask{
	

	public DatabaseTask(){
	}
	

	public void exportDbUnitDataSet(DataSource ds, String file){

		IDatabaseConnection conn = null;
		QueryDataSet dataSet = null;
		DatabaseConfig config = null;
		Writer wr = null;
		
		try{
			conn = new DatabaseDataSourceConnection(ds);
			config = conn.getConfig();
			config.setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
			dataSet = new QueryDataSet(conn);
			dataSet.addTable("sequence", "select * from `sequence`");
			dataSet.addTable("category", "select * from `category`");
			dataSet.addTable("account", "select * from `account`");
			dataSet.addTable("signon", "select * from `signon`");
			dataSet.addTable("profile", "select * from `profile`");
			dataSet.addTable("banner", "select * from `banner`");
			dataSet.addTable("product", "select * from `product`");
			dataSet.addTable("supplier", "select * from `supplier`");
			dataSet.addTable("item", "select * from `item`");
			dataSet.addTable("inventory", "select * from `inventory`");
			dataSet.addTable("`order`", "select * from `order`");
			dataSet.addTable("lineitem", "select * from `lineitem`");
			dataSet.addTable("orderstatus", "select * from `orderstatus`");

			wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

			FlatXmlDataSet.write(dataSet, wr, "UTF-8");

		}catch(Exception ex){
			ex.printStackTrace(System.out);
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
			if(wr != null){
				System.out.println("Output file : " + "" );
			}
		}
	}
	public static void main(String[] args) throws Exception{
		DatabaseTask dbTask = new DatabaseTask();
		
		ApplicationContext applContext = new ClassPathXmlApplicationContext("thirdstage/petstore1/test/conf/spring-petstore-daos-test.xml");
		DataSource ds = (DataSource)(applContext.getBean("dataSource"));

		dbTask.exportDbUnitDataSet(ds, "d:\\temp\\dataset-seed-petstore1.xml");
	}

}
