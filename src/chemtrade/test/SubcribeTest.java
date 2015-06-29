package chemtrade.test;

import chemtrade.controller.homepage.SubcriberController;
import junit.framework.TestCase;

public class SubcribeTest extends TestCase{
	
	public void testSubscribe(){
		SubcriberController subcriberController = new SubcriberController();
		try {
			subcriberController.sendEmail("Loc", "baoloc1993@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println (result);
	}

}
