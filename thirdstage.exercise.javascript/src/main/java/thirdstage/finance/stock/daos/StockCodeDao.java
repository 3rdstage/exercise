package thirdstage.finance.stock.daos;

import javax.annotation.Nonnull;

import thirdstage.finance.stock.entities.StockCode;

public interface StockCodeDao {
	
	public void insertIfUnexist(@Nonnull StockCode code) throws Exception; 

}
