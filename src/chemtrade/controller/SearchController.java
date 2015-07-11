package chemtrade.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Product;

@WebServlet("/search")
public class SearchController extends HttpServlet{

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
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
        String keyword = req.getParameter("keyword");
        String casNumber = req.getParameter("keyword");
        String origin = req.getParameter("origin");
        String hsCode = req.getParameter("hsCode");
        
//        if ((keyword == null)){
//        	products = productController.getProductListFromDB(page);
//        	paging =  getNumberPaging(page, products.size());
//        }else{
//        	products = productController.getSearchProductList(page,keyword);
//        	paging =  getLetterPaging(page, keyword, products.size());
//
//        }
        String path = req.getContextPath();
        paging = getNumberPaging(page, products.size(), path);
        String ip = req.getRemoteAddr();
        storeSearchWords(keyword, ip, casNumber, origin, hsCode);
        req.setAttribute("products", products);
        req.setAttribute("page", page);
        req.setAttribute("paging", paging);
        req.getRequestDispatcher("jsp/product/products.jsp").forward(req, resp);

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
    	//String origin
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
        
            		paging += "<li><a href=\"search?showPage=" + i +"\">" + i + "</a></li>";
            	}
            }
        }
        if (showPage < pageCount) {
        

        	paging += "<li ><a href=\"" + path + "&showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
        
        }

        
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
    
}
