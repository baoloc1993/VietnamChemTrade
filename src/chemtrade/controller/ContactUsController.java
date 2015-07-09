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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Contact;
import chemtrade.entity.CountryCode;

/**
 * 
 * @author ngolebaoloc
 *
 */

@WebServlet("/contact-us")
public class ContactUsController extends HttpServlet {
    
	 
    
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       
//        Connection conn = null; //connection to the database
        String replyMessage = ""; //message will be sent back to the client
        
        try {
        	 String firstName = request.getParameter("firstname");
             String lastName = request.getParameter("lastname");
             String descr = request.getParameter("description");
             String email_ = request.getParameter("email");
             String country_ = request.getParameter("country");
             String message_ = request.getParameter("message");
             
            replyMessage = addContactFormToDatabase(firstName, lastName, descr, email_,
					country_, message_);

        }
        catch (SQLException e){
            replyMessage = "ERROR: " + e.getMessage();
            e.printStackTrace();
        }
        
        HttpSession session = request.getSession(false);
        //request.setAttribute("databaseMessage", replyMessage); //sets message in session
        request.getRequestDispatcher("index").forward(request, response);
        
        
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
