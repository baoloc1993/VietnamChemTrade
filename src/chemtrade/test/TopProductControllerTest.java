package chemtrade.test;

import java.util.ArrayList;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.homepage.TopProductController;
import chemtrade.entity.Product;



public class TopProductControllerTest extends TestCase {

	
	public void testRetrieveDatabase () throws Exception{

		TopProductController topProductController = new TopProductController();
		ArrayList<Product> topProduct = topProductController.getTopProduct();
		assertEquals(1082, topProduct.get(0).getProductId());
		assertEquals("https://www.facebook.com/TradeasiaInternationalPte.Ltd", topProduct.get(0).getFacebookUrl());
		assertEquals("trade.asia", topProduct.get(0).getSkypeId());
		assertEquals("https://twitter.com/SreeTradeasia", topProduct.get(0).getTwitterUrl());
		assertEquals("Acetic Acid 99.85% (South Korea Origin)", topProduct.get(0).getProductName());
		assertEquals("AceticAcidMSDS.pdf", topProduct.get(0).getMsds());
		assertEquals("AceticAcidSouthKorea.pdf", topProduct.get(0).getSpecification());
		
		
		assertEquals(53, topProduct.size());
		ArrayList<ArrayList<Product>> wrapperTopProduct = new ArrayList<ArrayList<Product>>();

		int i = 0;
		while (i < (topProduct.size()/6)*6){
			ArrayList<Product> products = new ArrayList<Product>();
			for (int j = i; j < 6; j++){
				products.add(topProduct.get(j));
			}
			wrapperTopProduct.add(products);
			i = i+6;
		}
		ArrayList<Product> products2 = new ArrayList<Product>();
		for (int j = i; j < 6; j++){
			
			products2.add(topProduct.get(j));
		}
		wrapperTopProduct.add(products2);
		//wrapperTopProduct.add((ArrayList<Product>) topProduct.subList(i, topProduct.size()));
		assertEquals(1082, wrapperTopProduct.get(0).get(0).getProductId());
		assertEquals(9, wrapperTopProduct.size());

	}
}
