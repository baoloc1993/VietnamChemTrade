package chemtrade.test;

import java.io.IOException;
import java.sql.SQLException;

import chemtrade.controller.product.ConfirmProductController;
import chemtrade.controller.product.QuickContactController;
import junit.framework.TestCase;

public class QuickContactTest extends TestCase{
	
//	public void testGetLastID(){
//		QuickContactController quickContactController = new QuickContactController();
//		int lastID = quickContactController.getLastEnquiryID();
//		assertEquals(32050, lastID);
//	}
	
//	public void testSendEmail(){
//		QuickContactController quickContactController = new QuickContactController();
//		try {
//			quickContactController.sendEmail("baoloc1993@gmail.com", "Luis Ngo", "100000", "83745574", "123", "ACID", "SUCCESS");
//			assertEquals(true, true);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
//	
//	public void testAddToDB(){
//		QuickContactController quickContactController = new QuickContactController();
//		try {
//			quickContactController.addToDatabase("Luis Ngo", "baoloc1993@gmail.com", "83745574", "SUCCESS", "1234567", "127.0.0.1", "A", "ACID");
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
//	
//	public void testUpdateDB(){
//		QuickContactController quickContactController = new QuickContactController();
//		String lastID = String.valueOf(quickContactController.getLastEnquiryID());
//		try {
//			quickContactController.updateTblSetting(lastID);
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//		
//	}
	
	
//	public void testAddTopDownload(){
//		QuickContactController quickContactController = new QuickContactController();
//		//String lastID = String.valueOf(quickContactController.getLastEnquiryID());
//		try {
//			//quickContactController.updateTblSetting(lastID);
//			quickContactController.addTopDownload("1234567");
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//		
//	}
	
//	public void testConfirmProduct(){
//		ConfirmProductController confirmProductController = new ConfirmProductController();
//		try {
//			confirmProductController.confirmProduct("32050");
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
	
	public void testDownloadMSDS(){
		QuickContactController quickContactController = new QuickContactController();
		try {
			String link = quickContactController.downloadFile("386", "A");
			System.out.println (link);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
