package thirdstage.petstore1.services;

import thirdstage.petstore1.domain.entities.Order;

/**
 * Mainly targeted at usage as remote service interface
 *
 */
public interface OrderService{

	Order getOrder(int orderId);
}
