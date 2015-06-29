package chemtrade.test;

import java.sql.SQLException;
import chemtrade.controller.event.SingleEventController;
import chemtrade.entity.Event;
import junit.framework.TestCase;

public class SingleEventControllerTest extends TestCase {
	
	public void testGetDatabase() throws SQLException{
		
		
		//Test if request = null;
		
		
		Event event = new SingleEventController().getEventByID("1");
		assertEquals(1, event.getId());
		assertEquals("Chemtech World Expo 2015", event.getTitle());
		assertEquals("CHEMTECH World Expo 2015 will create a common platform to bring the entire ecosystem of the chemicals manufacturing and the allied services providing sectors for 27th time in India. Concurrent events include EPC World Expo, Industry Automation &amp; Control World Expo , Pumps Valves &amp; Fittings World Expo; and international conferences on Refining &amp; Petrochemicals and Specialty Chemicals.", event.getDescription());
		assertEquals("http://www.chemtech-online.com/", event.getLink());
		assertEquals("uploads/news/1650238945ChemtechWorldExpo.jpg", event.getImg());
		assertEquals("2015-01-28", event.getDate());
		assertEquals("Mumbai, India", event.getLocation());
		
		
		
	}
	
	public void testHandleRequest() throws Exception{
		
        
        
	}

}
