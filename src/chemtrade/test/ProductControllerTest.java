package chemtrade.test;

import java.io.UnsupportedEncodingException;
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
			System.out.println (products.get(0).getThumbImage());
			assertEquals(120,products.size());
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
//		
//		
	}
////	
//////	public void testGetProductbySEO(){
//////		ProductController productController = new ProductController();
//////		
//////		try{
//////			ArrayList<Product> products = productController.getProductBySeoKeyword("");
//////			assertEquals(1019,products.size());
//////			assertEquals(805,products.get(0).getProductId());
//////		}catch (Exception e){
//////			e.printStackTrace();
//////			assertEquals(1, 2);
//////		}
//////	}
////	
//	public void testGetPageCount(){
//		ProductController productController = new ProductController();
//		try {
//			int pageCount = productController.getPageCount();
//			assertEquals(101, pageCount);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
	
	
//	public void testGetProductByCateId() throws UnsupportedEncodingException{
//		ProductController productController = new ProductController();
//		//ProductController productController = new ProductController();
//		Product product = productController.getProductFromDBByID(12);
//		String str = product.getProductName();
//		//String str= new String(product.getProductName().getBytes("ISO-8859-1"),"GB2312");
//		for (int i = 0 ; i< str.length(); i++){
//			System.out.println ((int)str.charAt(i));
//		}
//		System.out.println ("\u4eca\u65e5\u306f\u4e16\u754c");
//		System.out.println (str);
//		System.out.println (product.getProductId());
//		//req.setAttribute("message", product.getProductName());
//		 //req.getRequestDispatcher("jsp/test.jsp").forward(req, resp);
//		
//		
//	}
	public void testGetTopProduct(){
		//AddContactController addContactController = new AddContactController();
		ArrayList<Product> products = new ProductController().getTopProducts();
		System.out.println (products.size());
		//System.out.println (Integer.parseInt("1"));
	}
	
}
