package chemtrade.test;

import chemtrade.controller.product.ProductDownloadController;
import junit.framework.TestCase;

public class ProductDownloadControllerTest extends TestCase{
	public void testGetLastId(){
		ProductDownloadController productDownloadController  = new ProductDownloadController();
		int lastId = productDownloadController.getLastID();
		System.out.println (lastId);
	}
	


}
