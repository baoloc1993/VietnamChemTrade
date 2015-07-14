package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.entity.Product;

@WebServlet("/topProduct")
public class TopProductController extends HttpServlet implements Constant {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageCount;
        int showPage;
        try{
        //ProductDAO dao = new ProductDAO();
        //HomeDAO homeDAO = new HomeDAO();
	        ArrayList<Product> topProducts = getTopProduct();
	        int recordCount = topProducts.size();
	        pageCount = (recordCount % NUMBER_ITEM_PER_PAGE == 0) ? (recordCount / NUMBER_ITEM_PER_PAGE) : (recordCount / NUMBER_ITEM_PER_PAGE + 1); //calculate how many pages in total, depending on number of products
	        String integer = request.getParameter("showPage");
	        if (integer == null) {
	            integer = "1";
	        }
	        try {
	            showPage = Integer.parseInt(integer);
	        } catch (NumberFormatException e) {
	            showPage = 1; //if products are empty
	        }
	        if (showPage <= 1) {
	            showPage = 1;
	        }
	        if (showPage >= pageCount) {
	            showPage = pageCount;
	        }
	        int position = (showPage - 1) * NUMBER_ITEM_PER_PAGE + 1; //position is the position of the starting product being displayed
	        
            String displayMessage  = "Displaying " + position + "-" + Math.min(position + 9, recordCount)+ " of " + recordCount +  " results";
            String paging  = getNumberPaging(showPage, pageCount);
            
            request.setAttribute("topProducts", topProducts);
            request.setAttribute("displayMessage", displayMessage);
            request.setAttribute("paging", paging);
			request.getRequestDispatcher("jsp/product/top-products.jsp").forward(request, resp);
        }catch(Exception e){
        	resp.sendRedirect("index");
        	//resp.sendError(510, e.getMessage());
        }
	}
	
	
	
	 public ArrayList<Product> getTopProduct() throws SQLException {
		 ArrayList<Product> topProducts = new ArrayList<Product>();
		 	Connection conn = null;
	       // ProductDAO productDAO = new ProductDAO();
	        
	            conn = ConnectionManager.getConnection();
	           String sql = "SELECT p.description, p.application, p.product_id, p.product_name,p.specification,p.product_dir, p.msds, p.product_image, p.cas_number, p.chemical_formula, p.country_origin, c.country,a.phy_appear_name, pk.packaging_name "
		   				+ "FROM tbl_product p "
		   				+ "inner join tbl_countries c on p.country_origin = c.ccode "
		   				+ "inner join tbl_phy_appear a on p.physical_appear = a.phy_appear_id "
		   				+ "inner join tbl_packaging pk on p.packing_details = pk.id "
		   				+ "inner join tbl_home_products h on p.product_id = h.product_id "
   						+ "where p.r_status ='A'";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	Product product = new Product();
	               	product.setProductId(rs.getInt(PRODUCT_ID));
	               	product.setProductName(rs.getString(PRODUCT_NAME));
	               	product.setCountryOrigin(rs.getString(PRODUCT_COUNTRY));
	               	product.setPackingDetail(rs.getString(PRODUCT_PACKAGE));
	               	product.setPhysicalAppear(rs.getString(PRODUCT_PHY_APPEAR));
	               	product.setCasNumber(rs.getString(PRODUCT_CAS_NUMBER));
	               	product.setChemicalFormula(rs.getString(PRODUCT_FORMULA));
	               	product.setCountryCode(rs.getString(PRODUCT_COUNTRY_CODE));
	               	product.setDescription(rs.getBlob(PRODUCT_DESC));
	               	product.setApplication(rs.getString(PRODUCT_APPLICATION));
	               	product.setThumbImage(rs.getString(PRODUCT_IMAGE));
	                topProducts.add(product);
	            }
	        

	        return topProducts;
	    }
	 
	 /**
	     * get paging when paging by page
	     * @param showPage
	     * @param pageCount
	     * @return
	     */
	    public String getNumberPaging(int showPage, int pageCount){
	    	String paging = ""; 
	    	if (showPage > 1) {
	    		paging += "<li ><a href=\"topProduct?showPage=" + String.valueOf(showPage - 1) + "\">< Previous</a></li>";
	    	}
	        if (showPage > 3) {

	        }
	        for (int i = 1; i <= pageCount; i++) {
	            if (showPage == i) {

	            	paging+="<li  class=\"active\"><a href=\"topProduct?showPage=" + i +"\">" + i + "</a></li>";
	            } else {
	            	if (i < showPage + 3 && i > showPage - 3) {
	        
	            		paging += "<li><a href=\"topProduct?showPage=" + i +"\">" + i + "</a></li>";
	            	}
	            }
	        }
	        if (showPage < pageCount) {
	        

	        	paging += "<li ><a href=\"topProduct?showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
	        
	        }

	        
			return paging;
	    	
	    }
}
