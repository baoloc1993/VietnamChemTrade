package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;


@WebServlet("/confirmProduct")
public class ConfirmProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id  = req.getParameter("id");
		String message = "";
		try {
			confirmProduct(id);
			message = getSuccessMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = getFailMessage();
		}finally{
			req.setAttribute("message", message);
			req.getRequestDispatcher("jsp/product/confirm_product.jsp").forward(req, resp);
		}
	}
	
	private String getSuccessMessage(){
		 String message = "<tr>";
         message += "<td>";
         message +="<img src=\"images/confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
         message +="<br>";
         message += "<div class=\"confirmation-mainheader\">Enquiry Confirmation</div>";
         message += "<hr>";
         message += "<div class=\"confirmation-details\">";
         message += "Thank you for submitting your enquiry. Tradeasia will contact you shortly in regards to this enquiry.";
         message += "<br>";
         message += "We really appreciate your time and we look forward to doing business with you.";
         message +="<br>";
         message +="</div>";
         message += "<a href=\"index\"><input class=\"confirmation-btn\" value=\"Back to Home\" type=\"submit\"></a>";
          message += "</td>";
          message += "</tr>";
          
          return message;
	}
	
	private String getFailMessage(){
		 String message = "<tr>";
        message += "<td>";
        message +="<img src=\"images/no-confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
        message +="<br>";
        message += "<div class=\"confirmation-mainheader\">No Record Received.</div>";
        message += "<hr>";
        message += "<div class=\"confirmation-details\">";
        message += "Sorry, No record was received. ";
        message += "<br>";
        message += "Kindly fill in your details for the product you are enquiring on and submit again.";
        message +="<br>";
        message += "We really appreciate your time and we look forward to doing business with you.";
        message += "<br>";
        message +="</div>";
        message += " <a href=\"index\"><input class=\"confirmation-btn\" value=\"Back\" type=\"button\"></a>";
         message += "</td>";
         message += "</tr>";
         
         return message;
         
	}
	
	public void confirmProduct(String id) throws SQLException{
		Connection conn = ConnectionManager.getConnection();
		String sql="select count(*) from tbl_enquiry where `enquiry_id`='"+ id + "' and `approved_status` = 0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (rs.getInt(1) == 1){
			String sql2 =  "UPDATE tbl_enquiry SET `approved_status` = 1 where `enquiry_id` = '" + id + "';";
			//System.out.println (sql2);
			PreparedStatement ps2  = conn.prepareStatement(sql2);
			ps2.execute();
		}else{
			throw new SQLException();
		}
	}
	
	
	
}
