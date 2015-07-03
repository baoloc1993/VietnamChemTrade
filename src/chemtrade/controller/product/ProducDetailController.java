package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.Constant;
import chemtrade.entity.Product;

@WebServlet("/productDetail")
public class ProducDetailController extends HttpServlet implements Constant {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = 0;
		try{
			pid = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e){
			request.getRequestDispatcher("product").forward(request, resp);

		}
		
		ProductController productController = new ProductController();
		Product product = productController.getProductFromDBByID(pid);
        //out.println(pid);//for testing purposes

        //ProductDAO dao = new ProductDAO();
        //Product p = dao.getProduct(pid);

        //convert Blob to String
		String description = "";
        Blob brief = product.getDescription();
        byte[] bdata;
		try {
			bdata = brief.getBytes(1, (int) brief.length());
			description = new String(bdata);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			description = "";
		}
		
		
		request.setAttribute("product", product);
		request.setAttribute("application", product.getApplication());
		request.setAttribute("description", description);
		
		request.getRequestDispatcher("jsp/product/product-details.jsp").forward(request, resp);
        
	}
}
