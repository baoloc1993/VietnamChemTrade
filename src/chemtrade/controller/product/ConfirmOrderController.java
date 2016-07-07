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
@WebServlet("/confirmOrder")
public class ConfirmOrderController extends HttpServlet {

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
            String id = request.getParameter("id");
            actionConfirmOrder(id);
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
            request.getRequestDispatcher("confirm-submission.jsp").forward(request, response);
        }

    }

    public void actionConfirmOrder(String id) throws Exception {
    	Connection conn = null;
        

            conn = ConnectionManager.getConnection();
            String sql = "select count(*) as cnt from tbl_order where order_id=" + id + " AND `approve_sts`='0'";
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //System.out.println (rs.getString(1));
            if (rs.getString(1).compareTo("0") == 0) {
                throw new SQLException();
            } else {
                String sql2 = "UPDATE tbl_order SET `approve_sts` = 1 where `order_id` = '" + id + "';";           
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
                + "                            <div class=\"text-info\">Order Request Confirmation</div>\n"
                + "                            <br>\n"
                + "                            <center> Thank you for order request.</center>\n"
                + "                           Your order has been confirmed. We will contact you the soonest regarding your order. \n"
                + "                            We really appreciate your time and we look forward to doing business with you.\n"
                + "                            <br><br>\n"
                + "                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        <a href=\"home.jsp\" class=\"btn btn-info btn1\" style=\"width:150px;\">Back to Home</a>\n"
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
                + "                            <div class=\"text-info\">Order Request Confirmation</div>\n"
                + "                            <br>\n"
                + "                            <center>No Record Received.</center>\n"
                + "                        Sorry, No record was received. If you have confirmed this submission before, please ignore this message."
                + "<br> <br>If this is your first time, kindly fill in your details for the product you are ordering in the form and submit again."
                + "<br>Thank you. Tradeasia will contact you shortly in regards to this submission once we have received it.\n"
                + "                            We really appreciate your time and we look forward to doing business with you.\n"
                + "                            <br><br>\n"
                + "                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        <a href=\"home.jsp\" class=\"btn btn-info btn1\" style=\"width:150px;\">Back to Home</a>\n"
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
