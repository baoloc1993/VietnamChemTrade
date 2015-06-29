package chemtrade.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import chemtrade.controller.event.EventController;
import chemtrade.dao.GalleryDAO;
import chemtrade.entity.PhotoGallery;
import chemtrade.entity.VideoGallery;

public class GalleryControllerTest extends TestCase {
	
	public void testGetDatabase(){
		EventController eventController = new EventController();
		
		//Test if request = null;
		 GalleryDAO gallery = new GalleryDAO();
		ArrayList<PhotoGallery> searchList = gallery.getPhotoResult("");
		assertEquals(4, searchList.size());
		
		ArrayList<VideoGallery> searchList2 = gallery.getVideoResult("acetic");
		assertEquals(0, searchList2.size());
		
		
		ArrayList<PhotoGallery> searchList3 = gallery.getPhotoResult("acetic");
		assertEquals(1, searchList3.size());
		assertEquals(19, searchList3.get(0).getGalleryID());
		
		assertEquals(0,"p".compareTo("p"));

	}
	

	
	
}
