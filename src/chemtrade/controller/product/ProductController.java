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
import chemtrade.controller.EmailController;
import chemtrade.entity.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet implements Constant{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
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
            	product.setDescription(rs.getBlob(PRODUCT_DESC));
               	product.setApplication(rs.getString(PRODUCT_APPLICATION));
            	products.add(product);
            	
            }
            return products;
        }catch (Exception e){
        	return products;
        }
            //return list;
         
    }
    
    
    /**
     * Get Product from database which result will come from first position to last position
     * Select product with name begin with letter 
     * in database (exclusive first and inclusive last)
     * If first or last < 0, load all data
     * 
     * @params letter
     * @return 
     * @throws SQLException 
     */
    public ArrayList<Product> getProductListFromDB(int first, int last, char letter) {
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
            	sql = PRODUCT_BASE_SQL + " AND product_name like '"+ letter + "%' ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
            	System.out.println(sql);
            }else{
            	sql = PRODUCT_BASE_SQL + " AND product_name like '"+ letter + "%' ORDER BY product_id DESC";
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
     * Get Product according to keyword
     * @param first
     * @param last
     * @param search : keyword
     * @return
     */
    public ArrayList<Product> getSearchProductList(int first, int last, String search) {
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
           	sql = PRODUCT_BASE_SQL + " AND product_name like '%"+ search + "%' ORDER BY product_id DESC limit " + count +" OFFSET " + first ;
           	System.out.println(sql);
           }else{
           	sql = PRODUCT_BASE_SQL + " AND product_name like '%"+ search + "%' ORDER BY product_id DESC";
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
     * Get product list through page and letter
     * @param page: page want to load. 10 products in each page
     * if page < 1, load all product
     * @return
     */
    public ArrayList<Product> getSearchProductList(int page, String keyword) {
    	ArrayList<Product> products = new ArrayList<Product>();
    	if (page < 1){
    		products = getSearchProductList(0,0,keyword);
    	}
    	int first = (page-1) * NUMBER_ITEM_PER_PAGE;
    	int last = first + NUMBER_ITEM_PER_PAGE;
    	products = getSearchProductList(first,last,keyword);
    	return products;
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
    
    
    /**
     * Get product list through page and letter
     * @param page: page want to load. 10 products in each page
     * if page < 1, load all product
     * @return
     */
    public ArrayList<Product> getProductListFromDB(int page, char letter) {
    	ArrayList<Product> products = new ArrayList<Product>();
    	if (page < 1){
    		products = getProductListFromDB(0,0,letter);
    	}
    	int first = (page-1) * NUMBER_ITEM_PER_PAGE;
    	int last = first + NUMBER_ITEM_PER_PAGE;
    	products = getProductListFromDB(first,last,letter);
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
    public Product getProductFromDBByID(int id) {
   	 
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
           	product.setDescription(rs.getBlob(PRODUCT_DESC));
           	product.setApplication(rs.getString(PRODUCT_APPLICATION));
          // 	products.add(product);
           	
           //}
           return product;
       }catch (Exception e){
       	return new Product();
       }
           //return list;
        
   }
    
    
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
        ArrayList<Product> products = new ArrayList<Product>();
        int page = 1;
//        boolean letterChosen = false;
//        HttpSession session = req.getSession();
        
        
        /*
         * Get showPage
         */
        try{
        	page = Integer.parseInt(req.getParameter("showPage"));
        }catch (Exception e){
        	page = 1;
        
        }
        
        String paging = "";
        String letter = req.getParameter("letter");
        if ((letter == null) || (letter.length() != 1) || !(Character.isLetter(letter.charAt(0)))){
        	products = getProductListFromDB(page);
        	paging =  getNumberPaging(page, products.size());
        }else{
        	products = getProductListFromDB(page,letter.charAt(0));
        	paging =  getLetterPaging(page, letter, products.size());

        }

        
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
    
    
    /**
	 * Get the list of Top Product
	 */
	public ArrayList<Product> getTopProducts(){
		ArrayList<Product> topProduct = new ArrayList<Product>();
		Connection conn = null;

	      try {
	         //String URL = "jdbc:mysql://127.0.0.1/local";
	         
	         conn = ConnectionManager.getConnection();
	         String sql = "select a.product_id as pid, b.product_name as pname, b.product_image, b.msds, b.specification, b.facebook_url, "
	        	 		+ "b.twitter_url, b.skype_id from tbl_home_products a, "
	         		+ "tbl_product b where a.product_id=b.product_id order by pname ASC";
	         //System.out.println (sql);
	         PreparedStatement ps = conn.prepareStatement(sql);
	         //ps.setString(1, user);
	         //ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 
	        	 Product product = new Product();
//	        	 String sql2 = "select a.facebook_id, b.twitter_id, c.skype_id from tbl_facebook_accounts a, "
//	        	 		+ "tbl_twitter_accounts b, tbl_skype_accounts c where a.id = "+ rs.getString(6) + " OR b.id=" + rs.getString(7) + " OR c.id=" + rs.getString(8);
//		         System.out.println (sql2);
	        	 PreparedStatement ps2 = conn.prepareStatement("select a.facebook_id, b.twitter_id, c.skype_id from tbl_facebook_accounts a, "
		        	 		+ "tbl_twitter_accounts b, tbl_skype_accounts c where a.id = "+ rs.getString(6) + " OR b.id=" + rs.getString(7) + " OR c.id=" + rs.getString(8));
		         ResultSet rs2 = ps2.executeQuery();
		         rs2.first();
//		        System.out.println (rs2.getFetchSize());
		         //Set Attribute of Product
		         product.setProductId(rs.getInt(1));
		         product.setProductName(rs.getString(2));
		         product.setProductImage(rs.getString(3));
		         product.setMsds(rs.getString(4));
		         product.setSpecification(rs.getString(5));
		         product.setFacebookUrl(rs2.getString(1));
		         product.setTwitterUrl(rs2.getString(2));
		         product.setSkypeId(rs2.getString(3));
	        	 //product.setProductId(rs.getInt	(1));
	        	 //product.setProductName(rs.getString(2));
	        	 topProduct.add(product);
	           
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  topProduct.add(new Product());
	         
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
		return topProduct;
	      
	}

 
}
