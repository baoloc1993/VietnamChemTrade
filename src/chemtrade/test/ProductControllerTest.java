package chemtrade.test;

import java.sql.SQLException;
import java.util.ArrayList;

import chemtrade.controller.AddContactController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Product;
import junit.framework.TestCase;

public class ProductControllerTest extends TestCase{

	
	public void testGetProduct(){
		ProductController productController = new ProductController();
		try{
			ArrayList<Product> products = productController.getProductListFromDB();
			assertEquals(1010,products.size());
			assertEquals(1923,products.get(0).getProductId());
			
			ArrayList<Product> products2 = productController.getProductListFromDB(2);
			assertEquals(10,products2.size());
			//assertEquals(1923,products2.get(0).getProductId());
			
			ArrayList<Product> products3 = productController.getProductListFromDB(10,20);
			assertEquals(10,products3.size());
			assertEquals(products2.get(0).getProductId(),products3.get(0).getProductId());
			
			ArrayList<Product> products4 = productController.getProductListFromDB(0,10,'A');
			assertEquals(10,products4.size());
			System.out.println (products4.get(0).getProductName());
		}catch (Exception e){
			e.printStackTrace();
			assertEquals(1, 2);
		}
		
		
	}
//	
////	public void testGetProductbySEO(){
////		ProductController productController = new ProductController();
////		
////		try{
////			ArrayList<Product> products = productController.getProductBySeoKeyword("");
////			assertEquals(1019,products.size());
////			assertEquals(805,products.get(0).getProductId());
////		}catch (Exception e){
////			e.printStackTrace();
////			assertEquals(1, 2);
////		}
////	}
//	
	public void testGetPageCount(){
		ProductController productController = new ProductController();
		try {
			int pageCount = productController.getPageCount();
			assertEquals(101, pageCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, false);
		}
	}
	
	
	public void testGetProductByCateId(){
		ProductController productController = new ProductController();
		try{
			ArrayList<Product> products = productController.getProductByCatId("37");
			assertEquals(501,products.size());
			assertEquals(1454,products.get(0).getProductId());
			
		}catch (Exception e){
			e.printStackTrace();
			assertEquals(1, 2);
		}
		
		
	}
//	public void testAddToCart(){
//		AddContactController addContactController = new AddContactController();
//		System.out.println (Integer.parseInt("1"));
//	}
	
}
