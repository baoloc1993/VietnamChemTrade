package chemtrade.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.dao.GalleryDAO;
import chemtrade.entity.PhotoGallery;
import chemtrade.entity.VideoGallery;

/**
 * Controll the content of galerry.jsp
 * @author ngolebaoloc
 *
 */

@WebServlet("/gallery")
public class GalleryController  extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GalleryDAO gallery = new GalleryDAO();
		String searchWord = "";
		String searchType = "p";
		try{
	        searchType = (String) request.getParameter("searchType");
	        searchWord = (String) request.getParameter("searchTB");
		}catch (Exception e){
			searchWord = "";
			searchType = "p";
		}
        ArrayList<PhotoGallery> photoResultList = new ArrayList<PhotoGallery>();
        ArrayList<VideoGallery> videoResultList = new ArrayList<VideoGallery>();
        String resultPhotoMessage = "";
        String resultVideoMessage = "";


        /*
         * if user search photo
         *  If searchType == null
         */
        if (searchType == null ||searchType.compareTo("p") == 0 ) {
            
            photoResultList =  gallery.getPhotoResult(searchWord);
            //resultPhotoMessage = String.valueOf(searchWord);
            videoResultList = gallery.getVideoResult("");
        } else {
        	videoResultList = gallery.getVideoResult(searchWord);
        	resultPhotoMessage = String.valueOf("");
            		//If user search video
        }

        if (photoResultList.size() == 0) resultPhotoMessage = " No Result ";
        if (videoResultList.size() == 0) resultVideoMessage = " No Result ";

        
        request.setAttribute("vMessage", resultVideoMessage);
        request.setAttribute("pMessage", resultPhotoMessage);
        request.setAttribute("searchWord", searchWord);
		
		request.setAttribute("vGallery", videoResultList);
		request.setAttribute("pGallery", photoResultList);
		request.getRequestDispatcher("jsp/gallery.jsp").forward(request, resp);
	}
}
