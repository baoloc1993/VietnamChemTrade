package chemtrade.controller.homepage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.json.JSONObject;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.EmailController;
@WebServlet("/enquiry")
public class QuickEnquiryController extends HttpServlet implements Constant{


    
    
	Connection conn;
	String test;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String mobile = req.getParameter("contact");
			String country = req.getParameter("countryCode");
			String productName = req.getParameter("product");
			String message = req.getParameter("comments");
			//String createdOn = req.getParameter("created_on");
		//	String ipAddress = req.getParameter("ip_addres");
			String ipAddress = req.getRemoteAddr();
			//String remoteAddr = request.getRemoteAddr();
//	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
//	        reCaptcha.setPrivateKey(CAPTCHA_PRIVATE_KEY);
//

				createQuickEnquery(name, email,mobile,country,productName,message, ipAddress);
	
		}catch (Exception e){
			resp.sendError(500);
		}
		
	}
	
	/**
	 * Create a enquiry and add to table tbl_quickenquiry 
	 * @param name
	 * @param email
	 * @param mobile
	 * @param country
	 * @param productName
	 * @param message
	 * @param approvedStt
	 * @param createdOn
	 * @param ipAddress
	 * @throws Exception 
	 */
	public boolean createQuickEnquery(String name, String email, String mobile, String country,
			String productName, String message, String ipAddress) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			/*
			 * Format the date
			 */
			Date date = Calendar.getInstance().getTime();
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
            String dateformat = sdf.format(date);
            

			conn = ConnectionManager.getConnection();
			String sql = "insert into tbl_quickenquiry (enq_id,enq_code,name,email_id,mobile_no,country,product_name,messege,approved_sts,created_on,ip_address) "
					+ "values (0,'QE-001','" + name + "','" + email + "','" + mobile + "','" + country + "','" + productName + "','" + message + "',0,'"  + dateformat + "','" + ipAddress + "')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			
			sendEmail(name, email, mobile, productName, message);
			return true;
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	/**
	 * Check captcha is valid
	 */
//	public boolean isCaptchaValid(String captchaResponse){
//		String urlStr = "https://www.google.com/recaptcha/api/siteverify?secret=" + CAPTCHA_PRIVATE_KEY
//				+ "&response=" + captchaResponse;
//		String response = "";
//		try {
//			URL url = new URL(urlStr);
//			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//			
//		
//			String strTemp = "";
//			while (null != ( strTemp = br.readLine())) {
//				response += strTemp;
//			}
//			System.out.println (response);
//			JSONObject jObject = new JSONObject(response);
//			String success = jObject.getString("success");
//			if (success.compareTo("false") == 0) return false;
//			return true;
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return true;
//		}
//		
//	}
//	public boolean isCaptchaValid(HttpServletRequest request){
//
//
//        return reCaptchaResponse.isValid();
//          
//	}
	
	/**
	 * Sending Email function
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
	public void sendEmail(final String name, final String email, final String contact,
			final String product, final String message) throws Exception {
		String header=ROOT+"images/email_header.jpg";
		String footer=ROOT+"images/email_footer.jpg";
		//String to = letterId; 
		
		String mailBodyHeader = setMailBodyHeader(name, header);
	    String adminMailBodyHeader = setAdminMailBodyHeader(header,name);
		String mailBodyDetail = setMailBodyDetail(name, email, contact,product, message);
		String mailBodyFooter = setMailBodyFooter(footer);
		String adminMailBodyFooter = setAdminMailBodyFooter();

		String mailBody = mailBodyHeader+mailBodyDetail+mailBodyFooter;
		String adminMailBody = adminMailBodyHeader+ mailBodyDetail+adminMailBodyFooter+mailBodyFooter;
		test = mailBody;

		EmailController mailController = new EmailController();
		mailController.sendEmailViaGmail(email, mailBody, "Yêu cầu nhanh");
		 
		//	return test;
       
		
	   // this.mailSender.send(msg);
	    
	}




	private String setAdminMailBodyFooter() {
		String 	adminMailBodyFooter = "<tr><td height=\"10\"></td></tr>";
		 		adminMailBodyFooter += "<tr><td colspan=\"4\"><b>This e-mail was sent from Quick Form on <a href=\"www.chemtradeasia.com\">chemtradeasia.com</a> </b></td></tr>";
		 		adminMailBodyFooter += "<tr><td height=\"10\"></td></tr>";
		return adminMailBodyFooter;
	}

	private String setMailBodyFooter(String footer) {
		String 	mailBodyFooter = "<tr><td height=\"10\"></td></tr>";
		 		mailBodyFooter += "<tr><td colspan=\"4\">Thân,</td></tr><tr><td height=\"10\"></td></tr>";
	 			mailBodyFooter += "<tr><td colspan=\"4\">Tradeasia Team</td></tr>";
	 			mailBodyFooter += "<tr><td height=\"10\"></td></tr>";
	 			mailBodyFooter += "<tr>";
	 			mailBodyFooter += "<td colspan=\"3\"><img src=\""+footer+"\"></td>";
	 			mailBodyFooter += "</tr>";
	 			mailBodyFooter += "</table>";
		return mailBodyFooter;
	}

	/**
	 * E-mail body
	 * @param name
	 * @param email
	 * @param contact
	 * @param product
	 * @param message
	 * @return
	 */
	private String setMailBodyDetail(String name, String email, String contact,
			String product, String message) {
		String 	mailBodyDetail = "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<td colspan=\"3\">Thông tin yêu cầu.</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Tên</th><td width=\"17\">:</td><td width=\"302\">"+name+"</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Email</th><td width=\"17\">:</td><td width=\"302\">"+email+"</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Điện thoại</th><td width=\"17\">:</td><td width=\"302\">"+contact+"</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Sản phẩm</th><td width=\"17\">:</td><td width=\"302\">"+product+"</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
				mailBodyDetail += "<tr>";	
				mailBodyDetail += "<th width=\"159\" scope=\"row\" align=\"left\">Yêu cầu</th><td width=\"17\">:</td><td width=\"302\">"+message+"</td>";
				mailBodyDetail += "</tr>";
				mailBodyDetail += "<tr><td height=\"10\"></td></tr>";
		return mailBodyDetail;
	}

	private String setAdminMailBodyHeader(String header, String name) {
		String  adminMailBodyHeader = "";
				adminMailBodyHeader += "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
				adminMailBodyHeader += "<tr>";
				adminMailBodyHeader += "<td colspan=\"3\"><img src=\"" +header+ " \"></td>";
				adminMailBodyHeader += "</tr>";
				adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				adminMailBodyHeader += "<tr>";
				adminMailBodyHeader += "<td colspan=\"3\">Hi,</td>";
				adminMailBodyHeader += "</tr>";
				adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				adminMailBodyHeader += "<tr>";
				adminMailBodyHeader += "<td colspan=\"3\">You have a new Product quick enquiry.</td>";
				adminMailBodyHeader += "</tr>";
				adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				adminMailBodyHeader += "<tr>";
				adminMailBodyHeader += "<td colspan=\"3\">From: " + name + "</td>";
				adminMailBodyHeader += "</tr>";
				adminMailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				adminMailBodyHeader += "</table>";
		return adminMailBodyHeader;
	}

	private String setMailBodyHeader(String name, String header) throws SQLException {
		String insertId = getMaxID();
		String 	mailBodyHeader = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
				mailBodyHeader += "<tr>";
				mailBodyHeader += "<td colspan=\"3\"><img src=\""+header+"\"></td>";
				mailBodyHeader += "</tr>";
				mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				mailBodyHeader += "<tr>";
				mailBodyHeader += "<td colspan=\"3\">Chào  "+ name + ",</td>";
				mailBodyHeader += "</tr>";
				mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				mailBodyHeader += "<tr>";
				mailBodyHeader += "<td colspan=\"3\">Tradeasia International Pte. Ltd xin gửi lời chào tới bạn!</td>";
				mailBodyHeader += "</tr>";
				mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				mailBodyHeader += "<tr>";
				mailBodyHeader += "<td colspan=\"3\">Cảm ơn bạn vì đã tin tưởng Tradeasia.</td>";
				mailBodyHeader += "</tr>";
				mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
				mailBodyHeader += "<tr>";
				mailBodyHeader += "<td colspan=\"3\"><a href=\"" + ROOT + "confirmEnquiry?id="+insertId+"\">Click vào đường dẫn dưới đây để xác nhận yêu cầut.</a></td>";
				mailBodyHeader += "</tr>";
		return mailBodyHeader;
	}
	
	/**
	 * Get max ID from table tbl_quickenquiry
	 * @throws SQLException 
	 * return latestId +1
	 */
	
	private String getMaxID() throws SQLException{
		String id = "";
		Connection conn;
		
		conn = ConnectionManager.getConnection();
		String sql = "SELECT max(idd) as max FROM tbl_quickenquiry";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		id =  String.valueOf(rs.getInt(1));
		return id;
	}
}
