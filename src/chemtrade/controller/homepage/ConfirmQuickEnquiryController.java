package chemtrade.controller.homepage;

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


@WebServlet("/confirmEnquiry")
public class ConfirmQuickEnquiryController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//try{
			
		String message = "";
		try {
			String id  = req.getParameter("id");
			actionConfirmEnquiry(id);
			message = getSucessMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = getFailMessage();
		}finally{
			req.setAttribute("message", message);
			req.getRequestDispatcher("jsp/index/confirm_enquiry.jsp").forward(req, resp);
			}
	}

	/**
	 * Confirm query. Change aprroved_stt in database from 0 to 1
	 * @param id
	 * @throws SQLException 
	 */
	public void actionConfirmEnquiry(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn;
		
		
			conn = ConnectionManager.getConnection();
			String sql = "select count(*) as cnt from tbl_quickenquiry where `idd`='" + id + "' AND `approved_sts`='0'";
			System.out.println(sql);
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//System.out.println (rs.getString(1));
			if (rs.getString(1).compareTo("0") == 0 ){
				throw new SQLException();
			}else{
				String sql2 =  "UPDATE tbl_quickenquiry SET `approved_sts` = 1 where `idd` = '" + id + "';";
				//System.out.println (sql2);
				PreparedStatement ps2  = conn.prepareStatement(sql2);
				ps2.execute();
				
			}
			
	}
	
	/**
	 * Success message when confirm success
	 * @return
	 */
	private String getSucessMessage(){
		String message = "";
		message += "<img src=\"images/confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
        message += "<br>";
        message += "<div class=\"confirmation-mainheader\">Enquiry Confirmation</div>";
        message += "<hr>";
        message += "<div class=\"confirmation-details\">";
        message += "Thank you for submitting your enquiry. Tradeasia will contact you shortly in regards to this enquiry.";
        message += "<br>";
        message += "We really appreciate your time and we look forward to doing business with you.";
        message +="<br>";
        message += "</div>";
        message +="<a href=\"index\"><input class=\"confirmation-btn\" value=\"Back to Home\" type=\"submit\"></a>";
		
		return message;
	}
	/**
	 * Fail message when confirm fail
	 * @return
	 */
	private String getFailMessage(){
		String message = "";
		message += "<img src=\"images/no-confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
        message +="<br>";
        message += "<div class=\"confirmation-mainheader\">No Record Received.</div>";
        message += "<hr>";
        message += "<div class=\"confirmation-details\">";
        message += "Sorry, No record was received."; 
        message += "<br>Kindly fill in your details for the product you are enquiring on and submit again.";
        message += "<br>Thank you. Tradeasia will contact you shortly in regards to this enquiry once we have received it.";
        message += "<br>";
        message += "We really appreciate your time and we look forward to doing business with you.";
        message += "<br>";
        message += "</div>";
        message += "<a href=\"index\"><input class=\"confirmation-btn\" value=\"Back\" type=\"button\"></a>";
        return message;
	}
}
