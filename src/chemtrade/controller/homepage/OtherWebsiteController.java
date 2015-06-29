package chemtrade.controller.homepage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Product;
import chemtrade.entity.Website;

/**
 * 
 * @author ngolebaoloc
 *
 *	Get the list of website from database
 */

public class OtherWebsiteController {
	private ArrayList<Website> otherWebsite = new ArrayList<>();
	


	/**
	 * Get the list of other website
	 */
	private void databaseRetrival(){
		Connection conn = null;

	      try {
	         //String URL = "jdbc:mysql://127.0.0.1/local";
	         
	         conn = ConnectionManager.getConnection();
	         String sql ="SELECT * FROM tbl_other_websites";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 
	        	 Website website = new Website();

		         //Set Attribute of Product
		         website.setId(rs.getInt(1));
		         website.setName(rs.getString(2));
		         website.setLink(rs.getString(3));
		         
	        	 //product.setProductId(rs.getInt(1));
	        	 //product.setProductName(rs.getString(2));
	        	 otherWebsite.add(website);
	           
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  otherWebsite.add(new Website());
	         
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      
	}

	public ArrayList<Website> getOtherWebsite() {
		databaseRetrival();
		return otherWebsite;
	}


}
