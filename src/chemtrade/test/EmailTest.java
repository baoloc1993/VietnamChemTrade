package chemtrade.test;

import chemtrade.controller.EmailController;
import junit.framework.TestCase;

public class EmailTest extends TestCase {

	public void testEmail(){
		EmailController emailController = new EmailController();
		try {
			//emailController.sendEmailViaGmail("baoloc1993@gmail.com", "Đây là test email", "Tiêu đề thư");
			emailController.getAdminEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
