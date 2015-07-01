/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

/**
 *
 * @author Toshiba PC
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.configuration.EmailConfiguration;
import chemtrade.entity.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet implements Constant{

	//private static final int NUMBER_ITEM_PER_PAGE = 10;
    /**
     * Get Product from database which result will come from first position to last position 
     * in database (exclusive first and inclusive last)
     * If first or last < 0, load all data
     * 
     * @return 
     * @throws SQLException 
     */
    public ArrayList<Product> getProductListFromDB(int first, int last) {
    	 ArrayList<Product> products = new ArrayList<>();
    	 int count = last - first;
    	 if (first < 0 || last < 0){
    		 count = 0;
    	 }
    	    Connection conn;;
    	    PreparedStatement ps;;
    	    ResultSet rs;
        try{
            conn = ConnectionManager.getConnection();
            String sql = "";
            if (count > 0 ){
            	sql = PRODUCT_BASE_SQL + " ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
            	System.out.println(sql);
            }else{
            	sql = PRODUCT_BASE_SQL + " ORDER BY product_id DESC";
            }
        
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
           // rs.next();
            /*
             * GEt TOP 3 PRODUCT
             */
            //int count = 0;
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
            	products.add(product);
            	
            }
            return products;
        }catch (Exception e){
        	return products;
        }
            //return list;
         
    }
    
    /**
     * Get product list through page
     * @param page: page want to load. 10 products in each page
     * if page < 1, load all product
     * @return
     */
    public ArrayList<Product> getProductListFromDB(int page) {
    	ArrayList<Product> products = new ArrayList<Product>();
    	if (page < 1){
    		products = getProductListFromDB();
    	}
    	int first = (page-1) * NUMBER_ITEM_PER_PAGE;
    	int last = first + NUMBER_ITEM_PER_PAGE;
    	products = getProductListFromDB(first,last);
    	return products;
    }
    
    public ArrayList<Product> getProductListFromDB() {
    	
    	ArrayList<Product> products = getProductListFromDB(0,0);
    	return products;
    }
 
 
    
    /**
     * Get a Product when knowing it ID
     * @param id
     * @return
     */
    public Product getProductListFromDBByID(int id) {
   	 ArrayList<Product> products = new ArrayList<>();
   	    Connection conn;;
   	    PreparedStatement ps;;
   	    ResultSet rs;
       try{
           conn = ConnectionManager.getConnection();
           String sql = "";
           if (id > 0 ){
           	sql = PRODUCT_BASE_SQL + " AND product_id = " + String.valueOf(id);
           	System.out.println(sql);
           }else{
           	sql = PRODUCT_BASE_SQL + " ORDER BY product_id DESC LIMIT 0,1";
           }
       
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           rs.next();
           
           //while (rs.next()) {
           	
           	Product product = new Product();
           	product.setProductId(rs.getInt(PRODUCT_ID));
           	product.setProductName(rs.getString(PRODUCT_NAME));
           	product.setCountryOrigin(rs.getString(PRODUCT_COUNTRY));
           	product.setPackingDetail(rs.getString(PRODUCT_PACKAGE));
           	product.setPhysicalAppear(rs.getString(PRODUCT_PHY_APPEAR));
           	product.setCasNumber(rs.getString(PRODUCT_CAS_NUMBER));
           	product.setChemicalFormula(rs.getString(PRODUCT_FORMULA));
           	product.setCountryCode(rs.getString(PRODUCT_COUNTRY_CODE));
          // 	products.add(product);
           	
           //}
           return product;
       }catch (Exception e){
       	return new Product();
       }
           //return list;
        
   }
    
    
    @SuppressWarnings("unchecked")
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
        ArrayList<Product> products = new ArrayList<Product>();
        int page = 1;
        boolean letterChosen = false;
        HttpSession session = req.getSession();
        
        /*
         * Get showPage
         */
        try{
        	page = Integer.parseInt(req.getParameter("showPage"));
        	
        }catch (Exception e){
        	page = 1;
        }
        String letter = req.getParameter("letter");
        
        /*
         *Count PageCount 
         */
        int pageCount;
		try {
			pageCount = getPageCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pageCount = 0;
		}
		
		/*
		 * Get Paging
		 */
        String paging = "";
        if (session.getAttribute("letter-chosen") != null){
        	paging =  getLetterPaging(page, letter, pageCount);
        }else{
        	paging = getNumberPaging(page, pageCount);
        }
        
        
        //ProductDAO pDAO = new ProductDAO();
       // HttpSession session = req.getSession(); 
        products = getProductListFromDB(page);

//        if (session.getAttribute("productList") == null) {
//        	req.setAttribute("message", "no session");
//            //pDAO.databaseRetrieval();
//        	//Get only 3 DB
//            products = getProductListFromDB(page);
//            session.setAttribute("productList", products);
//        } else {
//        	req.setAttribute("message", "have session");
//            products = (ArrayList<Product>) session.getAttribute("productList");
//        }
        
        req.setAttribute("products", products);
        req.setAttribute("page", page);
        req.setAttribute("paging", paging);
        req.getRequestDispatcher("jsp/product/products.jsp").forward(req, resp);

    }
    
    /**
     * get Number of page
     * @return
     * @throws SQLException
     */
    public int getPageCount() throws SQLException{
    	int pageCount = 0;
    	Connection conn = ConnectionManager.getConnection();
    	String sql = "SELECT count(*) FROM tbl_product p inner join tbl_countries c on p.country_origin = c.ccode inner join tbl_phy_appear a on p.physical_appear = a.phy_appear_id inner join tbl_packaging pk on p.packing_details = pk.id where p.r_status ='A' ORDER BY product_id DESC ";
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ResultSet rs = ps.executeQuery();
    	rs.next();
    	int count = rs.getInt(1);
    	 
    	if (count % NUMBER_ITEM_PER_PAGE == 0){
    		pageCount = count/NUMBER_ITEM_PER_PAGE;
    	}else{
    		pageCount = count/NUMBER_ITEM_PER_PAGE + 1;
    	}
    	return pageCount;
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
    		paging += "<li ><a href=\"product?showPage=" + String.valueOf(showPage - 1) + "\">< Previous</a></li>";
    	}
        if (showPage > 3) {

        }
        for (int i = 1; i <= pageCount; i++) {
            if (showPage == i) {

            	paging+="<li  class=\"active\"><a href=\"product?showPage=" + i +"\">" + i + "</a></li>";
            } else {
            	if (i < showPage + 3 && i > showPage - 3) {
        
            		paging += "<li><a href=\"product?showPage=" + i +"\">" + i + "</a></li>";
            	}
            }
        }
        if (showPage < pageCount) {
        

        	paging += "<li ><a href=\"product?showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
        
        }

        
		return paging;
    	
    }
    
    /**
     * Return paging part when paging by Letter
     * @param page
     * @param letter
     * @param pageCount
     * @return
     */
    public String getLetterPaging(int page, String letter, int pageCount){
    	String paging = "";
    	if (page > 1 ){
    		paging += "<li ><a href=\"product?letter=" + letter + "&showPage=" + String.valueOf(page-1) + "\">< Previous</a></li>";
    	}
    	if (page > 3) {

        }
    	for (int i = 1; i <= pageCount; i++) {
            if (page == i) {
            	paging += "<li class=\"active\" ><a href=\"product?letter=" + letter + "&showPage=" + i +"\">" + i + "</a></li>";
            }else{
            	if (i < page + 3 && i > page - 3) {
                    paging += "<li ><a href=\"product?letter="+ letter + "&showPage=" + i + "\">" + i + "</a></li>";

            	}
            }
    	}
    	
        if (page < pageCount) {
        		paging += "<li ><a href=\"product?letter=" +letter + "&showPage=" + String.valueOf(page + 1) + "\">Next ></a></li>";
    
        }
		return paging;
    }
    
    public ArrayList<Product> getProductByCatId(String cateId){
    	ArrayList<Product> products = new ArrayList<>();
   	
   	    Connection conn;;
   	    PreparedStatement ps;;
   	    ResultSet rs;
       try{
           conn = ConnectionManager.getConnection();
           String sql = "";
          // if (count > 0 ){
           //	sql = PRODUCT_BASE_SQL + " ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
           //	System.out.println(sql);
           //}else{
           	sql = PRODUCT_BASE_SQL + " AND category_id like '%" + cateId + "%' order by product_name DESC";
           	System.out.println (sql);
           //}
       
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
          // rs.next();
           /*
            * GEt TOP 3 PRODUCT
            */
           //int count = 0;
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
           	products.add(product);
           	
           }
           return products;
       }catch (Exception e){
       	return products;
       }
    }
 
}
