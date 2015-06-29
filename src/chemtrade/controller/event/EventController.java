package chemtrade.controller.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Event;

/**
 * 
 * @author ngolebaoloc
 * Controll the data of Event page
 * use link /event.html
 *
 */
@SuppressWarnings("deprecation")
@WebServlet("/event")
public class EventController extends HttpServlet{
	private static String date = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE = 3;
	/**
	 * Handle the method POST from JSP, action event
	 */
//	@Override
	

	
	
	@Override
	/**
	 * Handle the method GET from JSP, action 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//			String date = req.getParameter("event-box");
//			String showPage = req.getParameter("page");
			String selectedDate = req.getParameter("date");
			int showPage = 1;
			try{
				showPage = Integer.parseInt(req.getParameter("page"));
			}catch(Exception e){
				showPage = 1;
			}
			EventWrapper eventWrapper = getEventByDate(selectedDate,showPage);
			ArrayList <String> dates =  new ArrayList<String>();
			for (Event event : eventWrapper.getResults()){
				//Just get YYYY-MM
				dates.add(event.getDate().substring(0,7));
			}
			
			req.setAttribute("dates", dates);
			req.setAttribute("wrapper", eventWrapper);
			req.getRequestDispatcher("jsp/event/event.jsp").forward(req, resp);
		
		
	}

	/**
	 * Get Event by Date
	 * @param selectedDate
	 * @param id
	 * @return
	 */
	public EventWrapper getEventByDate(String selectedDate, int showPage){
		
		//System.out.print(request.toString());
		EventWrapper eventWrapper = new EventWrapper();
		//final int PAGE_SIZE = 3;
        
        //int showPage = 1;
        ArrayList<Event> results = new ArrayList<Event>();
        String sql= "";
        if (selectedDate == null || selectedDate.equals("")){
        	selectedDate = "-";
        }
        
        try{
        	//selectedDate = req.getParameter("date");
        	
        	//NEW PAGE AND DATE
        	if (selectedDate.equals("-") || selectedDate == null) {
        		
        		sql = "select * from tbl_news where status='A' order by news_id;";
        	//NEW DATE	
            }else{
            	date = selectedDate;
            	sql = "select * from tbl_news where status='A' AND date like '" + date +"%' order by news_id;";
            }
        }catch (Exception e){
        	if (date.equals("")){
        		selectedDate = "";
    			sql = "select * from tbl_news where status='A' order by news_id;";
    		//NEW PAGE
    		}else{
    			sql = "select * from tbl_news where status='A'AND date like '" + date + "%'order by news_id;";
    		}
        	
        
        	 
        }
        
        getEventFromDatabase(eventWrapper,showPage, results, sql);
        return eventWrapper;
        
	}

	private void getEventFromDatabase(EventWrapper eventWrapper, int showPage, ArrayList<Event> results,
			String sql) {
		Connection conn;
     
        try {
            conn = ConnectionManager.getConnection();
            
            //Query all the event
            
            PreparedStatement ps = conn.prepareStatement(sql);
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
	        	 results.add(event);
            }
            eventWrapper.setResults(results);
//            dates = date.toArray(new String[0]);
//            Arrays.sort(dates);
//            rs = sql.executeQuery("select * from tbl_news where status='A' and date like" + "\"" + selectedDate + "%\"" + " order by news_id;");
//            rs.last();
            //Get the number of result
            int recordCount = results.size();
            eventWrapper.setRecordCount(recordCount);
            //Calculate page COunt
            int pageCount= 1;
            if (recordCount % PAGE_SIZE == 0){
            	pageCount= recordCount/ PAGE_SIZE;
            }else{
            	pageCount = recordCount/ PAGE_SIZE + 1;
            }
            eventWrapper.setPageCount(pageCount);
            
            
            
            if (showPage <= 1) {
                showPage = 1;
            }
            if (showPage >= pageCount) {
                showPage = pageCount;
            }
            int position = (showPage - 1) * PAGE_SIZE;
            eventWrapper.setPosition(position);
            //rs.absolute(position);
    
        }catch (Exception e){
        	e.printStackTrace();
	    	  results.add(new Event());
        }
        eventWrapper.setPageSize(PAGE_SIZE);
        eventWrapper.setShowPage(showPage);
	}
	

	/**
	 * 
	 * @author ngolebaoloc
	 * Class which will be transfered to view (event.jsp)
	 * 
	 * 1. List of event
	 * 2. position of event
	 * 3. recordCount
	 * 4. pageSize
	 *5. showPage
	 */
	public class EventWrapper {
		private  ArrayList<Event> results = new ArrayList<Event>();
		private int position;
		private int recordCount;
		private int pageSize;
		private int showPage;
		private int pageCount;
		
		
		public void setPosition(int position) {
			this.position = position;
		}
		
		public int getPosition() {
			return position;
		}
		
		public void setResults(ArrayList<Event> results) {
			this.results = results;
		}
		
		public ArrayList<Event> getResults() {
			return results;
		}

		public int getRecordCount() {
			return recordCount;
		}

		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getShowPage() {
			return showPage;
		}

		public void setShowPage(int showPage) {
			this.showPage = showPage;
		}

		public int getPageCount() {
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
	}
	
	/**
	 * Handle the form index.jsp
	 * @author ngolebaoloc
	 *
	 */
	public class EventDate{
		private String date;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
		
		
	}

}
