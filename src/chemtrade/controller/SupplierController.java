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
public class SupplierController extends HttpServlet {
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
	        
				insertSupplier(getSupplier(id, "Sup-" + String.valueOf(supllierId), request.getParameter("companyName"), request.getParameter("companyType"),
				        request.getParameter("establishYear"), request.getParameter("address"), request.getParameter("city"),
				        request.getParameter("companyState"), request.getParameter("companyZip"), request.getParameter("companyCountry"),
				        request.getParameter("companyPhone"), request.getParameter("companyFax"), request.getParameter("companyWeb"),
				        request.getParameter("contactSalutation"), request.getParameter("contactFName"), request.getParameter("contactMName"),
				        request.getParameter("contactLName"), request.getParameter("designation"), request.getParameter("callCode"),
				        areaCode, request.getParameter("companyPhone"), request.getParameter("contactCallCode"), request.getParameter("contactMobile"),
				        request.getParameter("contactEmail"),request.getParameter("contactMessengerType"), request.getParameter("messengerId"), request.getParameter("deliverTerm"),request.getParameter("paymentTerm"), request.getParameter("port"),
				        "", deliverDay, request.getParameter("comments"), 0, str_date2, request.getRemoteAddr(), 0));
				
					 	SupplierProductController supplierProductController = new SupplierProductController();
	//			        supplierProductController.databaseRetrieval();
					 	
					 	String[] productNames = request.getParameter("productName").split(",");
					 	String[] productPrice = request.getParameter("productPrice").split(",");
					 	String[] productSample = request.getParameter("productSample").split(",");
				        id = supplierProductController.getMaxId()+1;
				       // id = sp.get(sp.size() - 1).getSup_pdt_id();
				        if ((productNames != null) || (productPrice != null) || (productSample != null)){
				        	for (int i = 0; i < productNames.length; i++) {
						           
						         supplierProductController.insertSupplierProduct(supplierProductController.getProduct(id + i, "Sup-" + String.valueOf(supllierId), productNames[i], productSample[i], productPrice[i]));
						            
						     }
				        }
				        
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
}
