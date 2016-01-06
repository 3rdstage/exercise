/**
 * 
 */
package thirdstage.exercise.jdbc.meta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author 3rdstage
 * @since 2010-06-29
 *
 */
public class SchemaAccessor {


	/**
	 * <p>
	 * Gets the meta-data of the database with specified data source 
	 * and schema pattern.
	 * </p>
	 * <p>
	 * This method uses internally {@link java.sql.DatabaseMetaData#getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)}
	 * method. The <code>catalog</code> would be given by the catalog of specified data source.
	 * The <code>schemaPattern</code> would be handed over as it is. The <code>tableNamePattern</code> would be <code>null</code>
	 * and <code>types</code> would be "TABLE" and "VIEW".
	 * </p>
	 * 
	 * @param ds
	 * @param schemaPattern
	 * @return
	 */
	public List<Table> getTalbesAndViewsBySchemaPattern(DataSource ds, String schemaPattern) throws Exception{
		return this.getObjectsBySchemaPattern(ds, schemaPattern, new String[]{"TABLE", "VIEW"});
	}

	public List<Table> getTablesViewsAndAliasesBySchemaPattern(DataSource ds, String schemaPattern) throws Exception{
		return this.getObjectsBySchemaPattern(ds, schemaPattern, new String[]{"TABLE", "VIEW", "ALIAS"});
	}

	public List<Table> getTablesViewsAndSynonymsBySchemaPattern(DataSource ds, String schemaPattern) throws Exception{
		return this.getObjectsBySchemaPattern(ds, schemaPattern, new String[]{"TABLE", "VIEW", "SYNONYM"});
	}

	
	public List<Table> getTablesViewsAliasesAndSynonymsBySchemaPattern(DataSource ds, String schemaPattern) throws Exception{
		return this.getObjectsBySchemaPattern(ds, schemaPattern, new String[]{"TABLE", "VIEW", "ALIAS", "SYNONYM"});
	}
	

	
	private List<Table> getObjectsBySchemaPattern(DataSource ds, String schemaPattern, String[] types) throws Exception{
		
		Connection conn = null;
		ResultSet rs = null;
		Table table = null;
		List<Table> tables = new ArrayList<Table>();

		try{
			conn = ds.getConnection();
			rs = conn.getMetaData().getTables(conn.getCatalog(), schemaPattern, null, types);

			while(rs.next()){
//				table = new Table(rs.getString("TABLE_CAT"),
//						rs.getString("TABLE_SCHEM"),
//						rs.getString("TABLE_NAME"),
//						rs.getString("TABLE_TYPE"),
//						rs.getString("REMARKS"),
//						rs.getString(6),
//						rs.getString("TYPE_SCHEM"),
//						rs.getString("TYPE_NAME"),
//						rs.getString("SELF_REFERENCING_COL_NAME"),
//						rs.getString("REF_GENERATION")
//				);

				table = new Table(rs.getString("TABLE_CAT"),
						rs.getString("TABLE_SCHEM"),
						rs.getString("TABLE_NAME"),
						rs.getString("TABLE_TYPE"),
						rs.getString("REMARKS"),
						"",
						"",
						"",
						"",
						""
				);		

				tables.add(table);
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(rs != null) try{ rs.close();} catch(Exception ex){}
			if(conn != null) try{ conn.close();} catch(Exception ex){}
		}

		return tables;		
	}
	
	public List<Column> getColumnsBySchemaPatternStepByStep(DataSource ds, String schemaPattern) throws Exception{
		
		List<Column> cols = new ArrayList<Column>();
		Column col = null;
	
		Connection conn = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		String schema = null;
		String table = null;
		
		try{
			conn = ds.getConnection();
			rs1 = conn.getMetaData().getTables(conn.getCatalog(), schemaPattern, null, new String[]{"TABLE", "VIEW"});
			
			while(rs1.next()){
				schema = rs1.getString("TABLE_SCHEM");
				table = rs1.getString("TABLE_NAME");
				
				rs2 = conn.getMetaData().getColumns(conn.getCatalog(), schema, table, null);
				
				while(rs2.next()){
					col = new Column(
						rs2.getString("TABLE_CAT"),
						rs2.getString("TABLE_SCHEM"), 
						rs2.getString("TABLE_NAME"),
						rs2.getString("COLUMN_NAME"),
						rs2.getInt("DATA_TYPE"),
						rs2.getString("TYPE_NAME"),
						rs2.getInt("COLUMN_SIZE"),
						rs2.getInt("DECIMAL_DIGITS"),
						rs2.getInt("NULLABLE"),
						rs2.getString("REMARKS"),
						rs2.getInt("ORDINAL_POSITION"),
						""
						);
					cols.add(col);
				}
				
				rs2.close();
			}
			
		}catch(Exception ex){
			throw ex;
		}finally{
			if(rs2 != null) try{ rs2.close(); } catch(Exception ex){}
			if(rs1 != null) try{ rs1.close();} catch(Exception ex){}
			if(conn != null) try{ conn.close();} catch(Exception ex){}
		}
		
		return cols;
	}
	

	public List<Column> getColumnsBySchemaPattern(DataSource ds, String schemaPattern) throws Exception{
		
		List<Column> cols = new ArrayList<Column>();
		Column col = null;
	
		Connection conn = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			rs = conn.getMetaData().getColumns(conn.getCatalog(), schemaPattern, null, null);
			
			while(rs.next()){
				col = new Column(
						rs.getString("TABLE_CAT"),
						rs.getString("TABLE_SCHEM"), 
						rs.getString("TABLE_NAME"),
						rs.getString("COLUMN_NAME"),
						rs.getInt("DATA_TYPE"),
						rs.getString("TYPE_NAME"),
						rs.getInt("COLUMN_SIZE"),
						rs.getInt("DECIMAL_DIGITS"),
						rs.getInt("NULLABLE"),
						rs.getString("REMARKS"),
						rs.getInt("ORDINAL_POSITION"),
						""
						);
				
				cols.add(col);
				
			}
			
		}catch(Exception ex){
			throw ex;
		}finally{
			if(rs != null) try{ rs.close();} catch(Exception ex){}
			if(conn != null) try{ conn.close();} catch(Exception ex){}
		}
		
		return cols;
	}	
	

	public static class Table{

		String catalog;

		String schema;

		String name;

		String type;

		String comments;

		String typeCatalog;

		String typeSchema;

		String typeName;

		String selfRefColName;

		String refGeneration;

		public Table(){}

		/**
		 * @param catalog
		 * @param schema
		 * @param name
		 * @param type
		 * @param comments
		 * @param typeCatalog
		 * @param typeSchema
		 * @param typeName
		 * @param selfRefColName
		 * @param refGeneration
		 */
		public Table(String catalog, String schema, String name, String type,
				String comments, String typeCatalog, String typeSchema,
				String typeName, String selfRefColName, String refGeneration) {
			super();
			this.catalog = catalog;
			this.schema = schema;
			this.name = name;
			this.type = type;
			this.comments = comments;
			this.typeCatalog = typeCatalog;
			this.typeSchema = typeSchema;
			this.typeName = typeName;
			this.selfRefColName = selfRefColName;
			this.refGeneration = refGeneration;
		}

		/**
		 * @return the catalog
		 */
		public String getCatalog() {
			return catalog;
		}

		/**
		 * @param catalog the catalog to set
		 */
		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		/**
		 * @return the schema
		 */
		public String getSchema() {
			return schema;
		}

		/**
		 * @param schema the schema to set
		 */
		public void setSchema(String schema) {
			this.schema = schema;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the comments
		 */
		public String getComments() {
			return comments;
		}

		/**
		 * @param comments the comments to set
		 */
		public void setComments(String comments) {
			this.comments = comments;
		}

		/**
		 * @return the typeCatalog
		 */
		public String getTypeCatalog() {
			return typeCatalog;
		}

		/**
		 * @param typeCatalog the typeCatalog to set
		 */
		public void setTypeCatalog(String typeCatalog) {
			this.typeCatalog = typeCatalog;
		}

		/**
		 * @return the typeSchema
		 */
		public String getTypeSchema() {
			return typeSchema;
		}

		/**
		 * @param typeSchema the typeSchema to set
		 */
		public void setTypeSchema(String typeSchema) {
			this.typeSchema = typeSchema;
		}

		/**
		 * @return the typeName
		 */
		public String getTypeName() {
			return typeName;
		}

		/**
		 * @param typeName the typeName to set
		 */
		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		/**
		 * @return the selfRefColName
		 */
		public String getSelfRefColName() {
			return selfRefColName;
		}

		/**
		 * @param selfRefColName the selfRefColName to set
		 */
		public void setSelfRefColName(String selfRefColName) {
			this.selfRefColName = selfRefColName;
		}

		/**
		 * @return the refGeneration
		 */
		public String getRefGeneration() {
			return refGeneration;
		}

		/**
		 * @param refGeneration the refGeneration to set
		 */
		public void setRefGeneration(String refGeneration) {
			this.refGeneration = refGeneration;
		}

		@Override
		public String toString(){

			StringBuilder sb = new StringBuilder()
			.append("catalog : ").append(this.catalog).append(", ")
			.append("schema : ").append(this.schema).append(", ")
			.append("name : ").append(this.name).append(", ")
			.append("type : ").append(this.type).append(", ")
			.append("comments : ").append(this.comments).append(", ")
			.append("type catalog : ").append(this.typeCatalog).append("");

			return sb.toString();
		}

	}

	public static class Column{
		
		String catalog;
		
		String schema;
		
		String table;
		
		String name;
		
		int datatype;
		
		String datatypeName;
		
		int size;
		
		int scale;
		
		int nullable;
		
		String remarks;
		
		int position;
		
		String isAutoIncrement;
		
		public Column(){
			
		}

		/**
		 * @param catalog
		 * @param schema
		 * @param table
		 * @param name
		 * @param datatype
		 * @param datatypeName
		 * @param size
		 * @param scale
		 * @param nullable
		 * @param remarks
		 * @param position
		 * @param isAutoIncrement
		 */
		public Column(String catalog, String schema, String table, String name,
				int datatype, String datatypeName, int size, int scale,
				int nullable, String remarks, int position,
				String isAutoIncrement) {
			super();
			this.catalog = catalog;
			this.schema = schema;
			this.table = table;
			this.name = name;
			this.datatype = datatype;
			this.datatypeName = datatypeName;
			this.size = size;
			this.scale = scale;
			this.nullable = nullable;
			this.remarks = remarks;
			this.position = position;
			this.isAutoIncrement = isAutoIncrement;
		}

		/**
		 * @return the catalog
		 */
		public String getCatalog() {
			return catalog;
		}

		/**
		 * @param catalog the catalog to set
		 */
		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		/**
		 * @return the schema
		 */
		public String getSchema() {
			return schema;
		}

		/**
		 * @param schema the schema to set
		 */
		public void setSchema(String schema) {
			this.schema = schema;
		}

		/**
		 * @return the table
		 */
		public String getTable() {
			return table;
		}

		/**
		 * @param table the table to set
		 */
		public void setTable(String table) {
			this.table = table;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the datatype
		 */
		public int getDatatype() {
			return datatype;
		}

		/**
		 * @param datatype the datatype to set
		 */
		public void setDatatype(int datatype) {
			this.datatype = datatype;
		}

		/**
		 * @return the datatypeName
		 */
		public String getDatatypeName() {
			return datatypeName;
		}

		/**
		 * @param datatypeName the datatypeName to set
		 */
		public void setDatatypeName(String datatypeName) {
			this.datatypeName = datatypeName;
		}

		/**
		 * @return the size
		 */
		public int getSize() {
			return size;
		}

		/**
		 * @param size the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}

		/**
		 * @return the scale
		 */
		public int getScale() {
			return scale;
		}

		/**
		 * @param scale the scale to set
		 */
		public void setScale(int scale) {
			this.scale = scale;
		}

		/**
		 * @return the nullable
		 */
		public int getNullable() {
			return nullable;
		}

		/**
		 * @param nullable the nullable to set
		 */
		public void setNullable(int nullable) {
			this.nullable = nullable;
		}

		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}

		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		/**
		 * @return the position
		 */
		public int getPosition() {
			return position;
		}

		/**
		 * @param position the position to set
		 */
		public void setPosition(int position) {
			this.position = position;
		}

		/**
		 * @return the isAutoIncrement
		 */
		public String getIsAutoIncrement() {
			return isAutoIncrement;
		}

		/**
		 * @param isAutoIncrement the isAutoIncrement to set
		 */
		public void setIsAutoIncrement(String isAutoIncrement) {
			this.isAutoIncrement = isAutoIncrement;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Column [catalog=").append(catalog)
				.append(", schema=").append(schema)
				.append(", table=").append(table)
				.append(", name=").append(name)
				.append(", datatype=").append(datatype)
				.append(", datatypeName=").append(datatypeName)
				.append(", size=").append(size)
				.append(", scale=").append(scale)
				.append(", nullable=").append(nullable)
				.append(", remarks=").append((remarks != null && remarks.length() > 10) ? remarks.substring(0, 10) + "..." : "")
				.append(", position=").append(position)
				.append(", isAutoIncrement=").append(isAutoIncrement).append("]");
			return builder.toString();
		}

	}
}
