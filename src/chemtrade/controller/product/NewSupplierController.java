/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

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

import chemtrade.configuration.ConnectionManager;

/**
 *
 * @author Fla
 */
@WebServlet(name = "NewSupplierController", urlPatterns = {"/new-supplier-form"})
public class NewSupplierController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String rand = (String) session.getAttribute("rand");
        String input = request.getParameter("TblDetSupplier[verifyCode]");
        if (!rand.equalsIgnoreCase(input)) {
            out.println("<script>alert('Wrong verification code');</script>");
            out.print("<script>location.href='newSupplier.jsp';</script>");
        }
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        int supid = 0;
        String str_date2 = null;
        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_det_supplier order by det_supplier_id");
            rs = ps.executeQuery();
            rs.last();
            id = rs.getInt("det_supplier_id") + 1;
            String supidTemp = rs.getString("enq_code");
            supidTemp = supidTemp.substring(4, 6);
            try {
                supid = Integer.parseInt(supidTemp) + 1;
            } catch (NumberFormatException e) {
                supid = 1;
            }
            ConnectionManager.close(conn, ps, rs);
            conn = ConnectionManager.getConnection();
            str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            ps = conn.prepareStatement("INSERT INTO `tbl_det_supplier` (`det_supplier_id`, `enq_code`, `comapny_name`, `company_type`, `establish_year`, `address`, `city`, `state`, `zip`,"
                    + " `country`, `cmpny_contact_no`, `fax`, `website`, `salutation`, `first_name`, `middle_name`, `last_name`, "
                    + "`designation`, `country_code`, `area_code`, `phone`, `country_code_mob`, `mobile`, `emailid`, `messenger_type`,"
                    + " `messenger_id`, `delivery_term`, `payment_term`, `loading_port`, `usd_per_mt`, `days_to_deliver`, `comments`, "
                    + "`approve`, `created_on`, `ip_address`, `tnccheck`) "
                    + "VALUES(" + id + ", 'Sup-" + supid + "', '" + request.getParameter("TblDetSupplier[company_name]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[company_type]") + "', '" + request.getParameter("TblDetSupplier[establish_year]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[address]") + "', '" + request.getParameter("TblDetSupplier[city]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[state]") + "', '" + request.getParameter("TblDetSupplier[zip]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[country]") + "',"
                    + " '" + request.getParameter("TblDetSupplier[cmpny_contact_no]") + "', '" + request.getParameter("TblDetSupplier[fax]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[website]") + "', '" + request.getParameter("TblDetSupplier[salutation]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[first_name]") + "', '" + request.getParameter("TblDetSupplier[middle_name]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[last_name]") + "', '" + request.getParameter("TblDetSupplier[designation]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[country_code]") + "', " + request.getParameter("TblDetSupplier[area_code]") + ", ' "
                    + "" + request.getParameter("TblDetSupplier[cmpny_contact_no]") + "', ' " + request.getParameter("TblDetSupplier[country_code_mob]") + "', "
                    + "' " + request.getParameter("TblDetSupplier[mobile]") + "', ' " + request.getParameter("TblDetSupplier[emailid]") + "', "
                    + "' " + request.getParameter("TblDetSupplier[messenger_type]") + "', '" + request.getParameter("TblDetSupplier[messenger_id]") + "',"
                    + " '" + request.getParameter("TblDetSupplier[delivery_term]") + "', '" + request.getParameter("TblDetSupplier[payment_term]") + "', "
                    + "'" + request.getParameter("TblDetSupplier[loading_port]") + "', '', " + request.getParameter("TblDetSupplier[days_to_deliver]") + ","
                    + " '" + request.getParameter("TblDetSupplier[comments]") + "', 0, '" + str_date2 + "', '" + request.getLocalAddr() + "', 0);");
            ConnectionManager.close(conn, ps, rs);
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_supplier_product order by sup_pdt_id");
            rs = ps.executeQuery();
            rs.last();
            id = rs.getInt("sup_pdt_id");
            for (int i = 1; i <= 10; i++) {
                if (request.getParameter("product_name" + Integer.toString(i)) != null) {
                    ConnectionManager.close(conn, ps, rs);
                    conn = ConnectionManager.getConnection();
                    ps = conn.prepareStatement("INSERT INTO `tbl_supplier_product` (`sup_pdt_id`, `supplier_id`, `product_name`, `sample_status`, `price`) VALUES"
                            + "(" + id + i + ", 'Sup-" + supid + "', '" + request.getParameter("product_name" + Integer.toString(i)) + "', '" + request.getParameter("sample" + Integer.toString(i)) + "', '" + request.getParameter("price" + Integer.toString(i)) + "');");
                }
            }

            out.print("<script>alert('Successful!');</script>");
            out.print("<script>location.href='index.jsp';</script>");
        } catch (Exception e) {
            out.print("<script>alert('Fail to upload');</script>");
            out.print("<script>location.href='newSupplier.jsp';</script>");
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }
    }
}
