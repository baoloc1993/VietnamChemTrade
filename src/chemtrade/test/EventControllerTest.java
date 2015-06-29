package chemtrade.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.event.EventController;
import chemtrade.controller.event.EventController.EventWrapper;
import chemtrade.entity.Event;
import junit.framework.TestCase;

public class EventControllerTest extends TestCase {
	
	public void testGetDatabase(){
		EventController eventController = new EventController();
		
		//Test if request = null;
		EventWrapper eventwrapper = eventController.getEventByDate("",1);
		ArrayList<Event> latestEvent =  eventwrapper.getResults();
		assertEquals(1, latestEvent.get(0).getId());
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
	
	public void testHandleRequest() throws Exception{
		EventController eventController = new EventController();
		
        
        //assertEquals("jsp/hello.jsp", modelAndView.getViewName());
        
        
        
        
	}

}
