using System;
using delivery;

namespace order
{
	class OrderService
	{
		///
		/// Make a new order.
		///
		/// \callgraph
		///
		public void makeOrder()
		{
			OrderHeaderDao ohDao = new OrderHeaderDao();
			DeliveryService dvSvc = new DeliveryService();
			
			ohDao.insertOrderHeader();
			dvSvc.arrangeDelivery();
		
		}
	}
}		