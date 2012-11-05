package thirdstage.sample.spring.shop1.dao;

import java.util.List;
import thirdstage.sample.spring.shop1.entity.LineItem;

public interface LineItemDao{

	void insertLineItem(LineItem lineItem);

	List<LineItem> selectLineItemsByOrder(String orderId);

}
