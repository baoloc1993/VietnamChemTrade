package chemtrade.test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import chemtrade.controller.SearchController;
import chemtrade.controller.product.ProductController;
import chemtrade.controller.product.SendEnquiryController;
import chemtrade.entity.Product;
import junit.framework.TestCase;

public class SearchTest extends TestCase {
	
//	public void testSearch(){
//		chemtrade.controller.SearchController searchController = new SearchController();
//		int size;
//		try {
//			size = searchController.getProductSize("Citric Acid Anhydrous (Thailand Origin)", "", "", "");
//			ArrayList<Product> products = searchController.getSearchProductList(0,0,"Quá»‘", "", "", "");
//			System.out.println (products.size());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//ProductController productController = new ProductController();
//		//ArrayList<Product> products = productController.getP(0,0, "Acid", "", "", "");
//		
//	}
//	public void testCharSet(){
//		String keyword = "";
//		 try {
//			 //SearchController searchController = new SearchController();
//			keyword = new String(keyword.getBytes("UTF-8"),"ISO-8859-1");
//			//keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println (keyword);
//			//ArrayList<Product> products = searchController.getSearchProductList(0,0,"Quá»‘", "", "", "");
//			//System.out.println (products.size());
////			System.out.println (products.size());
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//	}
	public void testKeyWord(){
		SearchController searchController = new SearchController();
		System.out.println (searchController.configKeyword("Refined Glycerine 99.5% (Trung Quốc  Origin)"));
		
	}

}
