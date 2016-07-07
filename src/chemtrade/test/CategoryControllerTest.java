package chemtrade.test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import chemtrade.controller.product.ProductCategoryController;
import chemtrade.entity.Category;
import junit.framework.TestCase;

public class CategoryControllerTest extends TestCase {
	
	public void testGetCategoryWrapper() throws UnsupportedEncodingException{
		
		ProductCategoryController productCategoryController = new ProductCategoryController();
		
		try {
			ArrayList<Category> categories1 = productCategoryController.getCategoryDB();
			assertEquals(30, categories1.size());
			
			//productCategoryController.getCategoryId();
			String name = productCategoryController.getCategoryName(37);
			assertEquals("Organic", name);
			//productCategoryController.get
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
