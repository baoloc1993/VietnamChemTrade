/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.EmailController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.EnquiryProduct;
import chemtrade.entity.Product;


/**
 *
 * @author Toshiba PC
 */
@WebServlet("/sendEnquiry")
public class SendEnquiryController extends HttpServlet implements Constant {

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String salutation = request.getParameter("contactSalution");
        String firstName = request.getParameter("contactFName");
        String middleName = request.getParameter("contactMName");
        String lastName = request.getParameter("contactLName");
        String email = request.getParameter("contactEmail");
        String countryCode = request.getParameter("contactCallCode");
        String phoneNumber = request.getParameter("contactMobile");
        String country = request.getParameter("companyCountry");
        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String ipaddress = request.getLocalAddr();
        String company_name = request.getParameter("companyName");
        String company_address = request.getParameter("address");
        String comments = request.getParameter("comments");
        String destination_port = request.getParameter("port");

        //EnquiryProductDAO edao = new EnquiryProductDAO();
        //edao.databaseRetrieval();
        //String quickquote_size = Integer.toString(edao.getTable().size());

        

        try {
            //int success1 = 0;
           // int success2 = 0;
            String productsEnquired = "";
            int quickQuoteSize = getQuickQuoteSize();
            insertQuickquote(String.valueOf(quickQuoteSize), salutation, firstName, middleName, lastName, email, countryCode, phoneNumber, country, str_date2, ipaddress, company_name, company_address, comments, destination_port);
            //input consumer's product details into tbl_quickquote_prdtinfo
            
            
            
            String[] productName = request.getParameterValues("productName");
            String[] productQty = request.getParameterValues("productQty");
            String[] productUnit = request.getParameterValues("productUnit");
            for (int i = 0; i < productName.length; i++) {

                
                    //inputs consumer details into tbl_quickquote
                    String pname = productName[i];
                    String qty = productQty[i];
                    String measurement = productUnit[i];
                    intsertQuickquoteProductInfo(pname, qty, measurement);

                    productsEnquired += "<tr>\n"
                            + "                                   <td colspan=\"2\" align=\"center\">" + pname + "</td>\n"
                            + "	                           <td align=\"center\">" + qty + "</td>\n"
                            + "<td align=\"center\">" + measurement + "</td>\n"
                            + "	                           </tr>";
                
            }

           

                //send user email
                sendEmail(String.valueOf(quickQuoteSize), salutation, firstName, middleName, lastName, email,
                        countryCode, phoneNumber, country, str_date2, ipaddress, company_name,
                        company_address, comments, destination_port, productsEnquired);

           

        } catch (SQLException e) {
            response.sendError(510,e.getMessage());
            //e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	response.sendError(511,e.getMessage());
			e.printStackTrace();
		}

        

    }

    public void sendEmail(String quickquote_size, String salutation, String first_name,
            String middle_name, String last_name, String email, String country_code,
            String phone_number, String country, String str_date2, String ipaddress,
            String company_name, String company_address, String comments,
            String destination_port, String productsEnquired) throws Exception {

        String header = ROOT + "images/email_header.jpg";
        String footer = ROOT + "images/email_footer.jpg";
        //String to = letterId; 

        String mailBodyHeader = setMailBodyHeader(salutation, first_name, last_name, header);
        String mailBodyDetail = setMailBodyDetail(salutation, first_name, last_name,
                email, country, country_code, phone_number, company_name,
                company_address, destination_port, comments, productsEnquired);
        String mailBodyFooter = setMailBodyFooter(footer);

        String adminMailBodyHeader = setAdminMailBodyHeader(header,salutation, first_name, last_name);
        String adminMailBodyFooter = setAdminMailBodyFooter(footer);

        String mailBody = mailBodyHeader + mailBodyDetail + mailBodyFooter;
        String adminMailBody = adminMailBodyHeader + mailBodyDetail + adminMailBodyFooter + mailBodyFooter;
        EmailController emailController = new EmailController();
        /*
         * Send email to user
         */
        emailController.sendEmailViaGmail(email, mailBody, "Full Enquiry");
        //sendEmailViaGmail(email, mailBody);
        
        /*
         * Send email to chemtrade
         */
        emailController.sendEmailViaGmail(emailController.getAdminEmail(), adminMailBody, "Full Enquiry – Chemtradeasia Portal");
        //sendAdminEmail(adminMailBody);
    }
    
     

   

    private String setMailBodyFooter(String footer) throws SQLException {
        //EnquiryProductDAO edao = new EnquiryProductDAO();

        String mailBodyFooter = "<tr> \n"
                + "    <td colspan=\"3\">Cảm ơn bạn đã quan tâm đến Tradeasia International Pte. Ltd. Xin hãy click vào đường dẫn dưới đây để xác nhận.</td> \n"
                + "  </tr> \n"
                + "   <tr><td height=\"10\"></td></tr> \n"
                + " <tr><td colspan=\"3\" height=\"10\"><a href=\"" + ROOT + "confirmQuickQuote?qid=" + getLastQuoteID() + "\">Xin hãy click vào đường dẫn dưới đây để xác nhận.</a></td></tr> \n"
                + "   <tr><td height=\"10\"></td></tr>\n"
                + "  <tr><td colspan=\"4\">Thân,</td></tr><tr><td height=\"10\"></td></tr> \n"
                + "  <tr><td colspan=\"4\">Tradeasia</td></tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "    <tr> \n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td> \n"
                + "  </tr> \n"
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
    private String setMailBodyDetail(String salutation, String fname, String lname,
            String email, String country, String countryCode, String phone, String companyName,
            String companyAddress, String destinationPort, String comments, String productsEnquired) {

        String mailBodyDetail = "<tr> \n"
                + "    <th width=\"159\" scope=\"row\" align=\"left\">Tên</th> \n"
                + "    <td width=\"17\">:</td> \n"
                + "    <td width=\"302\">" + salutation + " " + fname + " " + lname + "</td> \n"
                + "  </tr> \n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Email </th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + email + "</td> \n"
                + "  </tr> \n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Quốc gia</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + country + "</td> \n"
                + "  </tr>\n"
                + "  <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Điện thoại</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + countryCode + " " + phone + "</td> \n"
                + "  </tr>\n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  " + productsEnquired + "\n"
                + "  <tr><td height=\"10\"></td></tr>\n"
                + "  \n"
                + "  <tr><th colspan=\"4\" bgcolor=\"#CCCCCC\">Thông tin công ty</th></tr>\n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Tên</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + companyName + "</td> \n"
                + "  </tr>\n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Địa chỉ</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + companyAddress + "</td> \n"
                + "  </tr>\n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Nơi chuyển hàng</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + destinationPort + "</td> \n"
                + "  </tr>\n"
                + "   \n"
                + "   <tr> \n"
                + "    <th scope=\"row\" align=\"left\">Ghi chú</th> \n"
                + "    <td>:</td> \n"
                + "    <td>" + comments + "</td> \n"
                + "  </tr>\n"
                + "   <tr><td height=\"10\"></td></tr>";

        return mailBodyDetail;
    }

    private String setMailBodyHeader(String salutation, String fname, String lname, String header) throws SQLException {

        String mailBodyHeader = "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\"> \n"
                + " <tr> \n"
                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td> \n"
                + "  </tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "  <tr> \n"
                + "    <td colspan=\"3\">Kính gửi " + salutation + " " + fname + " " + lname + ",</td> \n"
                + "  </tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "  <tr> \n"
                + "    <td colspan=\"3\">Tradeasia International Pte. Ltd! xin gửi lời chào tới Ngài/Bà.</td> \n"
                + "  </tr> \n"
                + "   <tr><td height=\"10\"></td></tr> \n"
                + "   <tr><th colspan=\"4\" bgcolor=\"#CCCCCC\">Thông tin của Ngài/Bà</th></tr>";
        return mailBodyHeader;
    }

   

    private String setAdminMailBodyFooter(String footer) {
        String adminMailBodyFooter = "<tr> \n"
                + "    <td colspan=\"3\"><b></b></td> \n"
                + "  </tr> \n"
                + "   <tr><td height=\"10\"></td></tr> \n"
                + "  <tr><td colspan=\"4\">Thân,</td></tr><tr><td height=\"10\"></td></tr> \n"
                + "  <tr><td colspan=\"4\">Tradeasia Team</td></tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "    <tr> \n"
                + "    <td colspan=\"3\"><img src=\"" + footer + "\"></td> \n"
                + "  </tr> \n"
                + "</table>";
        return adminMailBodyFooter;
    }

    private String setAdminMailBodyHeader(String header, String salutation, String first_name, String last_name) {
        String adminMailBodyHeader = "";
        adminMailBodyHeader += "<table width=\"870\" style=\"border:#666666 1px solid;\"  align=\"center\"> \n"
                + " <tr> \n"
                + "    <td colspan=\"3\"><img src=\"" + header + "\"></td> \n"
                + "  </tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "  <tr> \n"
                + "    <td colspan=\"3\">Hi,</td> \n"
                + "  </tr> \n"
                + "  <tr><td height=\"10\"></td></tr> \n"
                + "  <tr> \n"
                + "    <td colspan=\"3\">You have a new enquiry.</td> \n"
                + "  </tr> \n"
                + "<tr><td height=\"10\"></td></tr> \n"
                + "  <tr> \n"
                + "    <td colspan=\"3\">From: "+salutation + " " + first_name + " " + last_name + "</td> \n"
                + "  </tr> \n"
                + "   <tr><td height=\"10\"></td></tr> \n"
                + "   <tr><th colspan=\"4\" bgcolor=\"#CCCCCC\">Your Details</th></tr>";
        return adminMailBodyHeader;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	 //CountryDAO cdao = new CountryDAO();
         //cdao.databaseRetrieval();
    	//CountryCodeController countryCodeController = new CountryCodeController();
         //ArrayList<CountryCode> clist = countryCodeController.getCountryCodes();

         //ProductDAO pdao = new ProductDAO();
         //pdao.databaseRetrieval();
         ProductController productController = new ProductController();
         ArrayList<Product> products = productController.getProductListFromDB(0);
         String verificationCode = "";
         for (int i = 0; i < 6; i++) {
             String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
             verificationCode += rand;
         }
         req.setAttribute("vCode", verificationCode);
         req.setAttribute("products", products);
         req.getRequestDispatcher("jsp/product/send-enquiry.jsp").forward(req, resp);
    	//super.doGet(req, resp);
    }
    
    
    public EnquiryProduct getProduct(int quickquote_id, String product_name, String qnty) {
        EnquiryProduct p = new EnquiryProduct(quickquote_id, product_name, qnty);
        return p;
    }

   
/**
 * Get the list of Enquiry from tbl_quick_quote_prdtinfo
 * @return
 * @throws SQLException
 */
    public ArrayList<EnquiryProduct> getEnquiryProducts() throws SQLException {
        ArrayList<EnquiryProduct> enquiryProducts = new ArrayList<>();
        Connection conn = null;
        
            conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from tbl_quickquote_prdtinfo order by quickquote_id;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                enquiryProducts.add(getProduct(rs.getInt("quickquote_id"), rs.getString("Product_name"), rs.getString("qnty")));
                //quickquote_id from tbl_quickquote_prdtinfo is the same as quote_id from tbl_quickquote
            }
        return enquiryProducts;
    }

    public int getLastQuoteID() throws SQLException {
        int last = 0;
        Connection conn = null;
        
            conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select quote_id from tbl_quickquote order by quote_id desc LIMIT 1;");
            ResultSet rs = stmt.executeQuery();
            rs.next(); //select first one
            last = rs.getInt("quote_id");

         
        return last;
    }
    
    /**
     * Confirm enquiry after user click to the link
     * @param id
     * @return
     * @throws SQLException
     */
    public int actionConfirmQuote(String id) throws SQLException {
    	Connection conn = null;
       

            conn = ConnectionManager.getConnection();
            String sql = "select count(*) as cnt from tbl_quickquote where `quote_id`='" + id + "' AND `approved_status`='0'";
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            //System.out.println (rs.getString(1));
            if (rs.getString(1).compareTo("0") == 0) {
                throw new SQLException();
            } else {
                String sql2 = "UPDATE tbl_quickquote SET `approved_status` = 1 where `quote_id` = '" + id + "';";           
                stmt = conn.prepareStatement(sql2);
                stmt.execute();
            }
        

        return 0;

    }

    /**
     * Insert quickquote to database with the contact information
     * @param quickquote_size
     * @param salutation
     * @param first_name
     * @param middle_name
     * @param last_name
     * @param email
     * @param country_code
     * @param phone_number
     * @param country
     * @param str_date2
     * @param ipaddress
     * @param company_name
     * @param company_address
     * @param comments
     * @param destination_port
     * @return
     * @throws SQLException 
     * @throws Exception
     */
    public void insertQuickquote(String quickquote_size, String salutation, String first_name, String middle_name, String last_name, String email, String country_code, String phone_number, String country, String str_date2, String ipaddress, String company_name, String company_address, String comments, String destination_port) throws SQLException {
    	Connection conn = null;

        int success = 0;

        
            conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_quickquote "
                    + "(enq_code, salutation, first_name, middle_name, last_name, email_id, country_code, phone_no, country, approved_status, created_on, ip_address, company_name, company_addr, comment, dest_port) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            stmt.setString(1, "Quote-" + quickquote_size);
            stmt.setString(2, salutation);
            stmt.setString(3, first_name);
            stmt.setString(4, middle_name);
            stmt.setString(5, last_name);
            stmt.setString(6, email);
            stmt.setString(7, country_code);
            stmt.setString(8, phone_number);
            stmt.setString(9, country);
            stmt.setInt(10, 0);//what is this
            stmt.setString(11, str_date2);
            stmt.setString(12, ipaddress);
            stmt.setString(13, company_name);
            stmt.setString(14, company_address);
            stmt.setString(15, comments);
            stmt.setString(16, destination_port);

            stmt.execute();

       
    }
    
   /**
    * NOTE : add column 'measurement' in 'tbl_quickquote_prdtinfo'
    */
/**
 *
 * Insert QuickQuote with product info
 * @param productName
 * @param quantity
 * @param measurement
 * @return
 * @throws SQLException 
 * @throws Exception
 */
    public void intsertQuickquoteProductInfo(String productName, String quantity, String measurement) throws SQLException  {

        int success = 0;
        int lastid = getLastQuoteID() + 1;
        //Connection conn = null;
        
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO `tbl_quickquote_prdtinfo` (`quickquote_id`, `Product_name`, `qnty`, `measurement`) VALUES (?, ?, ?, ?);");
            stmt.setString(1, Integer.toString(lastid));
            stmt.setString(2, productName);
            stmt.setString(3, quantity);
            stmt.setString(4, measurement);
            stmt.execute();
    }
    
    /**
     * Get the size of the tbl_quick_quote
     * @return
     * @throws SQLException 
     */
    public int getQuickQuoteSize() throws SQLException{
    	Connection conn = null;
        
        conn = ConnectionManager.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select count(*) from tbl_quickquote_prdtinfo order by quickquote_id;");
        ResultSet rs = stmt.executeQuery();
        rs.next(); 
            return rs.getInt(1);
            //quickquote_id from tbl_quickquote_prdtinfo is the same as quote_id from tbl_quickquote
        
    }
}
