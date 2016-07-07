package chemtrade.test;

import java.io.IOException;

import junit.framework.TestCase;
import chemtrade.controller.VerificationCodeController;

public class VerificationCodeTest extends TestCase{

	public void testVerification(){
		VerificationCodeController verificationCodeController = new VerificationCodeController();
		try {
			verificationCodeController.getImageVerification("12345");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
