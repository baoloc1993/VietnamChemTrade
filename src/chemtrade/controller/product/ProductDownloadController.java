/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;



import java.util.*;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.EmailController;
import chemtrade.entity.Product;

/**
 *
 * @author Fla
 */
@WebServlet("/download-single")
public class ProductDownloadController extends HttpServlet implements Constant{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getLocalAddr();
        PrintWriter out = response.getWriter();
        String chem = request.getParameter("id");
        String pgName = request.getParameter("pgnme");
        String dir = "upload/";
        if (chem == null) {
            chem = "A1";
        }
        char f = chem.charAt(0);
        chem = chem.substring(1);
        int id;
        String chemical = "";
        try {
            id = Integer.parseInt(chem);
        } catch (NumberFormatException e2) {
            id = 1;
        }
       // ProductDAO p = new ProductDAO();
        //p.databaseRetrieval();
        ProductController productController = new ProductController();
        ArrayList<Product> list = productController.getProductListFromDB();
        for (Product i : list) {
            if (i.getProductId() == id) {
                chemical = i.getProductName();
                // dir = i.getProduct_dir();
                if (f == 'A') {
                    dir = "images/" + i.getProductDir() + "/" + i.getMsds();
                    //dir += "1.pdf";
                } else if (f == 'B') {
                    dir = "images/" + i.getProductDir() + "/" + i.getSpecification();
                    //dir += "2.pdf";
                }
                break;
            }
        }
        String name = request.getParameter("name");
        if (name == null) {
            out.print("<script>location.href='" + pgName + "';</script>");
            name = "a";
        }
        String email = request.getParameter("email_id");
        if (email == null || !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            out.print("<script>location.href='" + pgName + "';</script>");
        }
        String phone = request.getParameter("phone");
        if (phone == null) {
            phone = "";
        }
        String requirement = request.getParameter("requirement");
        if (requirement == null) {
            requirement = "";
        }

        RequestDispatcher rd = request.getRequestDispatcher(pgName);

        if (f == 'A') {
            try {
                postForm(name, email, phone, requirement, chemical, "MSDS Download", id, ip);
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                rd.forward(request, response);
                return;
            }
        } else if (f == 'B') {
            try {
                postForm(name, email, phone, requirement, chemical, "TDS Download", id, ip);
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                rd.forward(request, response);
                return;
            }

        } else {
            //send email to user to confirm enquiry
            try {
                int success = postForm(name, email, phone, requirement, chemical, "Mail", id, ip);

                if (pgName.equals("product-details.jsp")) {

                    request.setAttribute("id", id);
                }

                if (success > 0) {
                    sendEmail(name, email, phone, requirement, chemical, id);
                    request.setAttribute("message", "Thank you. Please check your email to confirm your enquiry.");
                } else {
                    request.setAttribute("message", "An error has occured. Contact our email for support.");
                }
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
            }
            rd.forward(request, response);
            return;
        }

        out.print("<script>location.href='" + dir + "';</script>");
    }

    public void sendEmail(final String name, final String email, final String phone,
            final String requirement, final String chemical, final int id) throws Exception {
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
                + "    <td colspan=\"3\">Thank you for your enquiry with Tradeasia International Pte. Ltd. Your enquiry Id is " + getLastID() + "</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  \n"
                + "  <tr><td colspan=\"3\" height=\"10\">"
                + "<a href=\"http://localhost:8084/Tradeasia/confirmProductEnquiry?pid=" + getLastID() + "\">Please click here to confirm your enquiry about this product.</a></td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\">Your enquiry details are follows.</td>\n"
                + "  </tr>\n"
                + " <tr><td height=\"10\"></td></tr>\n"
                + " \n"
                + "  <tr>\n"
                + "    <th width=\"159\" scope=\"row\" align=\"left\">Name</th>\n"
                + "    <td width=\"17\">:</td>\n"
                + "    <td width=\"302\">" + name + "</td>\n"
                + "  </tr>\n"
                + "\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Mail Id</th>\n"
                + "    <td>:</td>\n"
                + "    <td>" + email + "</td>\n"
                + "  </tr>\n"
                + "  \n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Contact Number</th>\n"
                + "    <td>:</td>\n"
                + "    <td>" + phone + "</td>\n"
                + "  </tr>\n"
                + "   \n"
                + "   <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Product</th>\n"
                + "    <td>:</td>\n"
                + "    <td><a href=\"localhost:8084/product-details?id=" + id + "\">" + chemical + "</a></td>\n"
                + "  </tr>\n"
                + "  \n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Requirement</th>\n"
                + "    <td>:</td>\n"
                + "    <td>" + requirement + "</td>\n"
                + "  </tr>\n"
                + "  \n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\">We will contact you as soon as possible to follow up your order with chemtradeasia.co.id. </td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  \n"
                + "\n"
                + "  \n"
                + "  <tr>\n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "  \n"
                + "</table>";

        //String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter + mailBodyFooter;
        EmailController emailController = new EmailController();
        emailController.sendEmailViaGmail(email, mailBody, "Product Enquiry");
        //sendEmailViaGmail(email, mailBody);
        //sendAdminEmail(adminMailBody);

        // this.mailSender.send(msg);
    }

   

    public int getLastID() {

        Connection conn = null;
        Statement stat = null;
        int id = 0;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT max(enquiry_id) FROM tbl_enquiry");
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt(1);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stat);
        }
        return id;
    }

    private int postForm(String n, String e, String p, String r, String c, String t, int ci, String ip) throws Exception {
        Connection conn = null;
        Statement stat = null;
        int id = 1;
        String enq = "";
        int enqid = 1;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_enquiry ORDER BY enquiry_id LIMIT 1");
            ResultSet rs = ps.executeQuery();
            rs.last();
            id = rs.getInt("enquiry_id") + 1;
            enq = rs.getString("enq_code");
            enq = enq.substring(4);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stat);
        }
        try {
            enqid = Integer.parseInt(enq) + 1;
        } catch (NumberFormatException e2) {
            enqid = 1;
        }
        int success = 0;
        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            conn = ConnectionManager.getConnection();
            stat = conn.createStatement();
            success = stat.executeUpdate("INSERT INTO `tbl_enquiry` (`enquiry_id`, `enq_code`, `name`, `email_id`, `cont_no`, `message`, `chemical`, `prd_id`, `subject`,approved_status, `created_on`, `ip_address`) VALUES"
                    + "(" + id + ", 'Enq-" + enqid + "', '" + n + "', '" + e + "', '" + p + "', '" + r + "', '" + c + "', '" + ci + "', '" + t + "',0,'" + str_date2 + "', '" + ip + "');");
        } finally {
            ConnectionManager.close(conn, stat);
        }
        return success;
    }
}
