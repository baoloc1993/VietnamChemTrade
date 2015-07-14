/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller;


import chemtrade.configuration.ConnectionManager;


import chemtrade.configuration.Constant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
@WebServlet("/feedback")
public class FeedbackController extends HttpServlet implements Constant {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws Exception 
     */
    protected void processRequest(HttpServletRequest request) throws Exception {
       // response.setContentType("text/html;charset=UTF-8");

        String fullname = request.getParameter("name");
        String email = request.getParameter("email");
        String comments = request.getParameter("comments");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String ipaddress = request.getRemoteAddr();
        Calendar cal = Calendar.getInstance();
        java.sql.Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
        String timestamp = time + "";

        

       
            //FeedbackDAO feedback = new FeedbackDAO();
            
        addFeedback(fullname, email, comments, rating, timestamp, ipaddress);
        //request.setAttribute("msg", "Thank you! We will review your feedback shortly.");
        sendEmail(fullname, email);
            
        
       // RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
       // rd.forward(request, response);
        return;
    }

    public void sendEmail(final String name, final String email) throws Exception {

        String header = "http://" + ROOT + "/images/email_header.jpg";
        String footer = "http://" + ROOT + "/images/email_footer.jpg";

        String mailBody = " <table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">\n"
                + " \n"
                + " <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Dear " + name + ",</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Greetings from Tradeasia International Pte. Ltd!</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Thank you for submitting your Feedback. Your Feedback is valuable for us. We will get back to you soon.</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "    \n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "   \n"
                + "  <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "  \n"
                + "</table>";
        EmailController emailController = new EmailController();
        System.out.println ("A " + email);
        emailController.sendEmailViaGmail(email, mailBody, "Feedback Received");
        //emailController.sendEmailViaGmail(email, mailBody);

        // this.mailSender.send(msg);
    }
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	req.getRequestDispatcher("jsp/feedback.jsp").forward(req,resp);
    }
 
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendError(510, e.getMessage());
			e.printStackTrace();
		}
    }

    /**
     * Add Feed back to tbl_feedback
     * @param fullname
     * @param email
     * @param comments
     * @param rating
     * @param timestamp
     * @param ipaddress
     * @return
     * @throws SQLException 
     * @throws Exception
     */
    public int addFeedback(String fullname, String email, String comments, int rating, String timestamp, String ipaddress) throws SQLException {
    	Connection conn = null;
        int id = getLastID() + 1;
        int row = 0;

        
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_feedback (id,fullname,email,comments,rating,created_on,ip_address) VALUES (" + id + ",'" + fullname + "','" + email + "','" + comments + "','" + rating + "','" + timestamp + "','" + ipaddress + "')");
            ps.execute(); //sends statement to the database server

        
        
        return row;

    }

    public int getLastID() throws SQLException {
    		Connection conn = null;	
        
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(id) as max FROM tbl_feedback");
            ResultSet rs = ps.executeQuery();

            rs.next() ;

            return rs.getInt("max");

    }

}
