/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ERROR 404 : WRONG VERIFICATION CODE
 * ERROR 405 : CART IS EMPTY
 */
package chemtrade.controller.product;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.CountryCodeController;
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
public class OrderController extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    	//CountryDAO country = new CountryDAO();
        //OrderDAO order = new OrderDAO();
       // country.databaseRetrieval();
    	CountryCodeController countryCodeController = new CountryCodeController();
        ArrayList<CountryCode> countryList = countryCodeController.getCountryCodes();
        ArrayList<String> companyTypes = order.getCompanyTypes();
        ArrayList<String> deliveryTerms = order.getDeliveryTerms();
        ArrayList<String> paymentTerms = order.getPaymentTerms();

//        String dC = "";
//        String dT = "";
//        String dD = "";
//        String p = "";
//        String pT = "";
//        String cN = "";
//        String add = "";
//        String ct = "";
//        String cC = "";
//        String aC = "";
//        String cW = "";
//        String cT = "";
//        String cCty = "";
//        String cS = "";
//        String cZ = "";
//        String cP = "";
//        String cF = "";
//        String cFN = "";
//        String cCC = "";
//        String cM = "";
//        String cMN = "";
//        String cLN = "";
//        String cE = "";
//        String cMID = "";
//        String com = "";
//
//        dC = (String) request.getAttribute("deliveryCountry");
//        if (dC == null) {
//            dC = "";
//        }
//        dT = (String) request.getAttribute("deliveryTerm");
//        if (dT == null) {
//            dT = "";
//        }
//        dD = (String) request.getAttribute("deliveryDate");
//        if (dD == null) {
//            dD = "";
//        }
//        p = (String) request.getAttribute("port");
//        if (p == null) {
//            p = "";
//        }
//        pT = (String) request.getAttribute("paymentTerm");
//        if (pT == null) {
//            pT = "";
//        }
//        cN = (String) request.getAttribute("companyName");
//        if (cN == null) {
//            cN = "";
//        }
//        add = (String) request.getAttribute("address");
//        if (add == null) {
//            add = "";
//        }
//        ct = (String) request.getAttribute("city");
//        if (ct == null) {
//            ct = "";
//        }
//        cC = (String) request.getAttribute("callCode");
//        if (cC == null) {
//            cC = "";
//        }
//        aC = (String) request.getAttribute("areaCode");
//        if (aC == null) {
//            aC = "";
//        }
//        cW = (String) request.getAttribute("CompanyWeb");
//        if (cW == null) {
//            cW = "";
//        }
//        cT = (String) request.getAttribute("companyType");
//        if (cT == null) {
//            cT = "";
//        }
//        cCty = (String) request.getAttribute("companyCountry");
//        if (cCty == null) {
//            cCty = "";
//        }
//        cS = (String) request.getAttribute("companyState");
//        if (cS == null) {
//            cS = "";
//        }
//        cZ = (String) request.getAttribute("companyZip");
//        if (cZ == null) {
//            cZ = "";
//        }
//        cP = (String) request.getAttribute("companyPhone");
//        if (cP == null) {
//            cP = "";
//        }
//        cF = (String) request.getAttribute("companyFax");
//        if (cF == null) {
//            cF = "";
//        }
//
//        cFN = (String) request.getAttribute("contactFName");
//        if (cFN == null) {
//            cFN = "";
//        }
//        cCC = (String) request.getAttribute("contactCallCode");
//        if (cCC == null) {
//            cCC = "";
//        }
//        cM = (String) request.getAttribute("contactMobile");
//        if (cM == null) {
//            cM = "";
//        }
//
//        cMN = (String) request.getAttribute("contactMName");
//        if (cMN == null) {
//            cMN = "";
//        }
//        cLN = (String) request.getAttribute("contactLName");
//        if (cLN == null) {
//            cLN = "";
//        }
//        cE = (String) request.getAttribute("contactEmail");
//        if (cE == null) {
//            cE = "";
//        }
//        cMID = (String) request.getAttribute("contactMessengerID");
//        if (cMID == null) {
//            cMID = "";
//        }
//        com = (String) request.getAttribute("comments");
//        if (com == null) {
//            com = "";
//        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Order order = new Order();
        try {

            order.setDeliveryCountry(request.getParameter("deliveryCountry"));
            order.setDeliveryTerm(request.getParameter("deliveryTerm"));
            order.setDeliveryDate(request.getParameter("deliveryDate"));
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
            
            HttpSession session = request.getSession(false);
            @SuppressWarnings("unchecked")
			ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartList");

            String rand = (String) session.getAttribute("rand");
            if (!rand.equalsIgnoreCase(order.getVerifyCode())) {
                //request.setAttribute("error", "Wrong verification code");
                response.sendError(ERROR_VERIFY_CODE);
                //request.setAttribute("order", order);
               // setFields(request);
            } else if (cartList.isEmpty()) {
            	response.sendError(ERROR_EMPTY_CART);
                //request.setAttribute("error", "LRequest failed. Your cart is empty");
            } else {

                    
                    Calendar cal = Calendar.getInstance();
                    java.sql.Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
                    String timestamp = time + "";
                    
                    CountryCodeController countryCodeController = new CountryCodeController();
              
                    String destinationCountry = countryCodeController.getCountryName(deliveryCountry);
                    int enq_code = 0;
                    int approve_sts = 0;

                    if (deliveryDate.isEmpty()) {
                        deliveryDate = "0000-00-00 00:00:00";
                    }

                    //storing order details to database
                    int total = cartList.size();
                    double price = 0.0;
                    String unit = "";
                    double quantity = 0.0;
                    int prodID = 0;
                    OrderDetail orderDetail = null;
                    //ProductDAO productDAO = new ProductDAO();
                    //Order order = new Order(enq_code, companyName, companyType, contactFName, contactMName, contactLName, contactCallCode, contactMobile, contactEmail, contactMessengerType, contactMessengerID, callCode, areaCode, companyPhone, companyFax, address, companyCountry, companyState, city, companyZip, companyWeb, deliveryTerm, paymentTerm, port, destinationCountry, deliveryDate, comments, approve_sts, ipAddress, timestamp);

                    //getting the order details
                    for (int i = 1; i <= total; i++) {
                        prodID = Integer.parseInt(request.getParameter("p_ID" + i));
                        price = Double.parseDouble(request.getParameter("expectedPrice" + i));
                        unit = request.getParameter("unit" + i);
                        quantity = Double.parseDouble(request.getParameter("expectedQty" + i));
                        ProductController productController = new ProductController();
                        //Product p = productDAO.getProduct(prodID);
                        Product product  = productController.getProductListFromDBByID(prodID); 
                        orderDetail = new OrderDetail(product, price, unit, quantity);
                        order.addProductToCart(orderDetail);
                    }

                    //checking database storage is successful or not
                    createOrder(order);
                    session.removeAttribute("cartList");

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(ERROR_QUANTITY);
            //request.setAttribute("error", "Expected Price/Quantity fields should contain numbers only");
        }catch (Exception e) {
            e.printStackTrace();
            response.sendError(404);
           // request.setAttribute("error", e.getMessage());
        }
    }

    /**
     * Create Order after the user request
     * @param order
     * @return
     * @throws SQLException 
     * @throws Exception
     */
    public void createOrder(Order order) throws SQLException {
    	//String company_name, String company_type, String contact_person_name, String middle_name, String last_name, String country_code_mob, String mobile_no, String email_id, String messenger_type, String messenger_id, String country_code, String area_code, String phone, String fax, String address, String country, String state, String city, String zip, String website, String delivery_term, String payment_term, String destination_port, String destination_country, String target_del_date, String comments, String ip_address, String created_on
    		Connection conn;
	        //int row = 0;
	        int orderID = getLastOrderID() + 1;

	        int enq_code = order.getEnq_code();
	        String company_name = order.getCompanyName();
	        String company_type = order.getCompanyType();
	        String contact_person_name = order.getContactFName();
	        String middle_name = order.getContactMName();
	        String last_name = order.getContactLName();
	        String country_code_mob = order.getContactCallCode();
	        String mobile_no = order.getContactMobile();
	        String email_id = order.getContactEmail();
	        String messenger_type = order.getContactMessengerType();
	        String messenger_id = order.getContactMessengerID();
	        String country_code = order.getContactCallCode();
	        String area_code = order.getAreaCode();
	        String phone = order.getCompanyPhone();
	        String fax = order.getCompanyFax();
	        String address = order.getAddress();
	        String country = order.getCompanyCountry();
	        String state = order.getCompanyState();
	        String city = order.getCompanyState();
	        String zip = order.getCompanyZip();
	        String website = order.getCompanyWeb();
	        String delivery_term = order.getDeliveryTerm();
	        String payment_term = order.getPaymentTerm();
	        String destination_port = order.getPort();
	        String destination_country = order.getDeliveryCountry();
	        String target_del_date = order.getDeliveryDate();
	        String comments = order.getComments();
	        int approve_sts = 0;
	        String ip_address = order.getIpaddress();
	        String created_on = order.getTimestamp();

	        
            conn = ConnectionManager.getConnection();
            String sql = "INSERT INTO tbl_order(order_id,enq_code, company_name,"
                    + "company_type, contact_person_name,middle_name, last_name, country_code_mob, mobile_no, email_id,"
                    + "messenger_type, messenger_id, country_code,area_code, phone, fax, address, country, state, city,"
                    + "zip, website, delivery_term, payment_term,destination_port, destination_country, target_del_date,"
                    + "comments, approve_sts, created_on, ip_address) "
                    + "VALUES(" + orderID + ",'" + enq_code + "','" + company_name + "','" + company_type + "','" + contact_person_name + "','"
                    + middle_name + "','" + last_name + "','" + country_code_mob + "','" + mobile_no + "','" + email_id + "','"
                    + messenger_type + "','" + messenger_id + "','" + country_code + "','" + area_code + "','" + phone + "','"
                    + fax + "','" + address + "','" + country + "','" + state + "','" + city + "','" + zip + "','" + website + "','"
                    + delivery_term + "','" + payment_term + "','" + destination_port + "','" + destination_country + "','"
                    + target_del_date + "','" + comments + "'," + approve_sts + ",'" + created_on + "','" + ip_address + "')";
            PreparedStatement ps = conn.prepareStatement(sql);

            if (!ps.execute()){
            	insertOrderDetails(order, orderID);
            }
            
           // session.removeAttribute("cartList");


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
	     * Get the last id of table tbl_order
	     * @return
	     */
	    public int getLastOrderID() {
	    	Connection conn;
	        try {
	            conn = ConnectionManager.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT MAX(order_id) as max FROM tbl_order");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                return rs.getInt("max");

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 

	        //if no return result from rs.next(), return 0 as new ID
	        return 0;

	    }
}
