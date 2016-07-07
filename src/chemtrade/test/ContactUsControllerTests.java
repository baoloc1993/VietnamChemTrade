package chemtrade.test;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import junit.framework.TestCase;



import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.ContactUsController;


import chemtrade.entity.Contact;

public class ContactUsControllerTests extends TestCase {

    
   
    public void testAddContact() throws SQLException{
    	try{
	    	Connection conn = ConnectionManager.getConnection();
	    	String firstName = "first Name";
	    	String lastName = "last name";
	    	String descr = "Description";
	    	String email_ = "email";
	    	String country_ = "SG";
	    	String message_ = "Message";
	    	String sql = "INSERT INTO tbl_contact_us "
	                + "(firstname, lastname, description, email, country, message) values ('" + firstName + "','" + lastName + "','" + descr + "','" + email_ + "','" + country_ +  "','" + message_ + "');";
	        PreparedStatement ps =  conn.prepareStatement(sql);
	        ps.execute();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}