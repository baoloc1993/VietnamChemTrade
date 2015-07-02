package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.EmailController;
import chemtrade.controller.homepage.DownloadCenterController;

@WebServlet("/quickContact")
public class QuickContactController extends HttpServlet implements Constant{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String name =  req.getParameter("name");
		//String insertID =  req.getParameter("insertID");
		String phone = req.getParameter("phone");
		String productID = req.getParameter("productID");
		String productName = req.getParameter("productName");
		String requirement = req.getParameter("requirement");
		String ipAddress = req.getRemoteAddr();
		String type = req.getParameter("fileType");
		try {
			
			addToDatabase(name, email, phone, requirement, productID, ipAddress, type, productName);
			String insertID =  String.valueOf(getLastEnquiryID());
	    	updateTblSetting(insertID);
	    	//downloadFile(productID, resp,type, req);
	    	//addTopDownload(productID);
	    	
			sendEmail(email, name, insertID, phone, productID, productName, requirement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendError(404,e.getMessage());
		}
	}
	
	
	/**
	 * Download File
	 * @param productID
	 * @param resp
	 * @param request 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void downloadFile(String productID, HttpServletResponse resp, String type, HttpServletRequest request) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
        String FilePath = request.getSession().getServletContext().getRealPath("/upload") + "\\";

		String sql = "";
		if (type.compareTo("A") == 0){								//MSDS
			sql = "select product_dir,msds from tbl_product where `product_id` = '" + productID +"'";
		}else if (type.compareTo("B") == 0){						//TDS
			sql = "select product_dir,specification from tbl_product where `product_id` = '" + productID +"'";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		String fileDir = "images/" + rs.getString(1) + "/" + rs.getString(2);
		DownloadCenterController downloadCenterController = new DownloadCenterController();
    	downloadCenterController.downFile(FilePath, resp, fileDir);
		
	}

	public void sendEmail(String email, String name, String insertID, String phone, String productID, String productName, String requirement) throws Exception{
		//Session session = EmailConfiguration.settingGmail();
		String header="http://"+ROOT+"/images/email_header.jpg";
		String footer="http://"+ROOT+"/images/email_footer.jpg";
		//String to = letterId; 
		
		String mailBody = getMessage(header, name, insertID, email, phone, productID, productName, requirement, footer);
	    
		//test = mailBody;
		EmailController emailController = new EmailController();
		emailController.sendEmailViaGmail(email, mailBody, "Quick Contact");

		 //sendEmailViaGmail(email, mailBody);
	}

	
	
	
	private String getMessage(String header, String name, String insertID, String email, String phone, String productID, String productName, String requirement, String footer){
		String message = "";
		
        message +="<table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">";

        message +="<tr>";
        message += "<td colspan=\"3\"><img src=" + header + "></td>";
        message += "</tr>";
        message += "<tr><td height=\"10\"></td></tr>";
        message += "<tr>";
        message += "<td colspan=\"3\">Dear " + name + ",</td>";
        message += "</tr>";
        message += "<tr><td height=\"10\"></td></tr>";
        message += "<tr>";
        message += "<td colspan=\"3\">Greetings from Tradeasia International Pte. Ltd!</td>";
        message +="</tr>";
        message +="<tr><td height=\"10\"></td></tr>";
        message += "<tr>";
        message += "<td colspan=\"3\">Thank you for your enquiry with Tradeasia International Pte. Ltd. Your enquiry Id is" +insertID + "</td>";
        message += "</tr>";
        message +="<tr><td height=\"10\"></td></tr>";

        message += "<tr><td colspan=\"3\" height=\"10\"><a href=\"" + ROOT + "/confirmProduct&id=" + insertID + "\">Please click here to confirm your enquiry about the product.</a></td></tr>";
        message += "<tr><td height=\"10\"></td></tr>";
        message += "<tr>";
        message += "<td colspan=\"3\">Your enquiry details are follows.</td>";
        message +="</tr>";
        message +="<tr><td height=\"10\"></td></tr>";

        message += "<tr>";
        message += "<th width=\"159\" scope=\"row\" align=\"left\">Name</th>";
        message += "<td width=\"17\">:</td>";
        message += "<td width=\"302\">" + name + "</td>";
        message += "</tr>";

		message += "<tr>";
		message += "<th scope=\"row\" align=\"left\">Mail Id</th>";
		message += "<td>:</td>";
		message += "<td>" + email +"</td>";
		message +="</tr>";
		
		message += "<tr>";
		message += "<th scope=\"row\" align=\"left\">Contact Number</th>";
		message += "<td>:</td>";
		message += "<td>" + phone + "</td>";
		message += "</tr>";
		
		message += "<tr>";
		message += "<th scope=\"row\" align=\"left\">Product</th>";
		message += "<td>:</td>";
		message += "<td><a href=\"http://" + ROOT + "/product?id=" + productID + ">" + productName + "</a></td>";
		message +="</tr>";
		
		message += "<tr>";
		message += "<th scope=\"row\" align=\"left\">Requirement</th>";
		message += "<td>:</td>";
		message += "<td>" + requirement + "</td>";
		message += "</tr>";
		
		message += "<tr><td height=\"10\"></td></tr>";
		message += "<tr><td colspan=\"4\" height=\"10\">We will contact you as soon as possible to follow up your order with " + ROOT + "</td></tr>";
		message += "<tr><td height=\"10\"></td></tr>";
		message += "<tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>";
		message += "<tr><td colspan=\"4\">Tradeasia Team</td></tr>";
		message += "<tr><td height=\"10\"></td></tr>";
		
		
		
		message += "<tr>";
		message += "<td colspan=\"3\"><img src=\"" + footer + "\"></td>";
		message += "</tr>";
		
		message += "</table>";
		
		return message;

	}
	/**
     * Get the last id of table tbl_enquiry
     * @return
     */
    public int getLastEnquiryID() {
    	Connection conn;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(enquiry_id) as max FROM tbl_enquiry");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                return rs.getInt("max");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } 

        //if no return result from rs.next(), return 0 as new ID
        return 0;

    }
    
    /**
     * Add quiry to database
     * @param name 
     * @param email 
     * @param phone 
     * @param requirement 
     * @param productID 
     * @param ipAddress 
     * @param type 
     * @param productName 
     * @throws SQLException 
     */
    public void addToDatabase(String name, String email, String phone, String requirement, String productID, String ipAddress, String type, String productName) throws SQLException{
    	Connection conn = ConnectionManager.getConnection(); 
    	
    	String subject = "";
    	if (type.compareTo("A") == 0){
    		subject = "MSDS Download";
    	}else if(type.compareTo("B") == 0) {
    		subject = "TDS Download";
    	}
    	
    	/*
		 * Format the date
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = Calendar.getInstance().getTime();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        String dateformat = sdf.format(date);

    	/*
    	 * Get setting from database
    	 */
    	String sql1= "select next_code from tbl_idsettings where `id`='4'";
    	PreparedStatement ps1 = conn.prepareStatement(sql1); 
    	ResultSet rs1 = ps1.executeQuery();
    	rs1.next();
    	String nextCode = rs1.getString(1);
    	String enqCode = "Enq-" + nextCode;
    	
    	
		String sql2 = "insert into tbl_enquiry (enq_code,name,email_id,cont_no,message,chemical,prd_id,subject,created_on,ip_address, approved_status) values "
    			+ "('" + enqCode + "','" + name + "','"  + email + "','" + phone + "','" + requirement + "','" 
				+ productName + "','" + productID + "','" + subject + "','" + dateformat + "','" + ipAddress + "',0);";
		System.out.println (sql2);
    	PreparedStatement ps2 = conn.prepareStatement(sql2);
    	ps2.execute();
    	
    	
    }
    
    /**
     * update code of tblsetting
     * @throws SQLException 
     */
    public void updateTblSetting(String id) throws SQLException{
    	Connection conn = ConnectionManager.getConnection();
    	String sql = "UPDATE `tbl_idsettings` SET `next_code`='" + id +"' WHERE `id`='4';";
    	PreparedStatement ps2 = conn.prepareStatement(sql);
    	ps2.execute();
    }
    
//    /**
//     * Add quiry to tbl_top_Download table
//     * @throws SQLException 
//     */
//    public void addTopDownload(String id) throws SQLException{
//    	Connection conn =  ConnectionManager.getConnection();
//        String sql = "insert into tbl_top_downloads (product_id) values ('" + id + "')";
//        PreparedStatement ps2 = conn.prepareStatement(sql);
//    	ps2.execute();
//    	
//    }
}
