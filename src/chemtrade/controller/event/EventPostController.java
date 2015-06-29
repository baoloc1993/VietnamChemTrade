/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.event;

import dao.EventDAO;
import entity.*;
import connection.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fla
 */
@WebServlet(name = "EventPostController", urlPatterns = {"/new-event-form"})
public class EventPostController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String rand = (String) session.getAttribute("rand");
        String input = request.getParameter("verifyCode");
        if (!rand.equalsIgnoreCase(input)) {
            out.println("<script>alert('Wrong verification code');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("firstNm");
        if (input.length() == 0) {
            out.print("<script>alert('Empty First Name');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }
        input = request.getParameter("middleNm");
        if (input.length() >= 100) {
            out.print("<script>alert('Too Long Middle Name');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("lastNm");
        if (input.length() == 0) {
            out.print("<script>alert('Empty Last Name');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("email");
        if (input.length() == 0) {
            out.print("<script>alert('Empty Email');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("title");
        if (input.length() == 0) {
            out.print("<script>alert('Empty Title');location.href='addNewEvent.jsp';</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("location");
        if (input.length() == 0) {
            out.print("<script>alert('Empty Event Location');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        input = request.getParameter("email");
        if (input.length() == 0) {
            out.print("<script>alert('Empty Email');</script>");
            out.print("<script>location.href='addNewEvent.jsp';</script>");
        }

        EventDAO e = new EventDAO();
        e.databaseRetrieval();
        ArrayList<Event> list = e.getTable();
        Connection conn = null;
        Statement stat = null;
        int ids;
        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String date = request.getParameter("date");
        String dateR;
        try {
            dateR = date.substring(6, 10) + "-" + date.substring(0, 2) + "-" + date.substring(3, 5);
        } catch (Exception e1) {
            dateR = "0000-00-00";
        }
        try {
            ids = list.get(list.size() - 1).news_id;
            ids++;
        } catch (NumberFormatException e1) {
            ids = 1;
        }
        try {
            conn = ConnectionManager.getConnection();
            stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO `tbl_news` (`news_id`, `news_title`, `news_desc`, `news_link`, `news_img`, `date`, `location`, `salutation`, `first_name`, `middle_name`, `last_name`, `country_code`, `area_code`, `phone_number`, `emailid`, `approved_sts`, `status`, `created_on`, `ip_address`, `approved_by`) VALUES "
                    + "(" + ids + ", '" + request.getParameter("title") + "','" + request.getParameter("description") + "','" + request.getParameter("link") + "','','" + dateR + "','" + request.getParameter("location") + "', '" + request.getParameter("salutation") + "', '" + request.getParameter("firstNm") + "', '" + request.getParameter("middleNm") + "', '" + request.getParameter("lastNm") + "', '" + request.getParameter("countryCode") + "', '" + request.getParameter("areaCode") + "', '" + request.getParameter("phone") + "', '" + request.getParameter("email") + "', 0, '', '" + str_date2 + "', '" + request.getLocalAddr() + "', '');");
            out.println("<script>alert('Successful');</script>");
        } catch (Exception e1) {
            out.print("INSERT INTO `tbl_news` (`news_id`, `news_title`, `news_desc`, `news_link`, `news_img`, `date`, `location`, `salutation`, `first_name`, `middle_name`, `last_name`, `country_code`, `area_code`, `phone_number`, `emailid`, `approved_sts`, `status`, `created_on`, `ip_address`, `approved_by`) VALUES "
                + "(" + ids + ", '" + request.getParameter("title") + "','" + request.getParameter("description") + "','" + request.getParameter("link") + "','','" + dateR + "','" + request.getParameter("location") + "', '" + request.getParameter("salutation") + "', '" + request.getParameter("firstNm") + "', '" + request.getParameter("middleNm") + "', '" + request.getParameter("lastNm") + "', '" + request.getParameter("countryCode") + "', '" + request.getParameter("areaCode") + "', '" + request.getParameter("phone") + "', '" + request.getParameter("email") + "', 0, '', '" + str_date2 + "', '" + request.getLocalAddr() + "', '');");
            out.println("<script>alert('Fail to upload');</script>");
            e1.printStackTrace();
        } finally {
            ConnectionManager.close(conn,stat);
        }
        ids++;
        out.print("Redrecting.....<script>location.href='addNewEvent.jsp';</script>");
    }
}
