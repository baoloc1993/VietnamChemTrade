package chemtrade.test;

import java.sql.SQLException;
import java.util.Calendar;

import chemtrade.controller.FeedbackController;
import junit.framework.TestCase;

public class FeedbackTest extends TestCase {

//	public void testsendEmail(){
//		FeedbackController feedbackController = new FeedbackController();
//		try {
//			feedbackController.sendEmail("LOC", "baoloc1993@gmail.com");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void testAddFeedback(){
		FeedbackController feedbackController	= new FeedbackController();
		Calendar cal = Calendar.getInstance();
        java.sql.Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
        String timestamp = time + "";
		try {
			feedbackController.addFeedback("Loc", "baoloc1993@gmail.com", "Comments", 5, timestamp, "192.168.0.1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
