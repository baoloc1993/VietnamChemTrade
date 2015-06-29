package chemtrade.controller.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.event.EventController.EventDate;
import chemtrade.controller.event.EventController.EventWrapper;
import chemtrade.entity.CountryCode;
import chemtrade.entity.CreateEvent;
import chemtrade.entity.Event;

/**
 * Follow tutorial : http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
 * @author ngolebaoloc
 *
 */
@SuppressWarnings("deprecation")
@WebServlet("/addnewevent")
public class AddNewEventController extends HttpServlet{
	String alert = "";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Handle the method POST from JSP, action addevent
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try{
			int salutation = Integer.parseInt(request.getParameter("salutation"));
			String firstName = (String) request.getParameter("fname");
			String middleName = (String) request.getParameter("mname");
			String lastName = (String) request.getParameter("lname");
			String countryCode = (String) request.getParameter("ccode");
			String areaCode = (String) request.getParameter("acode");
			String phone = (String) request.getParameter("phone");
			String email = (String) request.getParameter("email");
			String eventName = (String) request.getParameter("ename");
			String eventDate = (String) request.getParameter("edate");
			String eventLocation = (String) request.getParameter("elocat");
			String eventLink = (String) request.getParameter("elink");
			String description = (String) request.getParameter("desc");
			alert = addEventToDatabase(salutation,firstName, middleName, lastName, eventName, eventLocation,
					description, eventLink, countryCode, phone, areaCode, email, eventLocation, eventDate);
			
			request.setAttribute("error", alert);
			
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}catch(Exception e){
			//request.setAttribute("error", e.toString());
			
			request.getRequestDispatcher("index").forward(request, response);
		}
	}
	
	@Override
	/**
	 * Handle the medthod GET from JSP
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		EventWrapper eventWrapper = new EventController().getEventByDate(req);
		events = eventWrapper.getResults();
		
		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
		req.setAttribute("events", events);
		req.setAttribute("salutationList", createEvent.getSalutationList());
		req.setAttribute("codes", countryCodes);
		req.setAttribute("alert", alert);
		
		req.getRequestDispatcher("jsp/event/addNewEvent.jsp").forward(req, resp);
		
	}
	
	ArrayList<Event> events = new ArrayList<Event>();
	CreateEvent createEvent = new CreateEvent();
	
	

	/**
	 * @param request
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param title
	 * @param location
	 * @param description
	 * @param link
	 * @param countryCode 
	 * @param phone 
	 * @param areaCode 
	 * @param email 
	 * @param address 
	 * @return alert
	 */
	public String addEventToDatabase(int salutation,
			String firstName, String middleName, String lastName, String title,
			String location, String description, String link, String countryCode, String phone, String areaCode, String email, String address, String date) {
		
		Connection conn = null;
	    
	    String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	   // String date = request.getParameter("date");
	    String dateR;
	    try{
	        dateR = date.substring(6, 10) + "-" + date.substring(0, 2) + "-" + date.substring(3, 5);
	    }
	    catch (Exception e1){
	        dateR = "0000-00-00";
	    }
	    
	    try {
	        conn = ConnectionManager.getConnection();
	        
	        String sqlGetNumberRow = "SELECT COUNT(*) FROM `tbl_news`";
	        PreparedStatement ps = conn.prepareStatement(sqlGetNumberRow);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id= 0;
            //System.out.println (rs.getString(1));
            id = Integer.parseInt(rs.getString(1)) +1;
            String sql= "INSERT INTO `tbl_news` (`news_id`, `news_title`, `news_desc`, `news_link`, `news_img`, `date`, `location`, `salutation`, `first_name`, `middle_name`, `last_name`, `country_code`, `area_code`, `phone_number`, `emailid`, `to_date`, `approved_sts`, `status`, `created_on`, `ip_address`, `approved_by`"
	        
	                + "(" + id + ", '" + title + "','" + description + "','" + link + "','','" + dateR + "','" + location + "', '" + salutation + "', '" + firstName + "', '" + middleName + "', '" + location + "', '" + lastName + "', '" + countryCode + "', '" + areaCode + "', '" + phone + "', '" + email + "','0000-00-00 00:00:00,0,'',  '" + str_date2 + "', '" + address + "', '');";
	        //System.out.println (sql);
	        ps = conn.prepareStatement(sqlGetNumberRow);
            rs = ps.executeQuery();
	        alert = "<script>alert('Successful');</script>";
	    } catch (Exception e1) {
	        e1.printStackTrace();
	        alert = "<script>alert('Fail to upload');</script>";
	    }
		return alert;
	}

}
