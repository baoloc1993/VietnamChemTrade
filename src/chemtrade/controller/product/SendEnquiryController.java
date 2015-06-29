/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.CountryCodeController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.Product;


/**
 *
 * @author Toshiba PC
 */
@WebServlet("/sendEnquiry")
public class SendEnquiryController extends HttpServlet {

    //database connection settings

//    private String dbURL = "jdbc:mysql://localhost/prodchem_chemtradeasiacom";
//    private String dbUser = "root";
//    private String dbPass = "";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String salutation = request.getParameter("salutation");
        String lastName = request.getParameter("lastname");
        String descr = request.getParameter("description");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String message = request.getParameter("message");

        Connection conn = null; //connection to the database
        String replyMessage = ""; //message will be sent back to the client

        try {
        	conn = ConnectionManager.getConnection();
        	String sql = "INSERT INTO tbl_quickquote (salutation, first_name, last_name)"
        			+ " values (`" + salutation + "','" + lastName + "','" + descr + "','" + email + "','" + country  + "','" + message + "');";
            //constructs SQL statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            //if (ps.execute()){
            	//replyMessage = "We've received your query. Thank you.";
            //};
            

        } catch (SQLException e) {
            response.sendError(404);
            e.printStackTrace();
        }
        
        response.sendRedirect("jsp/contact-us2.jsp");

    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	 //CountryDAO cdao = new CountryDAO();
         //cdao.databaseRetrieval();
    	//CountryCodeController countryCodeController = new CountryCodeController();
         //ArrayList<CountryCode> clist = countryCodeController.getCountryCodes();

         //ProductDAO pdao = new ProductDAO();
         //pdao.databaseRetrieval();
         ProductController productController = new ProductController();
         ArrayList<Product> products = productController.getProductListFromDB(0);
         
         req.setAttribute("products", products);
         req.getRequestDispatcher("jsp/products/send-enquiry.jsp").forward(req, resp);
    	//super.doGet(req, resp);
    }
}
