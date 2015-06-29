package chemtrade.controller.homepage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.configuration.EmailConfiguration;
import chemtrade.exception.ExistedEmailException;


@WebServlet ("/subscribe")
public class SubcriberController extends HttpServlet implements Constant {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
			//try {
				try {
					sendEmail(name, email);
					return;
				} catch (ExistedEmailException e) {
					// TODO Auto-generated catch block
					resp.sendError(410, "You have already subscribed newsletter with us.");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					resp.sendError(405);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					resp.sendError(405);
				}
				return;
			//} 
			
		
		
		
	}
	
	
	private void addToDatabase(String name, String email) throws SQLException{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
		
		Connection conn = ConnectionManager.getConnection();
		
        String sql = "insert into tbl_newsletter (name,email_id,date,status) values ('" + name + "','" + email +"','" + date + "','A')";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
	}
	
	/**
	 * Send Email. It has 2 function:
	 * 1. Send mail back to user
	 * 2. Send to contact@chemtradeasia.com
	 * 3. Add email to database
	 * @param header
	 * @param newsName
	 * @param email
	 * @throws SQLException 
	 * @throws MessagingException 
	 * @throws Exception 
	 */
	public void sendEmail(String newsName, String email) throws ExistedEmailException, SQLException, MessagingException {
		String response;
		String header="http://" + ROOT + "/images/email_header.jpg";
		String footer="http://" + ROOT +"/images/email_footer.jpg";
		String mailBody = getMailBody(header, newsName);
		String adminMailBody = getAdminMailBody(header, newsName, email);
		//String host = $_SERVER['HTTP_HOST'];

		//try{
			Connection conn = ConnectionManager.getConnection();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String date = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
			
			String sql = "select email_id as dcheck from tbl_newsletter where `email_id`= '" + email + "'";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	   
	        //If result has no row
	        if (!rs.last()){
	        	addMailBody0(mailBody, newsName, email, adminMailBody);
	        }else{
	        	throw (new ExistedEmailException());
//	        	return "<script>alert('You have already subscribed newsletter with us.');"
//		        		+ " window.location.href = \"index\""
//		        		+ "</script>";
	        	//return;
	        	//adminMailBody += "<tr><td colspan=\"3\" height=\"10\">You have already subscribed newsletter with us</td></tr>";
	        }
	        addMailFooter(mailBody, adminMailBody, footer);
	        
	        sendEmailUser(email, mailBody);
	        sendEmailContact(adminMailBody);
	        addToDatabase(newsName, email);
//	        response = "<script>alert('Please check your email inbox to reconfirm your enquiry.');"
//	        		+ " window.location.href = \"index\""
//	        		+ "</script>";
		//}catch (Exception e){
//			response = "<script>alert('Error: Mail not sent. Please check your Email Address!');"
//					+ " window.location.href = \"index\""
//	        		+ "</script>";
		//}
       // return response;
		
	}
	
	/**
	 * Get mailBody of email
	 * @param header
	 * @param newsName
	 * @return
	 */
	private String getMailBody(String header, String newsName){
		String mailBody = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
		mailBody += "<tr>";
		mailBody += "<td colspan=\"3\"><img src=\""+ header + "\"></td>";
		mailBody += "</tr>";
		mailBody += "<tr><td height=\"10\"></td></tr>";
		mailBody += "<tr>";
		mailBody += "<td colspan=\"3\">Dear "+ newsName + ",</td>";
	 	mailBody += "</tr>";
	 	mailBody += "<tr><td height=\"10\"></td></tr>";
		mailBody += "<tr>";
		mailBody += "<td colspan=\"3\">Greetings from Tradeasia International Pte. Ltd!</td>";
		mailBody += "</tr>";
		mailBody += "<tr><td height=\"10\"></td></tr>";
		
		return mailBody;
	}
	
	/**
	 * Get Admin Mail Body of email
	 * @param header
	 * @param newsName
	 * @param email
	 * @return
	 */
	private String getAdminMailBody(String header, String newsName, String email){
		  String adminMailBody = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
		  adminMailBody += "<tr>";
		  adminMailBody += "<td colspan=\"3\"><img src=\"" + header + "\"></td>";
		  adminMailBody += "</tr>";
		  adminMailBody += "<tr><td height=\"10\"></td></tr>";
		  adminMailBody += "<tr>";
		  adminMailBody += "<td colspan=\"3\">Hi,</td>";
	 	  adminMailBody += "</tr>";
	 	  adminMailBody += "<tr><td height=\"10\"></td></tr>";
		  adminMailBody += "<tr>";
		  adminMailBody += "<td colspan=\"3\">You have a new newsletter subscription.</td>";
		  adminMailBody += "</tr>";
	 	  adminMailBody += "<tr><td height=\"10\"></td></tr>";
	      adminMailBody += "<tr>";
		  adminMailBody += "<td colspan=\"3\">From: " + newsName + "</td>";
		  adminMailBody += "</tr>";
	      adminMailBody += "<tr>";
		  adminMailBody += "<td colspan=\"3\">Email Id: " + email + "</td>";
		  adminMailBody += "</tr>";
	 	  adminMailBody += "<tr><td height=\"10\"></td></tr>";
	 	  
	 	  return adminMailBody;

	}
	
	private void addMailBody0(String mailBody, String newsName, String email, String adminMailBody){
		
		
		mailBody += "<tr>";
		mailBody += "<td colspan=\"3\" height=\"10\">Name: " + newsName + "</td>";
 		mailBody += "</tr>";
 		mailBody += "<tr>";
		mailBody += "<td colspan=\"3\" height=\"10\">Email Id: " + email + "</td>";
 		mailBody += "</tr>";
        mailBody += "<tr>";
		mailBody += "<td colspan=\"3\" height=\"10\">Your Email Id is registered for subscription. We are pleased to render our service to you.</td>";
 		mailBody += "</tr>";
 		mailBody += "<tr><td height=\"10\"></td></tr>";
		mailBody += "</tr>";
		
		
		 adminMailBody += "<tr>";
			adminMailBody += "<td colspan=\"3\" height=\"10\">Name: " + newsName + "</td>";
	 		adminMailBody += "</tr>";
	                adminMailBody += "<tr>";
			adminMailBody += "<td colspan=\"3\" height=\"10\">Email Id: " + email + "</td>";
	 		adminMailBody += "</tr>";
	        adminMailBody += "<tr>";
			adminMailBody += "<td colspan=\"3\" height=\"10\">Your Email Id is registered for subscription. We are pleased to render our service to you.</td>";
	 		adminMailBody += "</tr>";
	 		adminMailBody += "<tr><td height=\"10\"></td></tr>";
			adminMailBody += "</tr>";
	}
	
	/**
	 * Add footer to mail content
	 * @param mailBody
	 * @param adminMailBody
	 * @param footer
	 */
	private void addMailFooter(String mailBody, String adminMailBody, String footer){
	   	 mailBody += "<tr><td height=\"10\"></td></tr>";
	   	 mailBody += "<tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>";
	   	 mailBody += "<tr><td colspan=\"4\">Tradeasia Team</td></tr>";
	   	 mailBody += "<tr><td height=\"10\"></td></tr>";
	   	 mailBody += "<tr>";
	   	 mailBody += "<td colspan=\"3\"><img src=\"'.$footer.'\"></td>";
	   	 mailBody += "</tr>";
	     mailBody += "</table>";
	     
	     adminMailBody += "<tr><td height=\"10\"></td></tr>";
	     adminMailBody += "<tr><td colspan=\"4\"><b>This e-mail was sent from Newsletter Subscription on <a href=\"http://www.chemtradeasia.com\">chemtradeasia.com</a> </b></td></tr>";
	     adminMailBody += "<tr><td height=\"10\"></td></tr>";
	   	 adminMailBody += "<tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>";
	   	 adminMailBody += "<tr><td colspan=\"4\">Tradeasia Team</td></tr>";
	   	 adminMailBody += "<tr><td height=\"10\"></td></tr>";
	   	 adminMailBody += "<tr>";
	   	 adminMailBody += "<td colspan=\"3\"><img src=\"" + footer + "\"></td>";
	   	 adminMailBody += "</tr>";
      	 adminMailBody += "</table>";

	}
	/**
	 * Send email back to the user
	 * @param email
	 * @param mailBody
	 * @throws MessagingException 
	 */
	private void sendEmailUser(String email, String mailBody) throws MessagingException{
		  String subject =  "Newsletter Subscription";
	      String from = "no-reply@chemtradeasia.com"; 
	      Session session = EmailConfiguration.settingGmail();
      
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        //try {
        msg.setFrom(new InternetAddress(USER));
        InternetAddress[] toAddresses = { new InternetAddress(email) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(mailBody);
 
        // sends the e-mail
        Transport.send(msg);
	}
	
	/**
	 * send email to chemtradeasia.com
	 * @throws MessagingException 
	 */
	private void sendEmailContact(String adminMailBody) throws MessagingException{
		String subject = "Newsletter subscription– Chemtradeasia Portal";
		//String to  = "baoloc1993@gmail.com";
		String to  = "contact@chemtradeasia.com";
		String from = "no-reply@chemtradeasia.com"; 
		Session session = EmailConfiguration.settingGmail();
	      
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        //try {
        msg.setFrom(new InternetAddress(USER));
        InternetAddress[] toAddresses = { new InternetAddress(to) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(adminMailBody);
 
        // sends the e-mail
        Transport.send(msg);
	}
	
	
}
