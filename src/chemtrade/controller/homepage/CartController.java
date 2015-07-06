package chemtrade.controller.homepage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chemtrade.configuration.Constant;
import chemtrade.entity.Product;

public class CartController extends HttpServlet implements Constant{

	@SuppressWarnings("unchecked")
	public void getCart(HttpServletRequest request){
//		String uri3 = request.getRequestURI();
//	    String pageName3 = uri3.substring(uri3.lastIndexOf("/") + 1);

	    ArrayList<Product> cartList = null;
	    HttpSession session = request.getSession();

	    if (session.getAttribute("cartList") == null) {
	        cartList = new ArrayList<Product>();
	    } else {
	        cartList = (ArrayList<Product>) session.getAttribute("cartList");
	    }
	    //ProductDAO productDAO = new ProductDAO();

	    String cartMessage = "";

	    if (cartList != null && cartList.size() != 0) {
	        cartMessage = "<b>Product Details</b>";	           
            
	    }else{
	    	cartMessage = "EMPTY";
	    }
	}
}
