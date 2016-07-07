package chemtrade.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.webkit.ContextMenu.ShowContext;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.product.ProductCategoryController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Category;
import chemtrade.entity.Product;

@WebServlet("/search")
public class SearchController extends HttpServlet implements Constant{
	
	
	HttpServletRequest request;
	HttpServletResponse response ;
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
		//request = req;
		//response=resp;
		try{
	        ArrayList<Product> products = new ArrayList<Product>();
	        int page = 1;
	//        boolean letterChosen = false;
	//        HttpSession session = req.getSession();
	        ProductController productController = new ProductController();
	        
	        /*
	         * Get showPage
	         */
	        try{
	        	page = Integer.parseInt(req.getParameter("showPage"));
	        }catch (Exception e){
	        	page = 1;
	        
	        }
	        String paging = "";
	       // req.setCharacterEncoding("UTF-8");
	        String keyword = req.getParameter("keyword");
	       keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
	        keyword = configKeyword(keyword);
	        
	        String casNumber = req.getParameter("casname");
	        String origin = req.getParameter("origin");
	        String hsCode = req.getParameter("hsCode");
	        
	//        if (keyword == null) {
	//        	keyword = "";
	//        }
	        if (casNumber == null) {
	        	casNumber = "";
	        }
	        if (origin == null) {
	        	origin = "";
	        }
	        if (hsCode == null) {
	        	hsCode = "";
	        }
	        
	     
	        products = getSearchProductList(page,keyword, casNumber, origin, hsCode);
			
	       // req.setAttribute("message", keyword);
	        //req.getRequestDispatcher("jsp/test.jsp").forward(req,resp);
			String path= "search?keyword=" + keyword + "&casname=" + casNumber + "&origin=" + origin + "&hsCode=" + hsCode;
			try {
				paging =  getNumberPaging(page, getProductSize(keyword, casNumber, origin, hsCode), path);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        //String path = req.getContextPath();
	       // paging = getNumberPaging(page, products.size(), path);
	        String ip = req.getRemoteAddr();
	        ProductCategoryController productCategoryController = new ProductCategoryController();
	        ArrayList<Category> categories = new ArrayList<Category>();
	        
	        	categories = productCategoryController.getCategoryDB();
	        
	        req.setAttribute("categories", categories);
	        storeSearchWords(keyword, ip, casNumber, origin, hsCode);
	        req.setAttribute("products", products);
	        req.setAttribute("page", page);
	        req.setAttribute("paging", paging);
	        req.getRequestDispatcher("jsp/product/products.jsp").forward(req, resp);
		}catch(SQLException e){
			String error = e.getMessage();
			StackTraceElement[] es= e.getStackTrace();
			for(int i = 0; i< es.length; i++){
				error += es[i].toString() + "<br>";
			}
			resp.sendError(512, error);
		}
    }
	
	


	/**
     * get paging when paging by page
     * @param showPage
     * @param pageCount
	 * @param keyword 
     * @return
     */
    public String getNumberPaging(int showPage, int pageCount, String path){
    	String paging = ""; 
    	if (showPage > pageCount) showPage = pageCount;

       // String paging = "";
		if (showPage > 1) {
    		paging += "<li ><a href=\""+ path + "\"&showPage=" + String.valueOf(showPage - 1) + "\">< Previous</a></li>";

		}
		if (showPage > 3) {
        }
        for (int i = 1; i <= pageCount; i++) {
            if (showPage == i) {
    
            	paging+="<li  class=\"active\"><a href=\"" + path + "&showPage=" + i +"\">" + i + "</a></li>";
            } else {
            	if (i < showPage + 3 && i > showPage - 3) {
        
            		paging += "<li><a href=\"" + path + "&showPage=" + i +"\">" + i + "</a></li>";
            	}
            }
        }
        if (showPage < pageCount) {
        
        	paging += "<li ><a href=\"" + path + "&showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
        }
        
       // return paging;
        
		return paging;
    	
    }
    
//    /**
//     * Return paging part when paging by Letter
//     * @param page
//     * @param keyword
//     * @param pageCount
//     * @return
//     */
//    public String getLetterPaging(int page, String keyword, int pageCount){
//    	String paging = "";
//    	if (page > 1 ){
//    		paging += "<li ><a href=\"search?keyword=" + keyword + "&showPage=" + String.valueOf(page-1) + "\">< Previous</a></li>";
//    	}
//    	if (page > 3) {
//
//        }
//    	for (int i = 1; i <= pageCount; i++) {
//            if (page == i) {
//            	paging += "<li class=\"active\" ><a href=\"search?keyword=" + keyword + "&showPage=" + i +"\">" + i + "</a></li>";
//            }else{
//            	if (i < page + 3 && i > page - 3) {
//                    paging += "<li ><a href=\"search?keyword="+ keyword + "&showPage=" + i + "\">" + i + "</a></li>";
//
//            	}
//            }
//    	}
//    	
//        if (page < pageCount) {
//        		paging += "<li ><a href=\"search?keyword=" +keyword + "&showPage=" + String.valueOf(page + 1) + "\">Next ></a></li>";
//    
//        }
//		return paging;
//    }
    
    /**
	 * Store search word in database
	 * @param search search keyword
	 * @param ip : ipAddress of user
	 */
	public void storeSearchWords(String search, String ip, String casNumber, String origin, String hsCode) {
        
        Calendar cal = Calendar.getInstance();
        java.sql.Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
        String timestamp = time + "";
        Connection conn;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_search_keywords (type,keywords,cas_no,hs_code,origin,ip_address,created_on) VALUES (" + 1 + ",'" + search +"','" + casNumber +"','" + hsCode +"','" + origin + "','" + ip + "','" + timestamp + "')");
            ps.execute(); //sends statement to the database server

        }  catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
	
	/**
     * Get Product according to keyword
     * @param first
     * @param last
     * @param search : keyword
     * @return
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
     */
    @SuppressWarnings("finally")
	public ArrayList<Product> getSearchProductList(int first, int last, String search, String casNumber, String origin, String hsCode) throws UnsupportedEncodingException, SQLException {
   	 ArrayList<Product> products = new ArrayList<>();
   	 int count = last - first;
   	 if (first < 0 || last < 0){
   		 count = 0;
   	 }
   	    Connection conn;;
   	    PreparedStatement ps;;
   	    ResultSet rs;
      String sql = "";
      
			conn = ConnectionManager.getConnection();
		
           sql =  PRODUCT_BASE_SQL + " AND lower(product_name) like lower('%"+ search + "%') AND  	lower(cas_number) like lower('%" + casNumber + "%') AND lower(hs_code) like lower('%" + hsCode + "%') AND country_origin like '%" + origin + "%'";
           if (count > 0 ){
           	sql = sql + " ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
           	System.out.println(sql);
           }else{
           	sql = sql+ " ORDER BY product_id DESC";
           }
           //System.out.println (sql);
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
//           String lastName = this.jdbcTemplate.queryForObject(
//        	        "select last_name from t_actor where id = ?",
//        	        new Object[]{1212L}, String.class);
          // rs.next();
           /*
            * GEt TOP 3 PRODUCT
            */
           //int count = 0;
           while (rs.next()) {
           	
	           	Product product = new Product();
	           //	Product product = new Product();
	        	product.setProductId(rs.getInt(PRODUCT_ID));
	        	product.setProductName(new String(rs.getBytes(PRODUCT_NAME), "UTF-8"));
	        	product.setCountryOrigin(new String(rs.getBytes(PRODUCT_COUNTRY), "UTF-8"));
	        	product.setPackingDetail(new String(rs.getBytes(PRODUCT_PACKAGE), "UTF-8"));
	        	product.setPhysicalAppear(new String(rs.getBytes(PRODUCT_PHY_APPEAR), "UTF-8"));
	        	product.setCasNumber(new String(rs.getBytes(PRODUCT_CAS_NUMBER), "UTF-8"));
	        	product.setChemicalFormula(new String(rs.getBytes(PRODUCT_FORMULA), "UTF-8"));
	        	product.setCountryCode(new String(rs.getBytes(PRODUCT_COUNTRY_CODE), "UTF-8"));
	        	product.setDescription(rs.getBlob(PRODUCT_DESC));
	           	product.setApplication(new String(rs.getBytes(PRODUCT_APPLICATION), "UTF-8"));
	           	product.setProductDir(new String(rs.getBytes(PRODUCT_DIR), "UTF-8"));
	           	product.setThumbImage(new String(rs.getBytes(PRODUCT_IMAGE), "UTF-8"));
	           	products.add(product);
           	
           }
		return products;
       
           		
       
   }
    
    /**
     * Get product list through page and letter
     * @param page: page want to load. 10 products in each page
     * if page < 1, load all product
     * @return
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
    public ArrayList<Product> getSearchProductList(int page, String keyword, String casNumber, String origin, String hsCode) throws UnsupportedEncodingException, SQLException {
    	ArrayList<Product> products = new ArrayList<Product>();
    	if (page < 1){
    		products = getSearchProductList(0,0,keyword, casNumber, origin, hsCode);
    	}
    	int first = (page-1) * NUMBER_ITEM_PER_PAGE;
    	int last = first + NUMBER_ITEM_PER_PAGE;
    	products = getSearchProductList(first,last,keyword,casNumber, origin, hsCode);
    	return products;
    }
    
    /**
     * Get size of the product with the search
     * @param search
     * @param casNumber
     * @param hsCode
     * @param origin
     * @return
     * @throws SQLException
     */
    public int getProductSize(String search, String casNumber, String hsCode, String origin) throws SQLException{
    	Connection conn;;
   	    PreparedStatement ps;;
   	    ResultSet rs;
           conn = ConnectionManager.getConnection();
           String sql = "SELECT count(*) "
	   				+ "FROM tbl_product p "
	   				+ "inner join tbl_countries c on p.country_origin = c.ccode "
	   				+ "inner join tbl_phy_appear a on p.physical_appear = a.phy_appear_id "
	   				+ "inner join tbl_packaging pk on p.packing_details = pk.id "
						+ "where p.r_status ='A'  AND lower(product_name) like lower('%"+ search + "%') AND  	lower(cas_number) like lower('%" + casNumber + "%') AND lower(hs_code) like lower('%" + hsCode + "%') AND country_origin like '%" + origin + "%'";
           //if (count > 0 ){
           //	sql = sql + " ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
           //	System.out.println(sql);
           //}else{
           	sql = sql+ " ORDER BY product_id DESC";
          // }
       
           //System.out.println (sql);
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           rs.next();
           return (int) Math.ceil((float)rs.getInt(1) /10);
    }
    
    /**
     * Remove all special/vietnamese character in keyword
     * @param keyword
     * @return
     */
    public String configKeyword(String keyword){
    	String keywordFin = "";
    	keywordFin = keyword.replaceAll(REGREX, "%");
    	return keywordFin;
    }
    
}
