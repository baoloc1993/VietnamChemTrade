package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.Constant;
import chemtrade.entity.Category;
import chemtrade.entity.Product;

@WebServlet("/productDetail")
public class ProducDetailController extends HttpServlet implements Constant {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = 0;
		
			pid = Integer.parseInt(request.getParameter("id"));
		
		ProductController productController = new ProductController();
		Product product = productController.getProductFromDBByID(pid);
		ProductCategoryController productCategoryController = new ProductCategoryController();
        ArrayList<Category> categories = new ArrayList<Category>();
        try{
        	categories = productCategoryController.getCategoryDB();
        }catch(Exception e){
        	
        }
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
			request.setAttribute("product", product);
			request.setAttribute("application", product.getApplication());
			request.setAttribute("description", description);
	        request.setAttribute("categories", categories);

			
			request.getRequestDispatcher("jsp/product/product-details.jsp").forward(request, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			description = "";
			request.getRequestDispatcher("index").forward(request, resp);
		}
		
		
		
        
	}
}
