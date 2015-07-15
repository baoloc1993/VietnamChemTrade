package chemtrade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.product.SupplierProductController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.DetSupplier;
import chemtrade.entity.SupplierProduct;


/**
 * Chane some field:
 * 1.add tnccheck in tbl_det_supplier
 * 2. change desc to price in tbl_supplier_product
 * @author luisngo
 *
 */
@WebServlet("/supplier")
public class SupplierController extends HttpServlet implements Constant {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CountryCode> countryCodes= new CountryCodeController().getCountryCodes();
		String verificationCode = "";
        for (int i = 0; i < 6; i++) {
            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
            verificationCode += rand;
        }
        //req.get
        req.setAttribute("vCode", verificationCode);
		req.setAttribute("countries", countryCodes);
		req.getRequestDispatcher("jsp/new-supplier.jsp").forward(req, resp);
	}
	
	/**
	 * Create a supplier
	 */
	@Override
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	       
	        //DetSupplierDAO s = new DetSupplierDAO();
	        //s.databaseRetrieval();
		try{
	        int id = 0;
	        int supllierId = 0;
	        int areaCode = 0;
	        int deliverDay = 0;
	        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	        //ArrayList<DetSupplier> ds = getSupplierList();
	        
	        try {
	        	DetSupplier detSupplier = getLastSupplier();
		        id = detSupplier.getDet_supplier_id() + 1;
		        String supidTemp = detSupplier.getEnq_code();
		        supidTemp = supidTemp.substring(4, 6);
	            supllierId = Integer.parseInt(supidTemp) + 1;
	        } catch (NumberFormatException | IndexOutOfBoundsException e) {
	            supllierId = 1;
	        }
	        try {
	            areaCode = Integer.parseInt(request.getParameter("areaCode"));
	        } catch (Exception e) {
	            areaCode = 0;
	        }
	        try {
	            deliverDay = Integer.parseInt(request.getParameter("deliverDate"));
	        } catch (Exception e) {
	            deliverDay = 0;
	        }
	        
	        	DetSupplier detSupplier = getSupplier(id, "Sup-" + String.valueOf(supllierId), request.getParameter("companyName"), request.getParameter("companyType"),
				        request.getParameter("establishYear"), request.getParameter("address"), request.getParameter("city"),
				        request.getParameter("companyState"), request.getParameter("companyZip"), request.getParameter("companyCountry"),
				        request.getParameter("companyPhone"), request.getParameter("companyFax"), request.getParameter("companyWeb"),
				        request.getParameter("contactSalutation"), request.getParameter("contactFName"), request.getParameter("contactMName"),
				        request.getParameter("contactLName"), request.getParameter("designation"), request.getParameter("callCode"),
				        areaCode, request.getParameter("companyPhone"), request.getParameter("contactCallCode"), request.getParameter("contactMobile"),
				        request.getParameter("contactEmail"),request.getParameter("contactMessengerType"), request.getParameter("messengerId"), request.getParameter("deliverTerm"),request.getParameter("paymentTerm"), request.getParameter("port"),
				        "", deliverDay, request.getParameter("comments"), 0, str_date2, request.getRemoteAddr(), 0);
				insertSupplier(detSupplier);
				
					 	SupplierProductController supplierProductController = new SupplierProductController();
	//			        supplierProductController.databaseRetrieval();
					 	
					 	String[] productNames = request.getParameter("productName").split(",");
					 	String[] productPrice = request.getParameter("productPrice").split(",");
					 	String[] productSample = request.getParameter("productSample").split(",");
				        id = supplierProductController.getMaxId()+1;
				       // id = sp.get(sp.size() - 1).getSup_pdt_id();
				        String productHeader = "<tr bgcolor=\"#CCCCCC\">\n"
		                        + "  <th colspan=\"2\">Product Name</th>\n"
		                        + "  <th>Price</th>\n"
		                        + "  <th>Sample</th>\n"
		                        + "  \n"
		                        + "  </tr>";
		                String productDetails = "";
		                
				        if ((productNames != null) || (productPrice != null) || (productSample != null)){
				        	for (int i = 0; i < productNames.length; i++) {
						           
						         supplierProductController.insertSupplierProduct(supplierProductController.getProduct(id + i, "Sup-" + String.valueOf(supllierId), productNames[i], productSample[i], productPrice[i]));
						         productDetails += " <tr>\n"
			                                + "    <td colspan=\"2\">" + productNames[i] + "</td>\n"
			                                + "	<td align=\"center\">" + productPrice[i] + "</td>\n"
			                                + "	<td align=\"center\">" + productSample[i] + "</td>\n"
			                                + "	\n"
			                                + "  </tr>";
						            
						     }
				        }
				        
				     

//		                for (int i = 1; i <= 10; i++) {
//		                    if (request.getParameter("product_name" + Integer.toString(i)) != null) {
//		                    	//SupplierProductController supplierProductController = new SupplierProductController();
//		                        databaseInsert2(supplierProductController.getProduct(id + i, "Sup-" + Integer.toString(supllierId), request.getParameter("product_name" + Integer.toString(i)), request.getParameter("sample" + Integer.toString(i)), request.getParameter("price" + Integer.toString(i))));
//		                        
//		                    }
//		                }
		                productDetails = productHeader + productDetails;
		                //start sending email

		                sendEmail(productDetails, detSupplier);
				        
			} catch ( SQLException e) {
				// TODO Auto-generated catch block
				response.sendError(510, e.getMessage());
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				response.sendError(351,e.getMessage());
			}

	       


	    }

	   
	    
	        public void insertSupplier(DetSupplier s) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        //ResultSet rs = null;
	        
	            conn = ConnectionManager.getConnection();
	            ps = conn.prepareStatement("INSERT INTO `tbl_det_supplier` (`det_supplier_id`, `enq_code`, `comapny_name`, `company_type`, `establish_year`, `address`, `city`, `state`, `zip`, `country`, `cmpny_contact_no`, `fax`, `website`, `salutation`, `first_name`, `middle_name`, `last_name`, `designation`, `country_code`, `area_code`, `phone`, `country_code_mob`, `mobile`, `emailid`, `messenger_type`, `messenger_id`, `delivery_term`, `payment_term`, `loading_port`, `usd_per_mt`, `days_to_deliver`, `comments`, `approve`, `created_on`, `ip_address`, `tnccheck`) VALUES"
	                    + "(" + s.getDet_supplier_id() + ", '" + s.getEnq_code() + "', '" + s.getComapny_name() + "', '" + s.getCompany_type() + "', '" + s.getEstablish_year() + "', '" 
	            		+ s.getIp_address() + "', '" + s.getCity() + "', '" + s.getCity() + "', '" + s.getZip() + "', '" + s.getCountry() + "', '" + s.getCmpny_contact_no()
	                    + "', '" + s.getFax() + "', '" + s.getWebsite() + "', '" + s.getSalutation() + "', '" + s.getLast_name() + "', '" + s.getMiddle_name() + "', '" + s.getLast_name() 
	                    + "', '" + s.getDesignation() + "', '" + s.getCountry_code() + "', " + s.getArea_code() + ", '" + s.getPhone() + "', '" + s.getCountry_code_mob() + "', '" + s.getMobile() 
	                    + "', '" + s.getEmailid() + "', '" + s.getMessenger_type() + "', '" + s.getMessenger_id() + "', '" + s.getDelivery_term() + "', '" + s.getPayment_term() + "', '" 
	                    + s.getLoading_port() + "', '" + s.getUsd_per_mt() + "', " + s.getDays_to_deliver() + ", '" + s.getComapny_name() + "', " + s.getApprove() + ", '" + s.getCreated_on() 
	                    + "', '" + s.getIp_address() + "', " + s.getTnccheck() + ");");
	            ps.execute();
	        
	    }
	        
	        

	        /**
	         * Get Last item supplier in tbl_det_supplier
	         * @return
	         * @throws SQLException 
	         */
	        public DetSupplier getLastSupplier() throws SQLException{
	        	Connection conn = null;
	            PreparedStatement ps = null;
	            ResultSet rs = null;
	            
	                conn = ConnectionManager.getConnection();
	                ps = conn.prepareStatement("select * from tbl_det_supplier order by det_supplier_id DESC LIMIT 1;");
	                rs = ps.executeQuery();
	                rs.next();
	               DetSupplier temp =  new DetSupplier();
	               temp.setDet_supplier_id(rs.getInt("det_supplier_id"));
	               temp.setEnq_code(rs.getString("enq_code"));
	                return temp;
	        }

	        

	        public DetSupplier getSupplier(int det_supplier_id,
	                String enq_code, String comapny_name, String company_type, String establish_year, String address, String city,
	                String state, String zip, String country, String cmpny_contact_no, String fax, String website, String salutation, String first_name,
	                String middle_name, String last_name, String designation, String country_code, int area_code, String phone, String country_code_mob, String mobile,
	                String emailid, String messenger_type, String messenger_id, String delivery_term, String payment_term,
	                String loading_port, String usd_per_mt, int days_to_deliver, String comments, int approve, String created_on, String ip_address, int tnccheck) {
	            DetSupplier s = new DetSupplier();
	            s.setDet_supplier_id(det_supplier_id);
	            s.setEnq_code(enq_code);
	            s.setComapny_name(comapny_name);
	            s.setCompany_type(company_type);
	            s.setEstablish_year(establish_year);
	            s.setAddress(address);
	            s.setCity(city);
	            s.setState(state);
	            s.setZip(zip);
	            s.setCountry(country);
	            s.setCmpny_contact_no(cmpny_contact_no);
	            s.setFax(fax);
	            s.setWebsite(website);
	            s.setSalutation(salutation);
	            s.setFirst_name(first_name);
	            s.setMiddle_name(middle_name);
	            s.setLast_name(last_name);
	            s.setDesignation(designation);
	            s.setCountry_code(country_code);
	            s.setArea_code(area_code);
	            s.setPhone(phone);
	            s.setCountry_code_mob(country_code_mob);
	            s.setMobile(mobile);
	            s.setEmailid(emailid);
	            s.setMessenger_id(messenger_id);
	            s.setMessenger_type(messenger_type);
	            s.setDelivery_term(delivery_term);
	            s.setPayment_term(payment_term);
	            s.setLoading_port(loading_port);
	            s.setUsd_per_mt(usd_per_mt);
	            s.setDays_to_deliver(days_to_deliver);
	            s.setComments(comments);
	            s.setApprove(approve);
	            s.setCreated_on(created_on);
	            s.setIp_address(ip_address);
	            s.setTnccheck(tnccheck);
	            return s;
	        }
	        
	        
	        public void sendEmail(String productDetails, DetSupplier detSupllier) throws Exception {

	            String header = "http://" + ROOT + "/images/email_header.jpg";
	            String footer = "http://" + ROOT + "/images/email_footer.jpg";
	            //String to = letterId; 

	            String mailBodyHeader = setMailBodyHeader(detSupllier, header);
	            String mailBodyDetail = setMailBodyDetail(productDetails, detSupllier);
	            String mailBodyFooter = setMailBodyFooter(footer);

	            String adminMailBodyHeader = setAdminMailBodyHeader(header, detSupllier.getSalutation(), detSupllier.getLast_name(), detSupllier.getLast_name());
	            String adminMailBodyFooter = setAdminMailBodyFooter(footer);

	            String mailBody = mailBodyHeader + mailBodyDetail + mailBodyFooter;
	            String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter + mailBodyFooter;
	            EmailController emailController = new EmailController();
	            System.out.println (detSupllier.getEmailid());
	            emailController.sendEmailViaGmail(detSupllier.getEmailid(), mailBody, "Supplier Enquiry");
	            //sendEmailViaGmail(d.getEmailid(), mailBody);
	            sendAdminEmail(adminMailBody);
	        }

	   

	        //sending admin notification
	        private void sendAdminEmail(String adminMailBody) throws Exception {
	            String subject = "Supplier Enquiry – Chemtradeasia Portal";
	            EmailController emailController = new EmailController();
	           // emailController.getAdminEmail();
	            //EmailAccountDAO accountDAO = new EmailAccountDAO();
	            String to = emailController.getAdminEmail();
	            String from = "no-reply@chemtradeasia.com";
	            emailController.sendEmailViaGmail(to, adminMailBody, subject);
	           // Session session = EmailConfiguration.settingGmail();

	        }

	        private String setMailBodyFooter(String footer) {
	            //EnquiryProductDAO edao = new EnquiryProductDAO();

	            String mailBodyFooter = " <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\" height=\"10\"><a href=\"http://localhost:8084/Tradeasia/confirmDetSupplier?sid=" + getLastID() + "\">Please click here to confirm that you want to be a supplier of above products.</a></td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\"><img src=\"" + footer + "\"></td>\n"
	                    + "  </tr>  \n"
	                    + "</table>";
	            return mailBodyFooter;
	        }

	        /**
	         * E-mail body
	         *
	         * @param name
	         * @param email
	         * @param contact
	         * @param product
	         * @param message
	         * @return
	         */
	        private String setMailBodyDetail(final String productDetails, final DetSupplier d) {

	            String mailBodyDetail = "<tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><th colspan=\"4\" bgcolor=\"#CCCCCC\">Company and Contact Details</th></tr>\n"
	                    + "  \n"
	                    + "  <tr> \n"
	                    + "    <th scope=\"row\" align=\"left\">Company Name</th>\n"
	                    + "    <td>" + d.getComapny_name() + "</td>\n"
	                    + "	 <th scope=\"row\" align=\"left\">Year of Establishment</th>\n"
	                    + "    <td>" + d.getEstablish_year() + "</td>\n"
	                    + "	</tr>\n"
	                    + "	\n"
	                    + "	 <tr>\n"
	                    + "    <th width=\"159\" scope=\"row\" align=\"left\">Company Type</th>\n"
	                    + "    <td width=\"302\">" + d.getCompany_type() + "</td>\n"
	                    + "      <th scope=\"row\" align=\"left\">Website</th>\n"
	                    + "    <td>" + d.getWebsite() + "</td>\n"
	                    + "  </tr>\n"
	                    + "   \n"
	                    + " <tr>\n"
	                    + "    <th colspan=\"2\" scope=\"row\" align=\"left\">Address</th>\n"
	                    + "    <th scope=\"row\" align=\"left\">City</th>\n"
	                    + "    <td>" + d.getCity() + "</td>\n"
	                    + "  </tr>\n"
	                    + "\n"
	                    + "  <tr>\n"
	                    + "  <td rowspan=\"3\" colspan=\"2\">" + d.getAddress() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">State</th>\n"
	                    + "    <td>" + d.getState() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Zip</th>\n"
	                    + "    <td>" + d.getZip() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Country</th>\n"
	                    + "    <td>" + d.getCountry() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "   <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Country Code</th>\n"
	                    + "    <td>" + d.getCountry_code() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">Area Code</th>\n"
	                    + "    <td>" + d.getArea_code() + "</td>\n"
	                    + "  </tr>\n"
	                    + " \n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Phone Number</th>\n"
	                    + "    <td>" + d.getPhone() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">Fax</th>\n"
	                    + "    <td>" + d.getFax() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "\n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Contact Name</th>\n"
	                    + "    <td>" + d.getSalutation() + " " + d.getLast_name() + " " + d.getMiddle_name() + " " + d.getLast_name() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">Designation</th>\n"
	                    + "    <td>" + d.getDesignation() + "</td> \n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Country Code</th>\n"
	                    + "    <td>" + d.getCountry_code_mob() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">Mobile</th>\n"
	                    + "    <td>" + d.getMobile() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Emailid</th>\n"
	                    + "    <td>" + d.getEmailid() + "</td>\n"
	                    + "    <th scope=\"row\" align=\"left\">Messenger</th>\n"
	                    + "    <td>" + d.getMessenger_type() + " : " + d.getMessenger_id() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Delivery Term</th>\n"
	                    + "    <td>" + d.getDelivery_term() + "</td>\n"
	                    + "      <th scope=\"row\" align=\"left\">Payment Term</th>\n"
	                    + "    <td>" + d.getPayment_term() + "</td>\n"
	                    + "  </tr>\n"
	                    + "  \n"
	                    + "  <tr>\n"
	                    + "    <th scope=\"row\" align=\"left\">Port of Loading</th>\n"
	                    + "    <td>" + d.getLoading_port() + "</td>\n"
	                    + "   <th scope=\"row\" align=\"left\">Days</th>\n"
	                    + "    <td>" + d.getDays_to_deliver() + "</td>\n"
	                    + "	</tr>\n"
	                    + "	<tr><td height=\"10\"></td></tr>\n"
	                    + "	" + productDetails + "\n"
	                    + "	<tr><td height=\"10\"></td></tr>\n"
	                    + "	 <tr bgcolor=\"#CCCCCC\">\n"
	                    + "    <th scope=\"row\" align=\"center\" colspan=\"4\" >Comments/Notes</th>\n"
	                    + "    \n"
	                    + "   </tr>\n"
	                    + "  \n"
	                    + "   <tr>\n"
	                    + "    <td colspan=\"4\">" + d.getComments() + "</td>\n"
	                    + "  </tr>";

	            return mailBodyDetail;
	        }

	        private String setMailBodyHeader(DetSupplier detSupplier, String header) throws SQLException {

	            String mailBodyHeader = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\" >\n"
	                    + "    <tr>\n"
	                    + "    <td colspan=\"4\"><img src=\"" + header + "\"></td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">Dear " + detSupplier.getSalutation() + " " + detSupplier.getLast_name() + " " + detSupplier.getLast_name() + ",</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">Greetings from Tradeasia International Pte. Ltd!</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">Thanks for your enquiry with Tradeasia International Pte. Ltd. Your enquiry ID is Sup-" + getLastID() + ".</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\">We have received your enquiry and will contact you to follow up your offering product\n"
	                    + "with <a href=\"http://localhost:8084/\">chemtradeasia.co.id</a>. Your Company is required to pass the verification steps to become an \n"
	                    + "approved supplier.</td></tr>\n"
	                    + "	 <tr><td height=\"10\"></td></tr>\n"
	                    + "	 <tr><td height=\"10\"></td></tr>\n"
	                    + "	<tr>\n"
	                    + "    <td colspan=\"4\">The product details are:</td>\n"
	                    + "  </tr>";
	            return mailBodyHeader;
	        }

	        public int getLastID() {

	            Connection conn = null;
	            //Statement stat = null;
	            int id = 0;
	            try {
	                conn = ConnectionManager.getConnection();
	                PreparedStatement ps = conn.prepareStatement("SELECT max(det_supplier_id) FROM tbl_det_supplier");
	                ResultSet rs = ps.executeQuery();
	                rs.next();
	                id = rs.getInt(1);

	            } catch (Exception e1) {
	                e1.printStackTrace();
	            } 
	            return id;
	        }

	        private String setAdminMailBodyFooter(String footer) {
	            String adminMailBodyFooter = "<tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\" height=\"10\"><b>This e-mail was sent from Supplier Form on <a href=\"http://chemtradeasia.co.id\">chemtradeasia.co.id</a> </b></td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\">Best Regards,</td></tr><tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\"><img src=\"" + footer + "\"></td>\n"
	                    + "  </tr>  \n"
	                    + "</table>";
	            return adminMailBodyFooter;
	        }

	        private String setAdminMailBodyHeader(String header, String salutation, String first_name, String last_name) {
	            String adminMailBodyHeader = "";

	            adminMailBodyHeader += "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\" >\n"
	                    + "    <tr>\n"
	                    + "    <td colspan=\"4\"><img src=\"" + header + "\"></td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">Hi,</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">You have a new supplier enquiry.</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  <tr>\n"
	                    + "    <td colspan=\"4\">From: " + salutation + " " + first_name + " " + last_name + "</td>\n"
	                    + "  </tr>\n"
	                    + "  <tr><td height=\"10\"></td></tr>\n"
	                    + "  	 <tr><td height=\"10\"></td></tr>\n"
	                    + "	<tr>\n"
	                    + "    <td colspan=\"4\">The product details are:</td>\n"
	                    + "  </tr>";
	            return adminMailBodyHeader;
	        }
}
