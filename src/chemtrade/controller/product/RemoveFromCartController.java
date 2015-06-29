/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
@WebServlet("/removeCart")
public class RemoveFromCartController extends HttpServlet {

     
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
        int productID = Integer.parseInt(request.getParameter("p_ID"));
        HttpSession session = request.getSession();
        
		ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartList");
        Iterator<Product> iter = cartList.iterator();

        try {
            while (iter.hasNext()) {
                if (iter.next().getProductId() == productID) {
                    iter.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("jsp/product/order.jsp");

    }


}
