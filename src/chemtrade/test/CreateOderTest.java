package chemtrade.test;

import java.sql.SQLException;

import chemtrade.controller.product.CreateOrderController;
import chemtrade.entity.Order;
import junit.framework.TestCase;

public class CreateOderTest extends TestCase{
	
	public void testCreateOrder(){
		Order order = new Order();
		order.set
		CreateOrderController createOrderController = new CreateOrderController();
		try {
			createOrderController.createOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
