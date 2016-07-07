package chemtrade.controller.product;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.entity.Category;
import chemtrade.entity.Product;


@WebServlet("/category")
public class ProductCategoryController extends HttpServlet implements Constant {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String[] cat = request.getParameterValues("cat");
         //ArrayList<Product> productResults = new ArrayList<Product>();
         ArrayList<Category> categories = new ArrayList<Category>();
         ArrayList<CategoryWrapper> categoryWrappers = new ArrayList<CategoryWrapper>();
         ProductCategoryController productCategoryController = new ProductCategoryController();
         //ArrayList<Category> categories = new ArrayList<Category>();
         try{
         	categories = productCategoryController.getCategoryDB();
         }catch(Exception e){
         	
         }
        // String subheader = "";
      
		 String uri2 = request.getRequestURI();
	        String pageName2 = uri2.substring(uri2.lastIndexOf("/") + 1);
         if (cat == null) {
        	 //int pageSize = 10; //limit how many products per page

             try {
				categories = getCategoryDB();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
         }else{
        	 String display = "style = \"display : none;\"";
				request.setAttribute("display", display);
             categoryWrappers = getCategoryWrapper(request, cat);
         }
         
         //request.setAttribute("products", productResults);
         //request.setAttribute("categories", categories);
         request.setAttribute("categoryWrappers", categoryWrappers);
         request.setAttribute("categories", categories);
         //request.setAttribute("subheader", subheader);
         

	     request.getRequestDispatcher("jsp/product/products-category.jsp").forward(request, resp);
	}

	/**
	 * @param request
	 * @param cat
	 * @param productResults
	 * @param categoryWrappers
	 */
	public ArrayList<CategoryWrapper> getCategoryWrapper(HttpServletRequest request, String[] cat) {
		ProductController productController = new ProductController();
        ArrayList<CategoryWrapper> categoryWrappers = new ArrayList<CategoryWrapper>();
        ArrayList<Product> productResults = new ArrayList<Product>();

		 //initially category can select more than 1. So the first for loop is to loop through the number of
		 //total categories and list them.
		 for (String catId : cat) {
		     //out.println(Integer.parseInt(cat_id)); //for testing purposes
			 
		     ArrayList<Product> products = productController.getProductByCatId(catId);
		     //out.println(plist.size()); //for testing purposes
		     /*
		      * Get subheader
		      */
		     String subheader = products.size() + " products in total";
		     if (products.size() <= 1) {
		        subheader = products.size() + " product in total";
		     }
		     
		     /*
		      * get category Name by category ID
		      */
		     String categoryName = "";
		     try{
		    	 categoryName = getCategoryName(Integer.parseInt(catId));
		     }catch (Exception e){
		    	 categoryName = "";
		     }
		     
		     
		     int recordCount = products.size();
		     int pageCount = (recordCount % NUMBER_ITEM_PER_PAGE == 0) ? (recordCount / NUMBER_ITEM_PER_PAGE) : (recordCount / NUMBER_ITEM_PER_PAGE + 1); //calculate how many pages in total, depending on number of products
		     String integer = request.getParameter("showPage");
		     if (integer == null) {
		         integer = "1";
		     }
		     
		     int showPage;
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
		     for (int i = position - 1; i < Math.min(position - 1 + NUMBER_ITEM_PER_PAGE,products.size()); i++) { //limit number of products shown here, and limit what position of products to show too
		         productResults.add(products.get(i));
		     }
		     
		     String paging = getPaging(showPage,pageCount,cat[0]);
		     String subheader1 = "Displaying " + position + "-" + String.valueOf(Math.min(position + 9, recordCount)) + " of " +  recordCount  + " results";
		     CategoryWrapper categoryWrapper = new CategoryWrapper();
		     categoryWrapper.setHeader(categoryName);
		     categoryWrapper.setCatId(catId);
		     categoryWrapper.setProducts(productResults);
		     categoryWrapper.setSubheader(subheader);
		     categoryWrapper.setRecordCount(recordCount);
		     categoryWrapper.setPaging(paging);
		     categoryWrapper.setSubheader1(subheader1);
		     categoryWrappers.add(categoryWrapper);
		     
		     
		     /*
		      * For easy, Just add 1 CategoryWrapper
		      */
		     break;
		 }
		 
		 return categoryWrappers;
	}
	
	/**
	 *  Get the paging part
	 * @param showPage 
	 * @param pageCount 
	 * @param cateId 
	 */
	private String getPaging(int showPage, int pageCount, String cateId) {
		// TODO Auto-generated method stub
		String paging = "";
		if (showPage > 1) {
			paging += "<li ><a href=\"category?cat=" + cateId + "&showPage=" + String.valueOf(showPage - 1) + "\">< Previous</a></li>";
		}
		if (showPage > 3) {
        }
        for (int i = 1; i <= pageCount; i++) {
            if (showPage == i) {
    
            	paging += "<li  class=\"active\"><a href=\"category?cat=" + cateId + "&showPage=" + i + "\">" + i + "</a></li>";
            } else {
            	if (i < showPage + 3 && i > showPage - 3) {
        
            		paging += "<li><a href=\"category?cat=" + cateId + "&showPage=" + i + "\">" + i + "</a></li>";
            	}
            }
        }
        if (showPage < pageCount) {
        
        	paging += "<li ><a href=\"category?cat=" + cateId + "&showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
        }
        
        return paging;

        
	}

	/**
	 * Get list of catetgory from database
	 * @return
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Category> getCategoryDB() throws SQLException, UnsupportedEncodingException{
		ArrayList<Category> categories =  new ArrayList<Category>();
	    Connection conn = ConnectionManager.getConnection();
	    PreparedStatement ps = conn.prepareStatement("select * from tbl_categorymaster order by category_name");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        categories.add(getCategory(rs.getInt("category_id"), new String (rs.getBytes("category_name"),"UTF-8"), rs.getTimestamp("r_date"),
	                rs.getString("r_status"), rs.getString("parent_id")));
	    }
		return categories;
	}
	
	/**
	 * Get instance of category
	 * @param categoryId
	 * @param name
	 * @param date
	 * @param status
	 * @param parentId
	 * @return
	 */
	  public Category getCategory(int categoryId, String name, Timestamp date, String status, String parentId) {

	       Category category = new Category();
	       category.setId(categoryId);
	       category.setName(name);
	       category.setDate(date);
	       category.setStatus(status);
	       category.setParentsId(parentId);
	       return category;
	    }
	  
	  /**
	   * Get name of category by its id
	   * @param cat_id
	   * @return
	 * @throws SQLException 
	   */
	  public String getCategoryName(int id) throws SQLException{
	        
	        String name = "";
	        //try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("select category_name from tbl_categorymaster where category_id=" + id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            name = rs.getString("category_name");    
	        return name;
	    }
	  
	  /**
	   * Get list category id
	   * 
	   * @return
	 * @throws SQLException 
	   */
//	  public String getCategoryId() throws SQLException{
//	        
//	        String name = "";
//	        //try {
//            Connection conn = ConnectionManager.getConnection();
//            PreparedStatement ps = conn.prepareStatement("select category_id from tbl_categorymaster");
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            name = rs.getString(1);    
//	        return name;
//	    }
	  
	  /**
	   * Class to store data for passing to jsp
	   * @author LuisNgo
	   *
	   */
	  public class CategoryWrapper{
		  String catId = "";
		  String subheader = "";
		  String subheader1 = "";
		  String header = "";
		  int position = 0;
		  int recordCount = 0;
		  String paging = "";
		  ArrayList<Product> products = new ArrayList<Product>();
		
		  public void setSubheader1(String subheader1) {
			this.subheader1 = subheader1;
		}
		  
		  public String getSubheader1() {
			return subheader1;
		}
		  
		  public void setPaging(String paging) {
			this.paging = paging;
		}
		  
		  public String getPaging() {
			return paging;
		}
		  public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		  
		  public int getRecordCount() {
			return recordCount;
		}
		  
		  public void setPosition(int position) {
			this.position = position;
		}
		  public int getPosition() {
			return position;
		}
		  public void setHeader(String header) {
			this.header = header;
		}
		  
		  public String getHeader() {
			return header;
		}
		  
		  public void setCatId(String catId) {
			this.catId = catId;
		}
		  
		  public void setProducts(ArrayList<Product> products) {
			this.products = products;
		}
		  
		  public void setSubheader(String subheader) {
			this.subheader = subheader;
		}
		  
		
		  public String getCatId() {
			return catId;
		}
		  public ArrayList<Product> getProducts() {
			return products;
		}
		  
		  public String getSubheader() {
			return subheader;
		}
		  
		  
	  }
}
