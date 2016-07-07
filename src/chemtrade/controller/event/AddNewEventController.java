package chemtrade.controller.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.websocket.Session;





import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.EmailController;
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
@WebServlet("/addEvent")
public class AddNewEventController extends HttpServlet implements Constant{
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
			int salutation = Integer.parseInt(request.getParameter("contactSalution"));
			String firstName = (String) request.getParameter("contactFName");
			String middleName = (String) request.getParameter("contactMName");
			String lastName = (String) request.getParameter("contactLName");
			String countryCode = (String) request.getParameter("callCode");
			String areaCode = (String) request.getParameter("areaCode");
			String phone = (String) request.getParameter("companyPhone");
			String email = (String) request.getParameter("contactEmail");
			String eventName = (String) request.getParameter("title");
			String eventDate = (String) request.getParameter("date");
			String eventLocation = (String) request.getParameter("contactLocation");
			String eventLink = (String) request.getParameter("link");
			String description = (String) request.getParameter("description");
			alert = addEventToDatabase(salutation,firstName, middleName, lastName, eventName, eventLocation,
					description, eventLink, countryCode, phone, areaCode, email, eventLocation, eventDate);
			sendEmail(firstName, email, phone, eventName, eventLink, eventDate, eventLocation, description);
			//request.setAttribute("error", alert);
			
			//request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}catch(Exception e){
			//request.setAttribute("error", e.toString());
			response.sendError(500);
			//request.getRequestDispatcher("index").forward(request, response);
		}
	}
	
	@Override
	/**
	 * Handle the medthod GET from JSP
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String selectedDate = req.getParameter("date");
		EventWrapper eventWrapper = new EventController().getEventByDate(selectedDate,1);
		events = eventWrapper.getResults();
		   String verificationCode = "";
	        for (int i = 0; i < 6; i++) {
	            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
	            verificationCode += rand;
	        }
	        req.setAttribute("vCode", verificationCode);
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
	 * @throws SQLException 
	 */
	public String addEventToDatabase(int salutation,
			String firstName, String middleName, String lastName, String title,
			String location, String description, String link, String countryCode, String phone, String areaCode, String email, String address, String date) throws SQLException {
		
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
	    
	    
	        conn = ConnectionManager.getConnection();
	        
	        String sqlGetNumberRow = "SELECT max(news_id) FROM `tbl_news`";
	        PreparedStatement ps = conn.prepareStatement(sqlGetNumberRow);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id= 0;
            //System.out.println (rs.getString(1));
            id = Integer.parseInt(rs.getString(1)) +1;
            String sql= "INSERT INTO `tbl_news` (`news_id`, `news_title`, `news_desc`, `news_link`, `news_img`, `date`, `location`, `salutation`, `first_name`, `middle_name`, `last_name`, `country_code`, `area_code`, `phone_number`, `emailid`, `to_date`, `approved_sts`, `status`, `created_on`, `ip_address`) VALUES "
	        
	                + "(" + id + ", '" + title + "','" + description + "','" + link + "','','" + dateR + "','" + location + "', '" + salutation + "', '" + firstName + "', '" + middleName + "', '" + lastName + "', '"  + countryCode + "', '" + areaCode + "', '" + phone + "', '" + email + "','0000-00-00 00:00:00','0','',  '" + str_date2 + "', '" + address+"');";
	        //System.out.println (sql);
            System.out.println(sql);
	        ps = conn.prepareStatement(sql);
           ps.execute();
	    
            return alert;
	}
	public void sendEmail(final String firstNm, final String email, final String contact,
            final String eventTitle, final String eventLink, final String eventDate, final String eventLocation,
            final String eventDesc) throws Exception {

        String header = ROOT + "images/email_header.jpg";
        String footer = ROOT + "images/email_footer.jpg";

        String mailBodyHeader = setMailBodyHeader(firstNm, header);
        String adminMailBodyHeader = setAdminMailBodyHeader(header, firstNm);
        String mailBodyDetail = setMailBodyDetail(firstNm, email, contact, eventTitle, eventLink, eventDate, eventLocation, eventDesc);
        String mailBodyFooter = setMailBodyFooter(footer);
        String adminMailBodyFooter = setAdminMailBodyFooter(footer);

        String mailBody = mailBodyHeader + mailBodyDetail + mailBodyFooter;
        String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter;
        EmailController emailController = new EmailController();
        
        emailController.sendEmailViaGmail(email, mailBody, "Event Submission Confirmation");
        
        emailController.sendEmailViaGmail(emailController.getAdminEmail(), mailBody," New Event Submission – Chemtradeasia Portal");

        // this.mailSender.send(msg);
    }

    

    private String setAdminMailBodyFooter(String footer) {
        String adminMailBodyFooter = "<tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\"><b>This e-mail was sent from a Add New Event Form on <a href=\"localhost:8084\">en.chemtreadeasia.co.id</a> </b></td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\"></td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "   \n"
                + "  <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "  \n"
                + "</table>";
        return adminMailBodyFooter;
    }

    private String setAdminMailBodyHeader(String header, String firstNm) {
        String adminMailBodyHeader = "<table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">\n"
                + " \n"
                + " <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Hi,</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">You have a new event posting request.</td>\n"
                + "  </tr>\n"
                + "<tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">From " + firstNm + "</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\">Event details are follows.</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>";
        return adminMailBodyHeader;
    }

    private String setMailBodyFooter(String footer) {
        String mailBodyFooter = "<tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\">Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất. </td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Thân,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "   \n"
                + "  <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "  \n"
                + "</table>";
        return mailBodyFooter;
    }

    private String setMailBodyDetail(String firstNm, String email, String contact,
            String eventTitle, String eventLink, String eventDate, String eventLocation, String eventDesc) {
        String mailBodyDetail = "<tr>\n"
                + "    <th align=\"left\">Tên</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + firstNm + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "    <th align=\"left\">Email</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + email + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th align=\"left\">Điện thoại</th>\n"
                + "    <th>:</th>\n"
                + "     <td align=\"left\">" + contact + "</td>\n"
                + "  </tr>\n"
                + "<tr>\n"
                + "    <th align=\"left\">Tên sự kiện</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + eventTitle + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "    <th align=\"left\">Link sự kiện</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + eventLink + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th align=\"left\">Thời gian</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + eventDate + "</td>\n"
                + "  </tr>\n"
                + "<tr>\n"
                + "    <th align=\"left\">Địa điểm</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + eventLocation + "</td>\n"
                + "  </tr>\n"
                + "<tr>\n"
                + "    <th align=\"left\">Chi tiết sự kiện</th>\n"
                + "    <th>:</th>\n"
                + "    <td align=\"left\">" + eventDesc + "</td>\n"
                + "  </tr>";
        return mailBodyDetail;
    }

    private String setMailBodyHeader(String name, String header) throws SQLException {

        //EventDAO eventDAO = new EventDAO();
    	
        String insertId = getLastID() + "";

        String mailBodyHeader = " <table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">\n"
                + " \n"
                + " <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Chào bạn " + name + ",</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Tradeasia International Pte. Ltd xin gửi lời chào tới bạn!</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Thank you for your event submisstion to Tradeasia.</td>\n"
                + "  </tr>\n"
                + "<td colspan=\"3\"><a href=\"" + ROOT + "confirmEvent?eid=" + insertId + "\">Click vào link dưới đây để xác nhận</a></td>"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\">Thông tin event.</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>";
        return mailBodyHeader;
    }
    
    public int getLastID() {
    	Connection conn = null;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(news_id) as max FROM tbl_news");
            ResultSet rs = ps.executeQuery();
            
            rs.next() ;

                return rs.getInt("max");

            

        } catch (Exception e) {
            return 0;
        }
		//return 0; 

       // return 0;

    }
}
