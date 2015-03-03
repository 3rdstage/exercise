package thirdstage.purple.sql;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.ListOrderedMap;

/**
 * Wrap the data of the java.sql.DatabaseMetaData object in map basis.
 * 
 * @version 0.85, 2008-12-19, 3rdstage, Add attributes related to JDBC driver information.<br/>
 *          0.8, 2008-12-10, 3rdstage, Add a few attributes and adopt ordered map from Apache common collections<br/>
 *          0.7, 2008-09-08, 3rdstage, Support only a few method of DatabaseMetaData<br/>
 *          
 * @author 3rdstage
 * @since 2008-09-08
 *
 */
public class DatabaseMetaDataMap{
	
	public final static String DATABASE_PRODUCT_NAME = "Database Product Name";
	public final static String DATABASE_PRODUCT_VERSION = "Database Product Version";
	public final static String DATABASE_MAJOR_VERSION = "Database Major Version";
	public final static String DATABASE_MINOR_VERSION = "Database Minor Version";
	public final static String CATALOG_TERM = "Catalog Term";
	public final static String CATALOG_SEPARATOR = "Catalog Separator"; 
	public final static String SCHEMA_TERM = "Schema Term";
	public final static String PROCEDURE_TERM = "Procedure Term";
	public final static String SQL_KEYWORDS = "SQL Keywords";
	public final static String STRING_FUNCTIONS = "String Functions";
	public final static String DRIVER_NAME = "Driver Name";
	public final static String DRIVER_VERSION = "Driver Version";
	public final static String DRIVER_MAJOR_VERSION = "Driver Major Version";
	public final static String DRIVER_MINOR_VERSION = "Driver Minor Version";
	
	
	
	
	protected DatabaseMetaData databaseMeta;
	protected Map<String, String> metaMap = new ListOrderedMap(); 
	
	public DatabaseMetaDataMap(DatabaseMetaData meta){
		
		if(meta == null) throw new java.lang.IllegalArgumentException("The parameter cann't be null");
		
		this.databaseMeta = meta;
		
		String str = null;
		Integer num = null;

		
		try{
			str = meta.getDatabaseProductName();
			this.metaMap.put(this.DATABASE_PRODUCT_NAME, str);
		}catch(Exception ex){
			this.metaMap.put(this.DATABASE_PRODUCT_NAME, null);
		}
		
		try{
			str = meta.getDatabaseProductVersion();
			this.metaMap.put(this.DATABASE_PRODUCT_VERSION, str);
		}catch(Exception ex){
			this.metaMap.put(this.DATABASE_PRODUCT_VERSION, null);
		}
		
		try{
			str = String.valueOf(meta.getDatabaseMajorVersion());
			this.metaMap.put(this.DATABASE_MAJOR_VERSION, str);
		}catch(Exception ex){
			this.metaMap.put(this.DATABASE_MAJOR_VERSION, null);
		}
		
		try{
			str = String.valueOf(meta.getDatabaseMinorVersion());
			this.metaMap.put(this.DATABASE_MINOR_VERSION, str);
		}catch(Exception ex){
			this.metaMap.put(this.DATABASE_MINOR_VERSION, null);
		}

		try{
			str = meta.getCatalogTerm();
			this.metaMap.put(CATALOG_TERM, str);
		}catch(Exception ex){
			this.metaMap.put(CATALOG_TERM, null);
		}

		try{
			str = meta.getCatalogSeparator();
			this.metaMap.put(CATALOG_SEPARATOR, str);
		}catch(Exception ex){
			this.metaMap.put(CATALOG_SEPARATOR, null);
		}
		
		try{
			str = meta.getSchemaTerm();
			this.metaMap.put(SCHEMA_TERM, str);
		}catch(Exception ex){
			this.metaMap.put(SCHEMA_TERM, null);
		}		
		
		try{
			str = meta.getProcedureTerm();
			this.metaMap.put(PROCEDURE_TERM, str);
		}catch(Exception ex){
			this.metaMap.put(PROCEDURE_TERM, null);
		}
		
		try{
			str = meta.getSQLKeywords();
			this.metaMap.put(SQL_KEYWORDS, str);
		}catch(Exception ex){
			this.metaMap.put(SQL_KEYWORDS, null);
		}

		try{
			str = meta.getStringFunctions();
			this.metaMap.put(STRING_FUNCTIONS, str);
		}catch(Exception ex){
			this.metaMap.put(STRING_FUNCTIONS, null);
		}
		
		try{
			str = meta.getDriverName();
			this.metaMap.put(DRIVER_NAME, str);
		}catch(Exception ex){
			this.metaMap.put(DRIVER_NAME, null);
		}
		
		try{
			str = meta.getDriverVersion();
			this.metaMap.put(DRIVER_VERSION, str);
		}catch(Exception ex){
			this.metaMap.put(DRIVER_VERSION, null);
		}
		
		try{
			num = meta.getDriverMajorVersion();
			this.metaMap.put(DRIVER_MAJOR_VERSION, num.toString());
		}catch(Exception ex){
			this.metaMap.put(DRIVER_MAJOR_VERSION, null);
		}
		
		try{
			num = meta.getDriverMinorVersion();
			this.metaMap.put(DRIVER_MINOR_VERSION, num.toString());
		}catch(Exception ex){
			this.metaMap.put(DRIVER_MINOR_VERSION, null);
		}
	}
	
	public Set<String> getKeySet(){
		return this.metaMap.keySet();
		
	}
	
	public String get(String key){
		return this.metaMap.get(key);
	}
}

