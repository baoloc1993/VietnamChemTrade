package chemtrade.test;

import java.sql.SQLException;

import chemtrade.controller.EBookController;
import junit.framework.TestCase;

public class EbookTest extends TestCase {

//	public void testEbook(){
//		EBookController eBookController = new EBookController();
//		try {
//			int lastId = eBookController.getLastDownloadId();
//			eBookController.insertEbook(lastId +1, "desg", "first Name", "last Name", "baoloc1993@gmail.com", "00:00:0000", "12321");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void testEmail() throws Exception{
		EBookController eBookController = new EBookController();
		try {
			int lastId = eBookController.getLastDownloadId();
			eBookController.sendEmail("baoloc1993@gmail.com", "Loc", "test");
			//eBookController.insertEbook(lastId +1, "desg", "first Name", "last Name", "baoloc1993@gmail.com", "00:00:0000", "12321");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
