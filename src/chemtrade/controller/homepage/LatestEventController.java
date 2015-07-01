package chemtrade.controller.homepage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Event;
import chemtrade.entity.Product;

/**
 * 
 * @author ngolebaoloc
 * 
 * Get all the latest event of website from database
 *
 */
public class LatestEventController{
	private ArrayList<Event> latestEvent = new ArrayList<>();
	


	/**
	 * Get the list of Top Product
	 */
	private void databaseRetrival(){
		Connection conn = null;

	      try {
	         //String URL = "jdbc:mysql://127.0.0.1/local";
	         
	         conn = ConnectionManager.getConnection();
	         String sql = "select * from  tbl_news where `status`='A' order by news_id";
	         //System.out.println (sql);
	         PreparedStatement ps = conn.prepareStatement(sql);
	         //ps.setString(1, user);
	         //ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 Event event = new Event();
		         //Set Attribute of Event
		         event.setId(rs.getInt(1));
		         event.setTitle(rs.getString(2));
		         event.setDescription(rs.getString(3));
		         event.setLink(rs.getString(4));
		         event.setImg(rs.getString(5));
		         event.setDate(rs.getString(6));
		         event.setLocation(rs.getString(7));
		         event.setCreatedOn(rs.getString(8));
	        	 latestEvent.add(event);
	           
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  latestEvent.add(new Event());
	         
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      
	}

	public ArrayList<Event> getLatestEvent() {
		databaseRetrival();
		//Set the first event is active
		if (latestEvent.size() > 0){
			latestEvent.get(0).setActive(1);
		}
		return latestEvent;
	}


}
