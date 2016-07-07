/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.event;


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
@WebServlet(name = "ConfirmEventController", urlPatterns = {"/confirmEvent"})
public class ConfirmEventController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        try {
            String id = request.getParameter("eid");
            actionConfirmEvent(id);
            message = getSucessMessage();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            message = getFailMessage();
        } catch (Exception e) {
            e.printStackTrace();
            message = getFailMessage();
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/confirm-submission.jsp").forward(request, response);
        }
    }

    public void actionConfirmEvent(String id) throws Exception {
    	Connection conn = null;
        

            conn = ConnectionManager.getConnection();
            String sql = "select count(*) as cnt from tbl_news where `news_id`='" + id + "' AND `approved_sts`='0'";
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //System.out.println (rs.getString(1));
            if (rs.getString(1).compareTo("0") == 0) {
                throw new SQLException();
            } else {
                String sql2 = "UPDATE tbl_news SET `approved_sts` = 1 where `news_id` = '" + id + "';";           
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
                + "                            <div class=\"text-info\">Event Posting Confirmation</div>\n"
                + "                            <br>\n"
                + "                            <center> Cảm ơn bạn đã đăng sự kiện.</center>\n"
                + "                            Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất. \n"
                + "                           Chúng tôi hy vọng có cơ hội làm việc với bạn trong tương lai\n"
                + "                            <br><br>\n"
                + "                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        <a href=\"index\" class=\"btn btn-info btn1\" style=\"width:150px;\">Quay về trang chủ</a>\n"
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
                + "                            <div class=\"text-info\">Event Posting Confirmation</div>\n"
                + "                            <br>\n"
                + "                            <center>Không tìm thấy dữ liệu</center>\n"
                + "                        Xin lỗi, dữ liệu không được tìm thấy. Nếu bạn đã xác nhận từ trước, xin bỏ qua thông báo này."
                + "<br> <br>Nếu đây là lần đầu bạn xác nhận, xin hãy điền lại thông tin và xác nhận một lần nữa."
                + "<br>Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất..\n"
                + "                             Chúng tôi hy vọng có cơ hội làm việc với bạn trong tương lai.\n"
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
