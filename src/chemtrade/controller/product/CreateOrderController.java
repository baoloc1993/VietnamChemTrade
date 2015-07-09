package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
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
import chemtrade.controller.EmailController;
import chemtrade.entity.Order;
import chemtrade.entity.OrderDetail;
import chemtrade.entity.Product;

@WebServlet("/createOrder")
public class CreateOrderController extends HttpServlet implements Constant{
	private String deliveryCountry = "";
    private String deliveryDate = "";
   // private String verifyCode = "";
    
    private static final int ERROR_EMPTY_CART = 0;
    private static final int ERROR_VERIFY_CODE = 1;
    private static final int ERROR_QUANTITY = 2;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //preparing to direct the controller back to order.jsp after all codes are executed
		Order order = new Order();
        try {

        	HttpSession session = request.getSession(false);
            @SuppressWarnings("unchecked")
			ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartList");
            
            order = getAllParameter(request);
            String ipAddress = request.getRemoteAddr();
			//String remoteAddr = request.getRemoteAddr();
	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	        reCaptcha.setPrivateKey(CAPTCHA_PRIVATE_KEY);

	        String challenge = request.getParameter("recaptcha_challenge_field");
	        String uresponse = request.getParameter("recaptcha_response_field");
	        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(ipAddress, challenge, uresponse);
	        if(!reCaptchaResponse.isValid()){
				//req.setAttribute("message", test);
	        	//req.getRequestDispatcher("jsp/test.jsp").forward(req,resp);
	        	response.sendError(ERROR_VERIFY_CODE);
				
			}else if (cartList.isEmpty()) {
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
                        Product product  = productController.getProductFromDBByID(prodID); 
                        orderDetail = new OrderDetail(product, price, unit, quantity);
                        order.addProductToCart(orderDetail);
                    }

                    //checking database storage is successful or not
                    createOrder(order);
                    session.removeAttribute("cartList");
                    request.setAttribute("orderMessage", "Order Successfully");
                    

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            //response.sendError(ERROR_QUANTITY);
            request.setAttribute("orderMessage", "Expected Price/Quantity fields should contain numbers only");
        }catch (Exception e) {
            e.printStackTrace();
           // response.sendError(404);
            request.setAttribute("orderMessage", e.getMessage());
        }finally{
        	request.getRequestDispatcher("order").forward(request, response);
        }
        return;
            
         

    }

    //send email to user for confirmation
    private void sendOrderMail(Order order) throws Exception {
        String header = "http://" + ROOT + "/images/email_header.jpg";
        String footer = "http://" + ROOT + "/images/email_footer.jpg";
        //String to = letterId; 

        String salutation = order.getContactSalution() + " " + order.getContactLName();
        String mailBodyHeader = setMailBodyHeader(salutation, header);
        String mailBodyDetail = setMailBodyDetail(order);
        String mailBodyFooter = setMailBodyFooter(footer);
        String adminMailBodyHeader = setAdminMailBodyHeader(header,order);
        String adminMailBodyFooter = setAdminMailBodyFooter(footer);
        String mailBody = mailBodyHeader + mailBodyDetail + mailBodyFooter;
        String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter + mailBodyFooter;

        //send user
        
      //  sendEmailViaGmail(order.getContactEmail(), mailBody);
        new EmailController().sendEmailViaGmail(order.getContactEmail(), mailBody, "Product Order Confirmation");
        
        //send to admin
        String adminSubject = "New Order – Chemtradeasia Portal";
        EmailController emailController = new EmailController();
        String to = emailController.getAdminEmail();   
        emailController.sendEmailViaGmail(to, adminMailBody, adminSubject);
        //sendAdminEmail(adminMailBody);
    }


    
    private String setAdminMailBodyFooter(String footer) {
        String adminMailBodyFooter = "<tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\"><b>This e-mail was sent from Order Form on <a href=\"http://javaid.tradeasia.us/\">http://javaid.tradeasia.us/</a> </b></td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  \n"
                + "  <tr>\n"
                + "    <td colspan=\"4\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "</table>";
        return adminMailBodyFooter;
    }

    private String setAdminMailBodyHeader(String header, Order order) {
        String adminMailBodyHeader = "";
        adminMailBodyHeader += "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">\n"
                + " <tr>\n"
                + "    <td colspan=\"4\"><img src=\"" + header + " \"></td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"4\">Hi,</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"4\">You have a new order request.</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"4\">From: "+order.getContactFName() + " " + order.getContactMName() + " " + order.getContactLName() + ",</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + " \n"
                + "  <tr>\n"
                + "    <td colspan=\"4\">Your order details are follows.</td>\n"
                + "  </tr>";
        return adminMailBodyHeader;
    }

    private String setMailBodyHeader(String name, String header) throws SQLException {
//        String insertId = getMaxID();
        
        String insertId = getLastOrderID() + "";
        String mailBodyHeader = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\">";
        mailBodyHeader += "<tr>";
        mailBodyHeader += "<td colspan=\"3\"><img src=\"" + header + "\"></td>";
        mailBodyHeader += "</tr>";
        mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
        mailBodyHeader += "<tr>";
        mailBodyHeader += "<td colspan=\"3\">Dear " + name + ",</td>";
        mailBodyHeader += "</tr>";
        mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
        mailBodyHeader += "<tr>";
        mailBodyHeader += "<td colspan=\"3\">Greetings from Tradeasia International Pte. Ltd!</td>";
        mailBodyHeader += "</tr>";
        mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
        mailBodyHeader += "<tr>";
        mailBodyHeader += "<td colspan=\"4\">Thank you for your order with Tradeasia. Your order ID is '" + insertId + "'. Please click the below link for reconfirmation.</td>";
        mailBodyHeader += "</tr>";
        mailBodyHeader += "<tr><td height=\"10\"></td></tr>";
        mailBodyHeader += "<tr>";
        mailBodyHeader += "<td colspan=\"4\"><a href=\"http://localhost:8084/Tradeasia/confirmOrder?id=" + insertId + "\">Please click here to confirm your order list</a></td>";
        mailBodyHeader += "</tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"4\">Your order details are follows.</td>\n"
                + "  </tr>";
        return mailBodyHeader;
    }

    private String setMailBodyDetail(Order order) {

        //get all product details requested
        String orderDetails = "";
        ArrayList<OrderDetail> orderList = order.getOrderList();
        for (OrderDetail od : orderList) {
            orderDetails += "                                   <tr>\n"
                    + "                                      <td ><a href=\"localhost:8084/Tradeasia/product-details.jsp?id=\"" + od.getP().getProductId() + "\">" + od.getP().getProductName() + "</a></td>\n"
                    + "	                              <td align=\"center\">" + od.getPrice() + "USD</td>\n"
                    + "                                      <td align=\"center\">" + od.getUnit() + "</td>\n"
                    + "	                              <td align=\"center\">" + od.getQuantity() + "</td>\n"
                    + "                                   </tr>";
        }

        String mailBodyDetail = "<tr><td height=\"10\"></td></tr>\n"
                + "<tr><th colspan=\"4\" bgcolor=\"#CCCCCC\">Company and Contact Details</th></tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Company Name</th>\n"
                + "    <td>" + order.getCompanyName() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Company Type</th>\n"
                + "    <td>" + order.getCompanyType() + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th colspan=\"2\" scope=\"row\" align=\"left\">Address</th>\n"
                + "    <th scope=\"row\" align=\"left\">Country</th>\n"
                + "    <td>" + order.getCompanyCountry() + "</td>\n"
                + "  </tr>\n"
                + "  <tr> <td rowspan=\"3\" colspan=\"2\">" + order.getAddress() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">State</th>\n"
                + "    <td>" + order.getCompanyState() + "</td>\n"
                + "	</tr>\n"
                + "	<tr>\n"
                + "    <th scope=\"row\" align=\"left\">City</th>\n"
                + "    <td>" + order.getCity() + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Zip</th>\n"
                + "    <td>" + order.getCompanyZip() + "</td>\n"
                + "  </tr>\n"
                + "  \n"
                + "   <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Country Code</th>\n"
                + "    <td>" + order.getCompanyCountry() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Area Code</th>\n"
                + "    <td>" + order.getAreaCode() + "</td>\n"
                + "  </tr>\n"
                + "  \n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Phone</th>\n"
                + "    <td>" + order.getCompanyPhone() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Fax</th>\n"
                + "    <td>" + order.getCompanyFax() + "</td>\n"
                + "  </tr>\n"
                + "   <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Contact Name</th>\n"
                + "    <td>" + order.getContactFName() + " " + order.getContactMName() + " " + order.getContactLName() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Mobile Number</th>\n"
                + "    <td>" + order.getContactCallCode() + " " + order.getContactMobile() + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Mail Id</th>\n"
                + "    <td>" + order.getContactEmail() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Messenger </th>\n"
                + "    <td>" + order.getContactMessengerType() + ":" + order.getContactMessengerID() + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Website</th>\n"
                + "    <td>" + order.getCompanyWeb() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Target Delivery Date</th>\n"
                + "    <td>" + order.getDeliveryDate() + "</td>\n"
                + "  </tr>\n"
                + "   <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Destination Coiuntry</th>\n"
                + "    <td>" + order.getDestinationCountry() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Destination Port</th>\n"
                + "    <td>" + order.getPort() + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\" align=\"left\">Delivery Terms</th>\n"
                + "    <td>" + order.getDeliveryTerm() + "</td>\n"
                + "    <th scope=\"row\" align=\"left\">Payment Terms</th>\n"
                + "    <td>" + order.getPaymentTerm() + "</td>\n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  " + orderDetails + "\n"
                + "  \n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr>\n"
                + "    <th scope=\"row\"  colspan=\"4\" bgcolor=\"#CCCCCC\">Comments</th></tr><tr>\n"
                + "    <td colspan=\"4\">" + order.getComments() + "</td>\n"
                + "  </tr>";
        return mailBodyDetail;
    }

    private String setMailBodyFooter(String footer) {
        String mailBodyFooter = "<tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\" height=\"10\">We will contact you as soon as possible to follow up your order with <a href=\"chemtradeasia.com\">chemtradeasia.com</a> </td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  \n"
                + "  <tr>\n"
                + "    <td colspan=\"4\"><img src=\"" + footer + "\"></td>\n"
                + "  </tr>\n"
                + "</table>";
        return mailBodyFooter;
    }

    
    /**
	 * Get all parameter and store into a class
	 * @param request
	 * @param order
	 */
	private Order getAllParameter(HttpServletRequest request) {
		Order order = new Order();
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
         
         return order;
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
