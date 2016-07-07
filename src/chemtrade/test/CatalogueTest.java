package chemtrade.test;

import java.sql.SQLException;

import chemtrade.controller.product.CatalogueController;
import junit.framework.TestCase;

public class CatalogueTest extends TestCase {
	
//	public void testAddDB(){
//		CatalogueController catalogueController = new CatalogueController();
//		try {
//			catalogueController.addToDB("Luis Ngo", "baoloc1993@gmail.com", "Vietnam", "Mr", "Ngo", "COmpany", "website", "ipAddress");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void testSendEmail(){
		CatalogueController catalogueController = new CatalogueController();
		//catalogueController.addToDB("Luis Ngo", "baoloc1993@gmail.com", "Vietnam", "Mr", "Ngo", "COmpany", "website", "ipAddress");
		try {
			catalogueController.sendEmail("baoloc1993@gmail.com","Luis Ngo" , "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
