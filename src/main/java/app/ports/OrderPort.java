package app.ports;

import java.util.List;

import app.domain.models.Order;



public interface OrderPort {

	Order findByOrderId(long orderId) throws Exception;

	List<Order> getAllOrder()throws Exception;

	void saveOrder(Order order)throws Exception;

	

}
