package chemtrade.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import chemtrade.controller.event.AddNewEventController;
import chemtrade.controller.event.EventController;
import chemtrade.controller.event.EventController.EventWrapper;
import chemtrade.entity.Event;

public class AddNewEventControllerTest extends TestCase {
	
	public void testGetDatabase(){
		EventController eventController = new EventController();
		
		//Test if request = null;
		EventWrapper eventwrapper = eventController.getEventByDate("",1);
		ArrayList<Event> latestEvent =  eventwrapper.getResults();
		assertEquals(3, latestEvent.get(0).getId());
		assertEquals("Chemtech World Expo 2015", latestEvent.get(0).getTitle());
		assertEquals("CHEMTECH World Expo 2015 will create a common platform to bring the entire ecosystem of the chemicals manufacturing and the allied services providing sectors for 27th time in India. Concurrent events include EPC World Expo, Industry Automation &amp; Control World Expo , Pumps Valves &amp; Fittings World Expo; and international conferences on Refining &amp; Petrochemicals and Specialty Chemicals.", latestEvent.get(0).getDescription());
		assertEquals("http://www.chemtech-online.com/", latestEvent.get(0).getLink());
		assertEquals("uploads/news/1650238945ChemtechWorldExpo.jpg", latestEvent.get(0).getImg());
		assertEquals("2015-01-28", latestEvent.get(0).getDate());
		assertEquals("Mumbai, India", latestEvent.get(0).getLocation());
		assertEquals(5, latestEvent.size());
		assertEquals(5,eventwrapper.getRecordCount());
		assertEquals(3,eventwrapper.getPageSize());
		assertEquals(1,eventwrapper.getShowPage());
		assertEquals(0,eventwrapper.getPosition());
		assertEquals(3,eventwrapper.getPageSize() + eventwrapper.getPosition());
		
		

	}
	
	
	public void testAddToDatabase(){
		
		AddNewEventController addNewEventController = new AddNewEventController();
		String alert1 = addNewEventController.addEventToDatabase(
				0, "Ngo", "Le Bao", "Loc", "Untitled", "Singapore", "Description", "localhost", "+65", "83745574", "", "baoloc1993@gmail.com", "192.168.0.1", "3-4-2015");
		assertEquals("<script>alert('Successful');</script>", alert1);
				
	}

}
