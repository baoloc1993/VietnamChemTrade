package chemtrade.controller.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.event.EventController.EventWrapper;
import chemtrade.entity.Event;


@WebServlet("/event-details")
public class SingleEventController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String selectedDate = req.getParameter("date");
			EventWrapper eventWrapper = new EventController().getEventByDate(selectedDate,1);
			ArrayList<Event> events = eventWrapper.getResults();
			
			req.setAttribute("events", events);
			String id = req.getParameter("id");
			Event event = getEventByID(id);
			req.setAttribute("event", event);
			req.getRequestDispatcher("jsp/event/eventSingle.jsp").forward(req, resp);

		}catch (Exception e){
			req.getRequestDispatcher("event").forward(req, resp);
		}
		
	}
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//		String id = request.getParameter("id");
//		
//		
//		Event event = getEventByID(id);
//		ModelAndView model = new ModelAndView("event/eventSingle");
//		model.addObject("event", event);
//		return model;
//	}
	
	public Event getEventByID(String id) throws SQLException {
		
		Connection conn;
		
			conn = ConnectionManager.getConnection();
			String sql = "select * from tbl_news where status='A' and news_id = " + id + ";";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        Event event = new Event();
	        while (rs.next()) {
            	
		         //Set Attribute of Event
		         event.setId(rs.getInt(1));
		         event.setTitle(rs.getString(2));
		         event.setDescription(rs.getString(3));
		         event.setLink(rs.getString(4));
		         event.setImg(rs.getString(5));
		         event.setDate(rs.getString(6));
		         event.setLocation(rs.getString(7));
		         event.setCreatedOn(rs.getString(8));
	        	 
            }
	        return event;
		
		        
        //Query all the event
        
	}

}
