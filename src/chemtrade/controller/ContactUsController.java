/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller;

/**
 *
 * @author Qianpin
 */
import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.entity.Contact;
import chemtrade.entity.CountryCode;

/**
 * 
 * @author ngolebaoloc
 *
 */

@WebServlet("/contact-us")
public class ContactUsController extends HttpServlet implements Constant {
    
	 
    

       
//        Connection conn = null; //connection to the database
    	 protected void doPost(HttpServletRequest request,
    	            HttpServletResponse response) throws ServletException, IOException {
    	        String firstName = request.getParameter("firstname");
    	        String lastName = request.getParameter("lastname");
    	        //title
    	        String descr = request.getParameter("description");
    	        String email_ = request.getParameter("email");
    	        String country_ = request.getParameter("country");
    	        String message_ = request.getParameter("message");

    	        Connection conn = null; //connection to the database
    	        //String replyMessage = "none"; //message will be sent back to the client

    	        try {
    	            //connects to the database
    	            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    	            conn = ConnectionManager.getConnection();

    	            //constructs SQL statement
    	            String sql = "INSERT INTO tbl_contact_us "
    	                    + "(firstname, lastname, description, email, country, message) values ('" + firstName + "','" + lastName + "','" + descr + "','" + email_ + "','" + country_ +  "','" + message_ + "');";
    	            PreparedStatement ps =  conn.prepareStatement(sql);
    	            ps.execute();
    	            request.getRequestDispatcher("contact-us").forward(request,response);
    	            //int row = stmt.executeUpdate(); //sends statement to the database server
    	          

    	        } catch (Exception e) {
    	        	response.sendError(511,e.getMessage());
    	        	
    	           // replyMessage = "ERROR: " + e.getMessage();
    	            //e.printStackTrace();
    	        } 
    	        //HttpSession session = request.getSession(false);//because request doesn't work
    	       // request.setAttribute("databaseMessage", replyMessage); //sets message in session
    	        //RequestDispatcher rd = request.getRequestDispatcher("contact-us2.jsp");
    	       // rd.forward(request, response);
    	        return;
    	//response.sendRedirect("contact-us.jsp");

    	    }
        
        
    
    	  /**
    	     * Sending Email function
    	     *
    	     * @param letterId
    	     * @param ROOT
    	     * @param name
    	     * @param email
    	     * @param contact
    	     * @param product
    	     * @param message
    	     * @throws Exception
    	     * @throws MessagingException
    	     */
    	    public void sendEmail(final String firstName, final String lastName, final String descr,
    	            final String email_, final String country_, final String message_) throws Exception {
    	        String header = "http://" + ROOT + "/images/email_header.jpg";
    	        String footer = "http://" + ROOT + "/images/email_footer.jpg";

    	        String mailBody = " <table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">\n"
    	                + " \n"
    	                + " <tr>\n"
    	                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td>\n"
    	                + "  </tr>\n"
    	                + "  <tr><td height=\"10\"></td></tr>\n"
    	                + "  <tr>\n"
    	                + "    <td colspan=\"3\">Dear " + firstName + ",</td>\n"
    	                + "  </tr>\n"
    	                + "  <tr><td height=\"10\"></td></tr>\n"
    	                + "  <tr>\n"
    	                + "    <td colspan=\"3\">Greetings from Tradeasia International Pte. Ltd!</td>\n"
    	                + "  </tr>\n"
    	                + "  <tr><td height=\"10\"></td></tr>\n"
    	                + "  <tr>\n"
    	                + "    <td colspan=\"3\">Thank you for contacting us. We will review it and get back to you soon.</td>\n"
    	                + "  </tr>\n"
    	                + "  <tr><td height=\"10\"></td></tr>\n"
    	                + "    \n"
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

    	        String adminMailBodyHeader = setAdminMailBodyHeader(header, firstName, lastName);
    	        String mailBodyDetail = setMailBodyDetail(firstName, lastName, descr, email_, country_, message_);
    	        String adminMailBodyFooter = setAdminMailBodyFooter(footer);

    	        String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter;
    	        EmailController emailController = new EmailController();
    	        emailController.sendEmailViaGmail(email_, mailBody, "Contact Us");
    	        //sendEmailViaGmail(email_, mailBody);
    	        String adminEmail = emailController.getAdminEmail();
    	        emailController.sendEmailViaGmail(adminEmail, adminMailBodyFooter, "Contact Us – Chemtradeasia Portal");
    	       // sendAdminEmail(adminMailBody);

    	        // this.mailSender.send(msg);
    	    }

    	   
    	    private String setAdminMailBodyFooter(String footer) {
    	        String adminMailBodyFooter = "<tr><td height=\"10\"></td></tr>";
    	        adminMailBodyFooter += "<tr><td colspan=\"4\"><b>This e-mail was sent from Contact Us form on <a href=\"www.chemtradeasia.co.id\">chemtradeasia.co.id</a> </b></td></tr>";
    	        adminMailBodyFooter += "<tr><td height=\"10\"></td></tr>"
    	                + "  <tr>\n"
    	                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td>\n"
    	                + "  </tr>\n"
    	                + "  \n"
    	                + "</table>";
    	        return adminMailBodyFooter;
    	    }

    	    /**
    	     * E-mail body
    	     *
    	     * @param name
    	     * @param email
    	     * @param contact
    	     * @param product
    	     * @param message
    	     * @return
    	     */
    	    private String setMailBodyDetail(final String firstName, final String lastName, final String descr,
    	            final String email_, final String country_, final String message_) {
    	        String mailBodyDetail = "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<td colspan=\"3\">The enquiry details are follows.</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Name</th><td width=\"17\">:</td><td width=\"302\">" + firstName + " " + lastName + "</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Mail Id</th><td width=\"17\">:</td><td width=\"302\">" + email_ + "</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Title</th><td width=\"17\">:</td><td width=\"302\">" + descr + "</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Country</th><td width=\"17\">:</td><td width=\"302\">" + country_+ "</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        mailBodyDetail += "<tr>";
    	        mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Message</th><td width=\"17\">:</td><td width=\"302\">" + message_ + "</td>";
    	        mailBodyDetail += "</tr>";
    	        mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
    	        return mailBodyDetail;
    	    }

    	    private String setAdminMailBodyHeader(String header, String fname, String lname) {
    	        String adminMailBodyHeader = "";
    	        adminMailBodyHeader += "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
    	        adminMailBodyHeader += "<tr>";
    	        adminMailBodyHeader += "<td colspan=\"3\"><img src=\"" + header + " \"></td>";
    	        adminMailBodyHeader += "</tr>";
    	        adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
    	        adminMailBodyHeader += "<tr>";
    	        adminMailBodyHeader += "<td colspan=\"3\">Hi,</td>";
    	        adminMailBodyHeader += "</tr>";
    	        adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
    	        adminMailBodyHeader += "<tr>";
    	        adminMailBodyHeader += "<td colspan=\"3\">You have a new query from Contact Us form.</td>";
    	        adminMailBodyHeader += "</tr>";
    	        adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
    	        adminMailBodyHeader += "<tr>";
    	        adminMailBodyHeader += "<td colspan=\"3\">From: "+ fname+ " " + lname + "</td>";
    	        adminMailBodyHeader += "</tr>";
    	        adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
    	        return adminMailBodyHeader;
    	    }
    
    /**
     * Add info of contact form to database
     * @param firstName
     * @param lastName
     * @param descr
     * @param email_
     * @param country_
     * @param message_
     * @return
     * @throws SQLException
     */
	private String addContactFormToDatabase(String firstName,
			String lastName, String descr, String email_, String country_,
			String message_) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		String replyMessage = "";
		//connects to the database
		
		//conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		
		//constructs SQL statement
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_contact "
		        + "(firstname, lastname, description, email, country, message) values (?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,firstName);
		stmt.setString(2,lastName);
		stmt.setString(3,descr);
		stmt.setString(4,email_);
		stmt.setString(5,country_);
		stmt.setString(6,message_);
		
		int row = stmt.executeUpdate(); //sends statement to the database server
		if (row > 0) {
		    replyMessage = "We've received your query. Thank you.";
		}
		conn.close();
		return replyMessage;
	}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	Contact contact = new Contact();
		String databaseMessage = "";
		ArrayList<CountryCode> countryCodes = new ArrayList<CountryCode>();
		try{
			String countryId = req.getParameter("cid");
			if (countryId == null){
				countryId = "1";
			}
			
				contact = getContactByCountryId(countryId);
				countryCodes = new CountryCodeController().getCountryCodes();
				req.setAttribute("contact", contact);
				req.setAttribute("message", databaseMessage);
				req.setAttribute("ccodes", countryCodes);
		        req.getRequestDispatcher("jsp/contact-us2.jsp").forward(req, resp);
		
			
		}catch (Exception e){
			req.setAttribute("error",e);
			req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
		}
		
		

    	
    }

    /**
     * Get Contact based on the Country 
     * @param countryId
     * @return
     */
	public Contact getContactByCountryId (String countryId){
		Connection conn = null;
        
        try {
            conn = ConnectionManager.getConnection();
            String sql = "select * from tbl_contact where id = " + countryId;
          //  System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //while (rs.next()) {
            Contact c = getContact(rs.getString("id"), rs.getString("label"), rs.getString("name"),
                    rs.getString("address"), rs.getString("province"), rs.getString("zip_code"),
                    rs.getString("country"), rs.getString("tel"), rs.getString("fax"),
                    rs.getString("email"), rs.getString("business_days"), rs.getString("business_hours"),
                    rs.getString("google_map"));
            //}
            return c;
        } catch (Exception e) {
        	e.printStackTrace();
        	return new Contact();
        }
        
		
	}
	
	/**
	 * Create a contact based on some required information
	 * @param id
	 * @param label
	 * @param name
	 * @param address
	 * @param province
	 * @param zip_code
	 * @param country
	 * @param tel
	 * @param fax
	 * @param email
	 * @param business_days
	 * @param business_hours
	 * @param google_map
	 * @param flag
	 * @return
	 */
	 private Contact getContact(String id, String label, String name, String address,
	            String province, String zip_code, String country, String tel, String fax,
	            String email, String business_days, String business_hours, String google_map) {
	        Contact c = new Contact();
	        c.setId(id);
	        c.setLabel(label);
	        c.setName(name);
	        c.setAddress(address);
	        c.setProvince(province);
	        c.setZip_code(zip_code);
	        c.setCountry(country);
	        c.setTel(tel);
	        c.setFax(fax);
	        c.setEmail(email);
	        c.setBusiness_days(business_days);
	        c.setBusiness_hours(business_hours);
	        c.setGoogle_map(google_map);

	        return c;
	    }


}
