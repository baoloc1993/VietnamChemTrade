package chemtrade.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.homepage.LatestEventController;
import chemtrade.controller.homepage.TopProductController;
import chemtrade.entity.Event;
import chemtrade.entity.Product;

public class LatestEventControllerTest extends TestCase{

	public void testRetrieveDatabase () throws Exception{

		LatestEventController latestEventController = new LatestEventController();
		ArrayList<Event> latestEvent = latestEventController.getLatestEvent();
		assertEquals(3, latestEvent.get(0).getId());
		assertEquals("Chemtech World Expo 2015", latestEvent.get(0).getTitle());
		assertEquals("CHEMTECH World Expo 2015 will create a common platform to bring the entire ecosystem of the chemicals manufacturing and the allied services providing sectors for 27th time in India. Concurrent events include EPC World Expo, Industry Automation &amp; Control World Expo , Pumps Valves &amp; Fittings World Expo; and international conferences on Refining &amp; Petrochemicals and Specialty Chemicals.", latestEvent.get(0).getDescription());
		assertEquals("http://www.chemtech-online.com/", latestEvent.get(0).getLink());
		assertEquals("uploads/news/1650238945ChemtechWorldExpo.jpg", latestEvent.get(0).getImg());
		assertEquals("2015-01-28", latestEvent.get(0).getDate());
		assertEquals("Mumbai, India", latestEvent.get(0).getLocation());
		assertEquals(1, latestEvent.get(0).getActive());
		assertEquals(0, latestEvent.get(1).getActive());
		
		
		assertEquals(5, latestEvent.size());

	}
}
