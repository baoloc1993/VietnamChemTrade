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
public class VideoGallery {
    
    private int videoID;
    private String videoName;
    private String videoLink;
    private String videoThumbnail;
    private String videoPath;
    
    public VideoGallery (int videoID, String videoName, String videoLink, String videoPath) {
        this.videoID = videoID;
        this.videoName = videoName;
        this.videoLink = videoLink;
        this.videoPath = videoPath;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoLink() {
    	String vdLink[] = videoLink.split("v=");
        String link = vdLink[1];
        return link;
    }

    public String getVideoPath() {
        return videoPath;
    }
    
    public int getVideoID() {
        return videoID;
    }

	public String getVideoThumbnail() {
		return "images/videogallery/" + getVideoPath();
	}

	public void setVideoThumnail(String videoThumnail) {
		this.videoThumbnail = videoThumnail;
	}

}
