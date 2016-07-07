/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.homepage;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipOutputStream;












import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.EmailController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.DownloadWrapper;
import chemtrade.entity.Product;

/**
 * Servlet implementation class ServletDownload
 */
@WebServlet("/downloadCenter")
public class DownloadCenterController extends HttpServlet implements Constant{

    private static final long serialVersionUID = -8694640030455344419L;
    //private String FilePath;
    private int length = 0;
    private String paging;
    private ArrayList<DownloadWrapper> downloadWrappers = new ArrayList<DownloadWrapper>();
    private static final int PAGE_SIZE = 20;
    private static final int BUFFER = 2048;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	try{
	    	String seoKeyWord = request.getParameter("pr_name");
	    	
	    	String showPage = request.getParameter("showPage");
	        configDownloadWrapper(seoKeyWord, showPage);
	        
    	}catch (Exception e) {
	        request.getRequestDispatcher("index").forward(request, resp);

			// TODO: handle exception
		}finally{
			//request.getSession().getServletContext().getRealPath("/");

	        request.setAttribute("downloads", downloadWrappers);
	        request.setAttribute("paging", paging);
	        request.getRequestDispatcher("jsp/downloadCenter.jsp").forward(request, resp);
    	}
	        
    	
    }



	/**
	 * 
	 * Control information to transfer back to JSP file
	 * @param showPage Page want to display i.e: 1, 2, 3
	 * 
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
	 */
	public void configDownloadWrapper(String seoKeyWord, String showPage) throws SQLException, UnsupportedEncodingException {
		int pageCount;
        int sPage;
    	try{
    		sPage = Integer.parseInt(showPage);
    		
    		if (sPage < 1){
    			sPage = 1;
    		}
    	}catch (NumberFormatException e){
    		sPage = 1;
    	}
        if (seoKeyWord == null) {
            seoKeyWord = "";
        } else {
            seoKeyWord = seoKeyWord.trim();
        }
        
        /*
         * List product which has seo-keyword containing given key_word
         */
        ArrayList<Product> products = getDownloadList(seoKeyWord);
        
        /*
         * Paging
         */
        int recordCount = products.size();
        pageCount = (recordCount % PAGE_SIZE == 0) ? (recordCount / PAGE_SIZE) : (recordCount / PAGE_SIZE + 1);
        
        if (sPage >= pageCount) {
            sPage = pageCount;
        }
        int position = Math.abs((sPage - 1) * PAGE_SIZE + 1);        
        
        /*
         * Get Product
         */
        
        for (int i = position - 1; i < position - 1 + PAGE_SIZE; i++) {
            DownloadWrapper downloadWrapper = new DownloadWrapper();
             Product product = products.get(i);
             downloadWrapper.setProduct(product);
            
            /*
             * Get name of country
             */
            //String country = countryCodeController.getCountryName(product.getCountryOrigin());
            //downloadWrapper.setCountry(country);
            
            /*
             * Set the background color
             * if 
             */
            String background = "";
            if (i % 2 == 0) {
                background = "background-color:#eeeeee;";
            }
            downloadWrapper.setBackground(background);
            downloadWrapper.setNumber(i);
            downloadWrapper.setLabel1("files_#" + String.valueOf(2*i+1)+ "#");
            downloadWrapper.setLabel1("check_#" + String.valueOf(2*i+2)+ "#");
            downloadWrappers.add(downloadWrapper);
            
        }
       // System.out.println ("SIZE = " + downloadWrappers.get(0).getCountry());
        
        paging = setPaging(sPage, pageCount, position, recordCount);
        //System.out.println ("SIZE = " + paging);
	}
    
    /**
     * Handle POST METHOD
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String tempFiles = request.getParameter("files");
    		String[] ids =  tempFiles.split(",");
    		String name = request.getParameter("name");
    		String email = request.getParameter("email");
    		//String phone = request.getParameter("phone");
    		//String requirement = request.getParameter("rec");
	        String FilePath = request.getSession().getServletContext().getRealPath("/");
	        //request.getLocalAddr();
	        ArrayList<String> files;
			
				files = getListFile(ids);
			
	        compressFile(response, FilePath,files);
    		sendInfoToDB(name, FilePath);
    		EmailController emailController = new EmailController();
    		emailController.sendEmailViaGmail(email, getMailBody(name), "Download Center");
    	} catch (SQLException e) {
    		response.sendError(511, e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			response.sendError(512, e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			response.sendError(513, e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    }
    /**
     * Get List of file by list of id
     * @return
     * @throws SQLException 
     */
    public ArrayList<String> getListFile(String [] ids) throws SQLException{
    	ArrayList<String> files = new ArrayList<String>();
    	Connection conn = ConnectionManager.getConnection();
    	String BASE_SQL = "SELECT p.specification,p.product_dir, p.msds "
   				+ "FROM tbl_product p "
   				+ "inner join tbl_countries c on p.country_origin = c.ccode "
   				+ "inner join tbl_phy_appear a on p.physical_appear = a.phy_appear_id "
   				+ "inner join tbl_packaging pk on p.packing_details = pk.id "
					+ "where p.r_status ='A'";
    	//String sql = PRODUCT_BASE_SQL;
    	System.out.println (ids.length);
    	for (int i = 0 ; i < ids.length; i++){
    		try{
    			String sql = BASE_SQL + " AND product_id = '" + ids[i].substring(1, ids[i].length())+"'";
    			System.out.println (sql);
    			PreparedStatement ps = conn.prepareStatement(sql);
    	    	ResultSet rs = ps.executeQuery();
    	    	rs.next();
    	    	if (ids[i].startsWith("B")){
    	    		files.add(rs.getString("product_dir") + "/" +  rs.getString("msds"));
    	    	}else{
    	    		files.add(rs.getString("product_dir") + "/" + rs.getString("specification"));
    	    	}
    		}catch(Exception e){
    	    	e.printStackTrace();
    	    }
    	} 
		return files;
    	
    	
    }



	/**
	 * 
	 * Compress files before download
	 * @param request
	 * @param response
	 * @param files
	 * @throws IOException
	 */
	
	public void compressFile( HttpServletResponse response ,String FilePath, ArrayList<String> files) throws IOException
			 {
		
		//String sourceFileDir = "C:/Users/luisngo/Desktop" + "/images/";
		String sourceFileDir = FilePath + "images/";
		String filePath = FilePath + "upload/";
		//String filePath = "C:/Users/luisngo/Desktop" + "/upload/";
			File[] newFiles = new File[40];
	        length = files.size();
	        /*
	         * Standardize the file path
	         */
	        for (int i = 0; i < length; i++) {
	            newFiles[i] = new File(sourceFileDir + files.get(i));
	        }
	        	
	        String tmpFileName = "Download"+new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())+".zip";
	        byte[] buffer = new byte[1024];
	       
	        String strZipPath = filePath + tmpFileName;
	        strZipPath = strZipPath.replace("\\", "");
	        //System.out.println (strZipPath);
	        BufferedInputStream origin = null;
	        System.out.println (strZipPath);
	        
	           // BufferedInputStream origin = null;	
	            File file = new File(strZipPath);
	            if (!file.exists()) {
					file.createNewFile();
				}
	            FileOutputStream dest = new FileOutputStream(file);
	            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
	            //out.setMethod(ZipOutputStream.DEFLATED);
	            byte data[] = new byte[BUFFER];
	            // get a list of files from current directory
//	            File f = new File(".");
//	            String files[] = f.list();

	            for (int i=0; i<length; i++) {
	               System.out.println("Adding: "+newFiles[i]);
	               FileInputStream fi = new FileInputStream(newFiles[i]);
	               origin = new BufferedInputStream(fi, BUFFER);
	               ZipEntry entry = new ZipEntry(files.get(i));
	               out.putNextEntry(entry);
	               int count;
	               while((count = origin.read(data, 0,  BUFFER)) != -1) {
	                  out.write(data, 0, count);
	               }
	               origin.close();
	            }
	            out.close();
	        
	        	   
	        	   
	        	   // create zip entry
	        	   // add entries to ZIP file
	       // }
//            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
//                    strZipPath));
//            for (int i = 0; i < length; i++) {
//                FileInputStream fis = new FileInputStream(file[i]);
//                out.putNextEntry(new ZipEntry(file[i].getName()));
//                out.setEncoding("UTF-8");
//                int len;
//                while ((len = fis.read(buffer)) > 0) {
//                    out.write(buffer, 0, len);
//                }
//                out.closeEntry();
//                fis.close();
//            }
            //out.close();
            //System.out.println(strZipPath);
           // this.downFile(response, tmpFileName);
	        PrintWriter writer = response.getWriter();
	        writer.write(ROOT + "upload/" +tmpFileName);
           // downFile(FilePath,response,tmpFileName);
	}

    /**
     * Send info of user to database
     * @param name
     * @param email
     * @param phone
     * @param rec
     * @throws SQLException 
     */
    public void sendInfoToDB(String name, String filePath) throws SQLException {
        Connection conn = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
        //Statement stat = null;
        //int id = 1;
//        try {
            conn = ConnectionManager.getConnection();            
        	//String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        	String sql ="INSERT INTO `tbl_download_center` ( `date`,`name`,`file_path`,`status`) VALUES "
                    + "('" + date + "','" + name + "','" + filePath + "','');";
        	//System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
//            stat.executeUpdate("INSERT INTO `tbl_download_center` (`download_id`, `name`, `file_path`, `status`, `date`, `e_name`, `e_email`, `e_phone`, `e_comments`) VALUES "
//                    + "(" + id + ", '', '', '', '" + str_date2 + "', '" + name + "', '" + email + "', '" + phone + "', '" + rec + "');");
        //}
    }

    /**
     * Download File
     * @param response
     * @param filrDir link of the file
     * @throws IOException 
     */
    public void downFile(String FilePath ,HttpServletResponse response, String filrDir) throws IOException {
        //try {
//            String path = FilePath + filrDir;
//            File file = new File(path);
//            if (file.exists()) {
//                InputStream ins = new FileInputStream(path);
//                BufferedInputStream bins = new BufferedInputStream(ins);
//                OutputStream outs = response.getOutputStream();
//                BufferedOutputStream bouts = new BufferedOutputStream(outs);
//                response.setContentType("application/x-download");
//                response.setHeader(
//                        "Content-disposition",
//                        "attachment;filename="
//                        + URLEncoder.encode(filrDir, "UTF-8"));
//                int bytesRead = 0;
//                byte[] buffer = new byte[8192];
//                 
//                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
//                    bouts.write(buffer, 0, bytesRead);
//                }
//                bouts.flush();
//                ins.close();
//                bins.close();
//                outs.close();
//                bouts.close();
//            } else {
//                response.sendRedirect("../error.jsp");
//            }
        //} catch (IOException e) {
          //  e.printStackTrace();
        //}
    }
    
   
    
    /**
     * Set the display of Paging in HTML Code
     * @param position 
     * @param recordCount 
     * @return
     */
    private String setPaging(int showPage, int pageCount, int position, int recordCount){
    	String paging = "";
    	paging += "<tr><td colspan=\"4\" ><div class=\"pagerClass\">";
        paging += "<ul id=\"yw1\" class=\"col-xd-12 col-md-12 pager centerRow\">";
    	if (showPage > 1) {
    		paging += "<li class=\"page\" style=\"border-radius:0;\"><a href=\"downloadCenter?showPage="+ String.valueOf(showPage - 1) + "\">< Previous</a></li>";
        }
        if (showPage > 3) {
        	paging += "<li class=\"page\" style=\"border:0\">...</li>";
        }
        for (int i = 1; i <= pageCount; i++) {
            if (showPage == i) {
            	paging += "<li class=\"page selected\" style=\"border-radius:0;\"><a href=\"downloadCenter?showPage=" + i +"\">" + i + "</a></li>";
            } else if (i < showPage + 3 && i > showPage - 3) {
        
            	paging += "<li class=\"page\" style=\"border-radius:0;\"><a href=\"downloadCenter?showPage=" + i + "\">" + i + "</a></li>";
            }
        }
      
        if (showPage < pageCount) {
        
        	paging += "<li class=\"page\" style=\"border:0\">...</li>";
        	paging += "<li class=\"page\" style=\"border-radius:0;\"><a href=\"downloadCenter?showPage=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
        
        }
        paging += "</ul></div></td></tr>";
        
        paging +="<tr><td colspan=\"5\"><span style=\"font-family:Oxygen-Bold, Arial, Helvetica, sans-serif; font-size:10px;padding-left:20px;padding-right:10px;margin-left: 70%\">";
        paging +="Showing " + position + " to " + String.valueOf(java.lang.Math.min(position + 19, recordCount)) + " of " + recordCount+ " products</span></td></tr>";
        paging += "<tr><td style=\"height:10px;\"></td></tr>";
        return paging;
    }
    
    
   
    
    private String getMailBody(String name){
    	String header="http://"+ ROOT + "/images/email_header.jpg";
        String footer="http://"+ ROOT +"/images/email_footer.jpg";
    	String message = "";
    	message +="<table width=\"870\" style=\"border:#666666 1px solid;\" align=\"center\">";
    	message += "<tr>";
    	message += "<td colspan=\"3\"><img src=\"" + header + "\"></td>";
    	message += "</tr>";
    	message += "<tr><td height=\"10\"></td></tr>";
    	message += "<tr>";
    	message += "<td colspan=\"3\">Chào bạn " + name + "\",</td>";
    	message += "</tr>";
    	message += "<tr><td height=\"10\"></td></tr>";
    	message += "<tr>";
    	message += "<td colspan=\"3\">Tradeasia International Pte. Ltd! xin gửi lời chào đến bạn.</td>";
    	message += "</tr>";
    	message += "<tr><td height=\"10\"></td></tr>";
    	message += "<tr>";
    	message += "<td colspan=\"3\">Cảm ơn bạn đã quan tâm đến sản phẩm của chúng tôi.</td>";
    	message += "</tr>";
    	message += "<tr><td height=\"10\"></td></tr>";    			    
    	message += "<tr><td height=\"10\"></td></tr>";
    	message += "<tr><td colspan=\"4\">Thân,</td></tr><tr><td height=\"10\"></td></tr>";
    	message += "<tr><td colspan=\"4\">Tradeasia</td></tr>";
    	message += "<tr><td height=\"10\"></td></tr>";    			   
    	message += "<tr>";
    	message += "<td colspan=\"3\"><img src=\"" +footer + "\"></td>";
    	message += "</tr>";    			  
    	message += "</table>";
    			 
    	return message;
    }
  
    /**
     * Get Product which contains given seo keyword
     * @param s : given seo keyword
     * @return
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
    public ArrayList<Product> getDownloadList(String seo) throws SQLException, UnsupportedEncodingException{
    	 ArrayList<Product> list = new ArrayList<>();
 	    Connection conn = null;
 	    PreparedStatement ps = null;
 	    ResultSet rs = null;
 	   conn = ConnectionManager.getConnection();
 	   String sql = PRODUCT_BASE_SQL;
 	    if (!seo.equals("")){    
            sql += " and `product_name` like '%" + seo + "%' or `iupac_name` like '%" + seo + "%' or `common_names` like '%" + seo + "%'";
    	}
  	   //System.out.println (sql);

         //System.out.println (sql);
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         while (rs.next()) {
        	 Product product = new Product();
        	 product.setProductId(rs.getInt(PRODUCT_ID));
         	product.setProductName(new String(rs.getBytes(PRODUCT_NAME), "UTF-8"));
         	product.setCountryOrigin(new String(rs.getBytes(PRODUCT_COUNTRY), "UTF-8"));
         	product.setPackingDetail(new String(rs.getBytes(PRODUCT_PACKAGE), "UTF-8"));
         	product.setPhysicalAppear(new String(rs.getBytes(PRODUCT_PHY_APPEAR), "UTF-8"));
         	product.setCasNumber(new String(rs.getBytes(PRODUCT_CAS_NUMBER), "UTF-8"));
         	product.setChemicalFormula(new String(rs.getBytes(PRODUCT_FORMULA), "UTF-8"));
         	product.setCountryCode(new String(rs.getBytes(PRODUCT_COUNTRY_CODE), "UTF-8"));
         	product.setDescription(rs.getBlob(PRODUCT_DESC));
            	product.setApplication(new String(rs.getBytes(PRODUCT_APPLICATION), "UTF-8"));
            	product.setProductDir(new String(rs.getBytes(PRODUCT_DIR), "UTF-8"));
            	product.setThumbImage(new String(rs.getBytes(PRODUCT_IMAGE), "UTF-8"));
        	list.add(product);
         }

         return list;
    
    }
}

