package chemtrade.controller;

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
import chemtrade.entity.CountryCode;


/**
 * 
 * @author ngolebaoloc
 * Get the list of Country Code and their name from database
 *
 */
public class CountryCodeController{
private ArrayList<CountryCode> countryCodes = new ArrayList<>();
	


	/**
	 * Get the list of countries
	 */
	private void databaseRetrival(){
		Connection conn = null;

	      try {
	         
	         conn = ConnectionManager.getConnection();
	         String sql ="SELECT country_id, country, calling_code, ccode FROM tbl_countries";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 
	        	 CountryCode countryCode = new CountryCode();

		         //Set Attribute of Product
		         countryCode.setId(rs.getInt(1));
		         
		         countryCode.setCountry(rs.getString(2));
		         countryCode.setCallingCode(rs.getString(3));
		         countryCode.setcCode(rs.getString(4));
	        	 countryCodes.add(countryCode);
	           
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  countryCodes.add(new CountryCode());
	         
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      
	}

	public ArrayList<CountryCode> getCountryCodes() {
		databaseRetrival();
		return countryCodes;
	}
	
	public String getCountryName(String ccode){
		Connection conn = null;

	      try {
	         
	         conn = ConnectionManager.getConnection();
	         String sql ="SELECT country FROM tbl_countries where `ccode` = \"" + ccode + "\"";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();
	         
	         rs.next();
	        return rs.getString(1);	 
	      } catch (Exception e){
	    	  return "";
	      }
	}

}

