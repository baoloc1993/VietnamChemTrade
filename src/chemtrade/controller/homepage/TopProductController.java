package chemtrade.controller.homepage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Product;

/**
 * 
 * 
 * @author ngolebaoloc
 *
 *Get the top product from database
 */
@WebServlet("/products-top")
public class TopProductController extends HttpServlet{
	private ArrayList<Product> topProduct = new ArrayList<>();
	


	/**
	 * Get the list of Top Product
	 */
	private void databaseRetrival(){
		Connection conn = null;

	      try {
	         //String URL = "jdbc:mysql://127.0.0.1/local";
	         
	         conn = ConnectionManager.getConnection();
	         String sql = "select a.product_id as pid, b.product_name as pname, b.product_image, b.msds, b.specification, b.facebook_url, "
	        	 		+ "b.twitter_url, b.skype_id from tbl_home_products a, "
	         		+ "tbl_product b where a.product_id=b.product_id order by pname ASC";
	         //System.out.println (sql);
	         PreparedStatement ps = conn.prepareStatement(sql);
	         //ps.setString(1, user);
	         //ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 
	        	 Product product = new Product();
//	        	 String sql2 = "select a.facebook_id, b.twitter_id, c.skype_id from tbl_facebook_accounts a, "
//	        	 		+ "tbl_twitter_accounts b, tbl_skype_accounts c where a.id = "+ rs.getString(6) + " OR b.id=" + rs.getString(7) + " OR c.id=" + rs.getString(8);
//		         System.out.println (sql2);
	        	 PreparedStatement ps2 = conn.prepareStatement("select a.facebook_id, b.twitter_id, c.skype_id from tbl_facebook_accounts a, "
		        	 		+ "tbl_twitter_accounts b, tbl_skype_accounts c where a.id = "+ rs.getString(6) + " OR b.id=" + rs.getString(7) + " OR c.id=" + rs.getString(8));
		         ResultSet rs2 = ps2.executeQuery();
		         rs2.first();
//		        System.out.println (rs2.getFetchSize());
		         //Set Attribute of Product
		         product.setProductId(rs.getInt(1));
		         product.setProductName(rs.getString(2));
		         product.setProductImage(rs.getString(3));
		         product.setMsds(rs.getString(4));
		         product.setSpecification(rs.getString(5));
		         product.setFacebookUrl(rs2.getString(1));
		         product.setTwitterUrl(rs2.getString(2));
		         product.setSkypeId(rs2.getString(3));
	        	 //product.setProductId(rs.getInt	(1));
	        	 //product.setProductName(rs.getString(2));
	        	 topProduct.add(product);
	           
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  topProduct.add(new Product());
	         
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      
	}

	public ArrayList<Product> getTopProduct() {
		databaseRetrival();
		return topProduct;
	}

}
