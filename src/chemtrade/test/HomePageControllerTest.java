package chemtrade.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.homepage.HomePageController;
import chemtrade.controller.homepage.HomePageController.WrapperBanners;
import chemtrade.controller.homepage.HomePageController.WrapperProducts;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Product;
import junit.framework.TestCase;

public class HomePageControllerTest extends TestCase{

	public void testHandleRequestView() throws Exception{
			HomePageController homePageController = new HomePageController();


	}
	
//	public void testTopProduct(){
//		HomePageController homePageController = new HomePageController();
//		ArrayList<Product> topProducts = new ProductController().getTopProducts();
//		//System.out.println (topProducts.size());
//		assertEquals(53, topProducts.size());
//		
//		ArrayList<WrapperProducts> wrapperProducts = homePageController.configWrapperProduct(topProducts);
//		assertEquals(14, wrapperProducts.size());
//		//ArrayList<WrapperBanners> wrapperBanners = homePageController.getBanners();
////		System.out.println (wrapperBanners.size());
////		System.out.println (wrapperBanners.get(0).getBanner().getName());
////		System.out.println (wrapperBanners.get(0).getBanner().getFilepath());
//	}
	
	public void testGetBanner() throws SQLException{
		HomePageController homePageController = new HomePageController();
		
		ArrayList<WrapperBanners> wrapperBanners = homePageController.getBanners();
		System.out.println (wrapperBanners.size());
		for (WrapperBanners wrapperBanners2 : wrapperBanners){
			System.out.println (wrapperBanners2.getActive());
			System.out.println (wrapperBanners2.getIndex());
			//System.out.println (wrapperBanners2.getBanner().getName());
			System.out.println (wrapperBanners2.getBanner().getName());
			System.out.println (wrapperBanners2.getBanner().getFilepath());
			System.out.println (wrapperBanners2.getBtnColor());
			System.out.println (wrapperBanners2.getBtnLink());
			System.out.println (wrapperBanners2.getBtnName());
		}
		
	}
	

}
