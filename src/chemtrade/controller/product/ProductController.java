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


    /**
     * Get Product from database
     * @param count : number want to get. <=0 means all product
     * @return 
     * @throws SQLException 
     */
    public ArrayList<Product> getProductListFromDB(int count) {
    	 ArrayList<Product> products = new ArrayList<>();
    	    Connection conn;;
    	    PreparedStatement ps;;
    	    ResultSet rs;
        try{
            conn = ConnectionManager.getConnection();
            String sql = "";
            if (count > 0 ){
            	sql = PRODUCT_BASE_SQL + " ORDER BY product_id DESC limit 0," + String.valueOf(count);
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
        //ProductDAO pDAO = new ProductDAO();
        HttpSession session = req.getSession(); 
        if (session.getAttribute("productList") == null) {
            //pDAO.databaseRetrieval();
        	//Get only 3 DB
            products = getProductListFromDB(3);
            session.setAttribute("productList", products);
        } else {
            products = (ArrayList<Product>) session.getAttribute("productList");
        }
        
        req.setAttribute("products", products);
        req.getRequestDispatcher("jsp/product/products.jsp").forward(req, resp);

    }
    
 
}
