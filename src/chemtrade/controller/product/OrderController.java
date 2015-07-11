/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ERROR 404 : WRONG VERIFICATION CODE
 * ERROR 405 : CART IS EMPTY
 */
package chemtrade.controller.product;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.VerificationCodeController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.Order;
import chemtrade.entity.OrderDetail;
import chemtrade.entity.Product;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
@WebServlet("/order")
public class OrderController extends HttpServlet implements Constant {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	private String deliveryCountry = "";
    private String deliveryDate = "";
   // private String verifyCode = "";
    
    private static final int ERROR_EMPTY_CART = 0;
    private static final int ERROR_VERIFY_CODE = 1;
    private static final int ERROR_QUANTITY = 2;
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("unchecked")
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	ArrayList<Product> cartList = new ArrayList<Product>();
    	HttpSession session = request.getSession();
    	if (session.getAttribute("cartList") == null) {
            cartList = new ArrayList<Product>();
        } else {
            cartList = (ArrayList<Product>) session.getAttribute("cartList");
        }

        String p2 = "";

        if (cartList != null && cartList.size() != 0) {
            p2 = "<b>Product Details</b>";
        }
        //processRequest(request, response);
    	//CountryDAO country = new CountryDAO();
        //OrderDAO order = new OrderDAO();
       // country.databaseRetrieval();
    	CountryCodeController countryCodeController = new CountryCodeController();
        ArrayList<CountryCode> countryList = countryCodeController.getCountryCodes();
        ArrayList<String> companyTypes = getCompanyTypes();
        ArrayList<String> deliveryTerms = getDeliveryTerms();
        ArrayList<String> paymentTerms = getPaymentTerms();
        
       // Order order = getAllParameter(request);

        String orderMessage = "";
        if (cartList.size() == 0) {
           orderMessage = "Your cart is currently empty";
        } else {
           orderMessage = "You are requesting the following:";
        }
        
        String verificationCode = "";
        for (int i = 0; i < 6; i++) {
            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
            verificationCode += rand;
        }
        request.setAttribute("vCode", verificationCode);
//        VerificationCodeController verificationCodeController = new VerificationCodeController();
//        BufferedImage image =  verificationCodeController.getImageVerification(response, verificationCode);
        request.setAttribute("carts", cartList);
        request.setAttribute("cartsSize", cartList.size());

        request.setAttribute("orderMessage", orderMessage);
        
   		request.setAttribute("countries", countryList);
    	request.setAttribute("deliveries", deliveryTerms);
    	request.setAttribute("payments", paymentTerms);
    	request.setAttribute("types", companyTypes);
    	
    	request.setAttribute("types", companyTypes);
    	request.setAttribute("types", companyTypes);
    	//request.setAttribute("order", order);
    	
        request.getRequestDispatcher("jsp/product/order.jsp").forward(request, response);
        //request.getRequestDispatcher("jsp/test.jsp").forward(request, response);
        
        
        
    }

//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	Order order = new Order();
//        try {
//
//        	HttpSession session = request.getSession(false);
//            @SuppressWarnings("unchecked")
//			ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartList");
//            
//            order = getAllParameter(request);
//            String ipAddress = request.getRemoteAddr();
//			//String remoteAddr = request.getRemoteAddr();
//	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
//	        reCaptcha.setPrivateKey(CAPTCHA_PRIVATE_KEY);
//
//	        String challenge = request.getParameter("recaptcha_challenge_field");
//	        String uresponse = request.getParameter("recaptcha_response_field");
//	        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(ipAddress, challenge, uresponse);
//	        if(!reCaptchaResponse.isValid()){
//				//req.setAttribute("message", test);
//	        	//req.getRequestDispatcher("jsp/test.jsp").forward(req,resp);
//	        	response.sendError(ERROR_VERIFY_CODE);
//				
//			}else if (cartList.isEmpty()) {
//            	response.sendError(ERROR_EMPTY_CART);
//                //request.setAttribute("error", "LRequest failed. Your cart is empty");
//            } else {
//
//                    Calendar cal = Calendar.getInstance();
//                    java.sql.Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
//                    String timestamp = time + "";
//                    
//                    CountryCodeController countryCodeController = new CountryCodeController();
//              
//                    String destinationCountry = countryCodeController.getCountryName(deliveryCountry);
//                    int enq_code = 0;
//                    int approve_sts = 0;
//
//                    if (deliveryDate.isEmpty()) {
//                        deliveryDate = "0000-00-00 00:00:00";
//                    }
//
//                    //storing order details to database
//                    int total = cartList.size();
//                    double price = 0.0;
//                    String unit = "";
//                    double quantity = 0.0;
//                    int prodID = 0;
//                    OrderDetail orderDetail = null;
//                    //ProductDAO productDAO = new ProductDAO();
//                    //Order order = new Order(enq_code, companyName, companyType, contactFName, contactMName, contactLName, contactCallCode, contactMobile, contactEmail, contactMessengerType, contactMessengerID, callCode, areaCode, companyPhone, companyFax, address, companyCountry, companyState, city, companyZip, companyWeb, deliveryTerm, paymentTerm, port, destinationCountry, deliveryDate, comments, approve_sts, ipAddress, timestamp);
//
//                    //getting the order details
//                    for (int i = 1; i <= total; i++) {
//                        prodID = Integer.parseInt(request.getParameter("p_ID" + i));
//                        price = Double.parseDouble(request.getParameter("expectedPrice" + i));
//                        unit = request.getParameter("unit" + i);
//                        quantity = Double.parseDouble(request.getParameter("expectedQty" + i));
//                        ProductController productController = new ProductController();
//                        //Product p = productDAO.getProduct(prodID);
//                        Product product  = productController.getProductFromDBByID(prodID); 
//                        orderDetail = new OrderDetail(product, price, unit, quantity);
//                        order.addProductToCart(orderDetail);
//                    }
//
//                    //checking database storage is successful or not
//                    createOrder(order);
//                    session.removeAttribute("cartList");
//
//            }
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            response.sendError(ERROR_QUANTITY);
//            //request.setAttribute("error", "Expected Price/Quantity fields should contain numbers only");
//        }catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(404);
//           // request.setAttribute("error", e.getMessage());
//        }
//    }

	/**
	 * Get all parameter and store into a class
	 * @param request
	 * @param order
	 */
	private Order getAllParameter(HttpServletRequest request) {
		Order order = new Order();
		try{
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(request.getParameter("deliveryDate"));
			order.setDeliveryDate(newstring);
		}catch(Exception e){
			
		}
		//System.out.println(newstring); // 2011-01-18
		order.setDeliveryCountry(request.getParameter("deliveryCountry"));
		order.setDeliveryTerm(request.getParameter("deliveryTerm"));
		
		order.setPort(request.getParameter("port"));
		order.setPaymentTerm(request.getParameter("paymentTerm"));
         order.setCompanyName(request.getParameter("companyName"));
		order.setAddress(request.getParameter("address"));
         order.setCity(request.getParameter("city"));
         order.setCallCode(request.getParameter("callCode"));
         order.setAreaCode(request.getParameter("areaCode"));
         order.setCompanyWeb(request.getParameter("CompanyWeb"));
         order.setCompanyType(request.getParameter("companyType"));
         order.setCompanyCountry(request.getParameter("companyCountry"));
         order.setCompanyState(request.getParameter("companyState"));
         order.setCompanyZip(request.getParameter("companyZip"));
         order.setCompanyPhone(request.getParameter("companyPhone"));
         order.setCompanyFax(request.getParameter("companyFax"));
         order.setContactSalution(request.getParameter("contactSalution"));
         order.setContactFName(request.getParameter("contactFName"));
         order.setContactCallCode(request.getParameter("contactCallCode"));
         order.setContactMobile(request.getParameter("contactMobile"));
         order.setContactMessengerType(request.getParameter("contactMessengerType"));
         order.setContactMName(request.getParameter("contactMName"));
         order.setContactLName(request.getParameter("contactLName"));
         order.setContactEmail(request.getParameter("contactEmail"));
         order.setContactMessengerID(request.getParameter("contactMessengerID"));
         order.setComments(request.getParameter("comments"));
         order.setIpaddress(request.getLocalAddr());
         order.setVerifyCode(request.getParameter("verifyCode"));
         
         return order;
	}

    
    	    
	    public void insertOrderDetails(Order order, int orderID) throws SQLException {

	        ArrayList<OrderDetail> orderList = order.getOrderList();
	        
	        Connection conn;

	        for (OrderDetail o : orderList) {
	                conn = ConnectionManager.getConnection();
	                String sql  = "INSERT INTO tbl_order_details (order_id ,  quantity ,  unit ,  expc_price ,  product_id ,  product_name ) VALUES ('" + orderID + "','" + o.getQuantity() + "','" + o.getUnit() + "','" + o.getPrice() + "','" + o.getP().getProductId() + "','" + o.getP().getProductName() + "')";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.execute();
	        }

	        
	    }

    	   

	    
	    /**
	     * Get delvivery term in tbl_delivery_terms
	     * @return
	     */
	    @SuppressWarnings("finally")
		public ArrayList<String> getDeliveryTerms() {
	    	ArrayList<String> deliveryTermList = new ArrayList<String>();
	    	Connection conn;
	        try {
	            conn = ConnectionManager.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_delivery_terms");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                deliveryTermList.add(rs.getString("delivery_term"));

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	           
	        }finally{

	        	return deliveryTermList;
	        }

	    }
	    
	    /**
	     * Get data from tbl_companytype
	     * @return
	     */
	    @SuppressWarnings("finally")
		public ArrayList<String> getCompanyTypes() {
	    	Connection conn;
	        ArrayList<String> companyList = new ArrayList<String>();
			try {
	            conn = ConnectionManager.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_companytype");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                companyList .add(rs.getString("company_type"));

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	return companyList;
	        }

	    }

	    public ArrayList<String> getPaymentTerms() {
	    	Connection conn;
	        ArrayList<String> paymentTermList = new ArrayList<String>();
			try {
	            conn = ConnectionManager.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_payment_terms");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                paymentTermList .add(rs.getString("payment_term"));

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {

	        	return paymentTermList;
	        }

	    }
	    
	
}
