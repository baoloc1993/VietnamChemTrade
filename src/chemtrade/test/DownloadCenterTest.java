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
	
//	public void testConfigDownloadWrapper(){
//		DownloadCenterController downloadCenterController = new DownloadCenterController();
//		try {
//			downloadCenterController.configDownloadWrapper("", "1");
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//			
//		}
//		//assertEquals(true, false);
//	}
//	
//	
//	
//	public void testGetDownloadList(){
//		DownloadCenterController downloadCenterController = new DownloadCenterController();
//		try {
//			ArrayList<Product> downloadList = downloadCenterController.getDownloadList("");
//			assertEquals(1010,downloadList.size());
//			
//			ArrayList<Product> downloadList2 = downloadCenterController.getDownloadList("acid");
//			assertEquals(127,downloadList2.size());
//			// TODO Auto-generated catch block
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
//		
//	public void testGetListFile(){
//		DownloadCenterController downloadCenterController = new DownloadCenterController();
//		try {
//			String ids[] = new String[2];
//			ids[0] = "B287";
//			ids[1] = "A287";
//			ArrayList<String> files = downloadCenterController.getListFile(ids);
//			 //ArrayList<String> files = getListFile(ids);
////		        compressFile(response, FilePath,files);
////	    		sendInfoToDB(name, FilePath);
//			//assertEquals(1010,downloadList.size());
//			System.out.println (files.get(0));
//			
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}
		public void testCompressFile(){
			DownloadCenterController downloadCenterController = new DownloadCenterController();
			String FilePath = "D:/VietnamChemTradeVie/";
			String ids[] = new String[2];
			ids[0] = "B287";
			ids[1] = "A287";
			ArrayList<String> files;
			try {
				files = downloadCenterController.getListFile(ids);
				downloadCenterController.compressFile(FilePath, files);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//DownloadCenterController downloadCenterController = new DownloadCenterController();
			

		}
	
//	
//	public void testAddToDownloadCenter(){
//		DownloadCenterController downloadCenterController = new DownloadCenterController();
//		try {
//			downloadCenterController.sendInfoToDB("Loc", "baoloc1993@gmail.com");
//			// TODO Auto-generated catch block
//			assertEquals(true, true);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertEquals(true, false);
//		}
//	}

	
	//}
	
	
	
	

}
