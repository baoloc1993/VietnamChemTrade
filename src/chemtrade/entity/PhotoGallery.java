/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class PhotoGallery {
    
    private int galleryID;
    private String galleryName;
    private String galleryPath;
    private int listSize;
    private ArrayList<PhotoGallery> photoList = null;
    
    public PhotoGallery (int galleryID, String galleryName, String galleryPath) {
        this.setGalleryID(galleryID);
        this.setGalleryName(galleryName);
        this.setGalleryPath(galleryPath);
        setPhotoList(new ArrayList<PhotoGallery>());
    }

	public int getGalleryID() {
		return galleryID;
	}

	public void setGalleryID(int galleryID) {
		this.galleryID = galleryID;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getGalleryPath() {
		return galleryPath;
	}

	public void setGalleryPath(String galleryPath) {
		this.galleryPath = galleryPath;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public ArrayList<PhotoGallery> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<PhotoGallery> photoList) {
		this.photoList = photoList;
	}
    
    

    
}
