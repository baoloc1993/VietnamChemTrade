package chemtrade.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.homepage.OtherWebsiteController;
import chemtrade.controller.homepage.TopProductController;
import chemtrade.entity.Event;
import chemtrade.entity.Product;
import chemtrade.entity.Website;

public class CountryCodeControllerTest extends TestCase{

	public void testRetrieveDatabase () throws Exception{
		
		OtherWebsiteController otherWebsiteController = new OtherWebsiteController();
		ArrayList<Website> otherWebsite = otherWebsiteController.getOtherWebsite();
		assertEquals(1, otherWebsite.get(0).getId());
		assertEquals("Detergent chemicals", otherWebsite.get(0).getName());
		assertEquals("http://detergent-chemicals.net", otherWebsite.get(0).getLink());
		
		
		assertEquals(9, otherWebsite.size());

	}
}
