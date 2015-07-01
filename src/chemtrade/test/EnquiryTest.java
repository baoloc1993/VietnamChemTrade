package chemtrade.test;

import com.sun.net.httpserver.Authenticator.Success;

import chemtrade.controller.homepage.ConfirmQuickEnquiryController;
import chemtrade.controller.homepage.QuickEnquiryController;
import junit.framework.TestCase;

public class EnquiryTest extends TestCase {

//	
	public void testSendEmail(){
		QuickEnquiryController quickEnquiryController = new QuickEnquiryController();
		try{
			quickEnquiryController.sendEmail("Luis Ngo", "baoloc1993@gmail.com", "Loc", "ACID", "Hello World");
			assertEquals(1, 1);
		}catch(Exception e) {
			e.printStackTrace();
			assertEquals(1, 2);
			
		}
	}
	public void testConfirmation(){
		ConfirmQuickEnquiryController confirmEnquiryController = new ConfirmQuickEnquiryController();
		try{
			confirmEnquiryController.actionConfirmEnquiry("421");
			assertEquals(1, 1);
		}catch (Exception e){
			e.printStackTrace();
			assertEquals(1, 2);
		}
	}
}
