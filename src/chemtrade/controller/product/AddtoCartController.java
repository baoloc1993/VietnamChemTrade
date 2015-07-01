/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chemtrade.entity.Product;

/**
 *
 * @author ASUS
 */
@WebServlet("/addToCart")
public class AddtoCartController extends HttpServlet {
    
    
    
    



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	@SuppressWarnings("unchecked")
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    	
	    	ArrayList<Product> cartList = new ArrayList<Product>();
	    	 HttpSession session = request.getSession();  
	         if (session.getAttribute("cartList") == null) {
	             cartList = new ArrayList<Product>();
	         } else {
	             cartList =(ArrayList<Product>)session.getAttribute("cartList");
	         }
	         
	         
	         int productID = Integer.parseInt(request.getParameter("pid"));
	         ProductController productController = new ProductController();
	         Product product = productController.getProductListFromDBByID(productID);
	         //Product p = productDAO.getProduct(productID);
	         cartList.add(product);
	         
	         session.setAttribute("cartList", cartList);
	         response.sendRedirect("product");
    	
    }

}
