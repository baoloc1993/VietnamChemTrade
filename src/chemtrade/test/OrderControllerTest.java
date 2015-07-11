package chemtrade.test;

import java.sql.SQLException;
import java.util.ArrayList;

import chemtrade.controller.product.CreateOrderController;
import chemtrade.controller.product.OrderController;
import chemtrade.entity.Order;
import junit.framework.TestCase;

public class OrderControllerTest extends TestCase {

//	public void testGetPayment(){
//		OrderController orderController = new OrderController();
//		ArrayList<String> list = orderController.getPaymentTerms();
//		assertEquals(11, list.size());
//		assertEquals("D/A 120D" , list.get(list.size()-1));
//	}
//	
//	public void testGetCompanyType(){
//		OrderController orderController = new OrderController();
//		ArrayList<String> list = orderController.getCompanyTypes();
//		assertEquals(3, list.size());
//		assertEquals("Manufacturer" , list.get(0));
//	}
//	
//	public void testGetDeliveryTerm(){
//		OrderController orderController = new OrderController();
//		ArrayList<String> list = orderController.getDeliveryTerms();
//		assertEquals(11, list.size());
//		assertEquals("EXW" , list.get(0));
//	}
//	
//	
//	public void testInsertOrderDetail(){
//		OrderController orderController = new OrderController();
//		Order order = new Order();
//		try {
//			orderController.insertOrderDetails(order, 123245);
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
	
	public void testOrderMail(){
		Order order = new Order();
		order.setContactEmail("baoloc1993@gmail.com");
		CreateOrderController createOrderController = new  CreateOrderController();
		try {
			createOrderController.sendOrderMail(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
