package thirdstage.exercise.ibatis.case5.daos.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseIBatisDao{
	
	private SqlMapClient sqlMapClient;
	
	public BaseIBatisDao(){
		
		
		
	}
	
	
	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}
	

}
