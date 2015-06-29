package chemtrade.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import chemtrade.controller.homepage.DownloadCenterController;
import chemtrade.entity.Product;
import junit.framework.TestCase;

public class DownloadCenterTest extends TestCase{
	
	public void testConfigDownloadWrapper(){
		DownloadCenterController downloadCenterController = new DownloadCenterController();
		try {
			downloadCenterController.configDownloadWrapper("", "1");
			assertEquals(true, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, false);
			
		}
		//assertEquals(true, false);
	}
	
	public void testSendEmail(){
		DownloadCenterController downloadCenterController = new DownloadCenterController();
		try {
			downloadCenterController.sendEmail("baoloc1993@gmail.com", "LuisNgo");
			assertEquals(true, true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, false);
			
		}
	}
	
	public void testGetDownloadList(){
		DownloadCenterController downloadCenterController = new DownloadCenterController();
		try {
			ArrayList<Product> downloadList = downloadCenterController.getDownloadList("");
			assertEquals(1010,downloadList.size());
			
			ArrayList<Product> downloadList2 = downloadCenterController.getDownloadList("acid");
			assertEquals(127,downloadList2.size());
			// TODO Auto-generated catch block
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, false);
		}
	}
	
	
	public void testAddToDownloadCenter(){
		DownloadCenterController downloadCenterController = new DownloadCenterController();
		try {
			downloadCenterController.sendInfoToDB("Loc", "baoloc1993@gmail.com", "83745574", "Test");
			// TODO Auto-generated catch block
			assertEquals(true, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, false);
		}
	}

//	public void testCompressSize(){
//		DownloadCenterController downloadCenterController = new DownloadCenterController();
//		String file1 = "1280.jpg";
//		String file2 = "Logo-symbol-1024x446.png";
//		String[] files = (file1+ ","+ file2).split(",");
//		
//		String pathname = "/home/ngolebaoloc/Desktop/";
//		try {
//			downloadCenterController.compressFile(pathname,files);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//	}
	
	
	
	

}
