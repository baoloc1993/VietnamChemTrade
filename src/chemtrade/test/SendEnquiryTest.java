package chemtrade.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import chemtrade.controller.product.SendEnquiryController;
import junit.framework.TestCase;

public class SendEnquiryTest extends TestCase {
//	public void testInsertDatabase(){
//		SendEnquiryController sendEnquiryController  = new  SendEnquiryController();
//        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
//
//		try {
//			sendEnquiryController.insertQuickquote("5", "MR", "Ngo", "Le", "Bao Loc", "baoloc1993@gmail.com", "A", "83745574", "Singapore", str_date2, "192.168.0.1", "Ngo Company", "Ha noi", "Test", "Hai Phong");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(false, true);
//			
//		}
//	}
//	
//	public void testInsertDatabase2(){
//		SendEnquiryController sendEnquiryController  = new  SendEnquiryController();
//        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
//
//		try {
//			sendEnquiryController.intsertQuickquoteProductInfo("P1", "5", "Kilograms");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(false, true);
//			
//		}
//	}
	
	public void testSendEmail(){
        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		SendEnquiryController sendEnquiryController  = new  SendEnquiryController();
		try {
			sendEnquiryController.sendEmail("5", "Mr", "Ngo", "Le Bao", "Loc", "baoloc1993@gmail.com", "+65", "83745574", "Vietnam", str_date2, "192.168.0.1", "Ngo Company", "Hanoi", "test", "hai Phong", "productsEnquired");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(false, true);

		}
				
	}


}
