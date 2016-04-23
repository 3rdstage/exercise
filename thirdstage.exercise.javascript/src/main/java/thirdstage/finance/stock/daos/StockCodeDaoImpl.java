package thirdstage.finance.stock.daos;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Required;

import thirdstage.finance.stock.entities.StockCode;

@ThreadSafe
public class StockCodeDaoImpl implements StockCodeDao{

	
	private SqlSession sqlSession;
	
	@Required
	public void setSqlSession( SqlSession session){
		this.sqlSession = session;
	}
	
	protected SqlSession getSqlSession(){
		return this.sqlSession;
	}
	
	public void insertIfUnexist(@Nonnull StockCode code) throws Exception{
		
		
	}
	
}
