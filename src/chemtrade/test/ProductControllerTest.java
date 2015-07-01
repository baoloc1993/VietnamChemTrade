package chemtrade.test;

import java.util.ArrayList;

import chemtrade.controller.AddContactController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Product;
import junit.framework.TestCase;

public class ProductControllerTest extends TestCase{

	
	public void testGetProduct(){
		ProductController productController = new ProductController();
		try{
			ArrayList<Product> products = productController.getProductListFromDB(3);
			assertEquals(3,products.size());
			assertEquals(1923,products.get(0).getProductId());
			
			ArrayList<Product> products2 = productController.getProductListFromDB(0);
			assertEquals(1010,products2.size());
			assertEquals(1923,products2.get(0).getProductId());
		}catch (Exception e){
			e.printStackTrace();
			assertEquals(1, 2);
		}
		
		
	}
	
//	public void testGetProductbySEO(){
//		ProductController productController = new ProductController();
//		
//		try{
//			ArrayList<Product> products = productController.getProductBySeoKeyword("");
//			assertEquals(1019,products.size());
//			assertEquals(805,products.get(0).getProductId());
//		}catch (Exception e){
//			e.printStackTrace();
//			assertEquals(1, 2);
//		}
//	}
	
	public void testGetProductByID(){
		
	}
	
	public void testAddToCart(){
		AddContactController addContactController = new AddContactController();
	}
	
}
