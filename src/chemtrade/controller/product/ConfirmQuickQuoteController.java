/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ASUS
 */
@WebServlet("/confirmQuickQuote")
public class ConfirmQuickQuoteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //try{

        String message = "";
        try {
            String id = req.getParameter("qid");
            actionConfirmQuote(id);
            message = getSucessMessage();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            message = getFailMessage();
        } catch (Exception e) {
            e.printStackTrace();
            message = getFailMessage();
        } finally {
            req.setAttribute("message", message);
            req.getRequestDispatcher("jsp/index/confirm-submission.jsp").forward(req, resp);
        }
    }

    /**
     * Confirm query. Change aprroved_stt in database from 0 to 1
     *
     * @param id
     * @throws SQLException
     */
   
    	 public void actionConfirmQuote(String id) throws Exception {
    		 	Connection conn= null;
    	        

    	            conn = ConnectionManager.getConnection();
	            String sql = "select count(*) as cnt from tbl_quickquote where `quote_id`='" + id + "' AND `approved_status`='0'";
	           
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            //System.out.println (rs.getString(1));
	            if (rs.getString(1).compareTo("0") == 0) {
	                throw new SQLException();
	            } else {
	                String sql2 = "UPDATE tbl_quickquote SET `approved_status` = 1 where `quote_id` = '" + id + "';";           
	                ps = conn.prepareStatement(sql2);
	                ps.execute();
	
	            }
	        

    	       

    	    }

    

    /**
     * Success message when confirm success
     *
     * @return
     */
    private String getSucessMessage() {

        String message = " <center><img width=\"150\" src=\"images/confirmation-icon.png\" alt=\"landing page\"><br>\n"
                + "\n"
                + "                        <div class=\"col-md-12\" >\n"
                + "                            <div class=\"text-info\"Xác nhận yêu cầu</div>\n"
                + "                            <br>\n"
                + "                            <center>Cảm ơn bạn đã đưa ra yêu cầu.</center>\n"
                + "                         Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất\n"
                + "                           Chúng tôi hy vọng sẽ được làm việc với bạn trong tương lai.\n"
                + "                            <br><br>\n"
                + "                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        <a href=\"index\" class=\"btn btn-info btn1\" style=\"width:150px;\">Back to Home</a>\n"
                + "\n"
                + "                    </center>";

        return message;
    }

    /**
     * Fail message when confirm fail
     *
     * @return
     */
    private String getFailMessage() {

        String message = " <center><img width=\"150\" src=\"images/no-confirmation-icon.png\" alt=\"landing page\"><br>\n"
                + "\n"
                + "                        <div class=\"col-md-12\" >\n"
                + "                            <div class=\"text-info\">Quote Enquiry Confirmation</div>\n"
                + "                            <br>\n"
                + "                            <center>Không tìm thấy dữ liệu</center>\n"
                + "                        Xin lỗi, không tìm thấy dữ liệu.Nếu bạn đã từng xác nhận qua đường dẫn này, xin hãy bỏ qua thông báo này."
                + "<br> <br>Nếu đây là lần đầu tiên bạn xác nhận, xin hãy điền lại thông tin và gửi tới chúng tôi một lần nữa."
                + "<br>Xin cám ơn. Tradeasia sẽ liên lạc với bạn trong thời gian sớm nhất.\n"
                + "                            Chúng tôi hy vọng có thể tiếp tục làm việc với bạn trong tương lai.\n"
                + "                            <br><br>\n"
                + "                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        <a href=\"index\" class=\"btn btn-info btn1\" style=\"width:150px;\">Back to Home</a>\n"
                + "\n"
                + "                    </center>";
        return message;
    }

}
