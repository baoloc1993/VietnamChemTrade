/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.PhotoGallery;
import chemtrade.entity.VideoGallery;

/**
 *
 * @author ASUS
 */
public class GalleryDAO {

    PhotoGallery photo = null;
    ArrayList<Integer> galleryIDList = new ArrayList<>();
    ArrayList<PhotoGallery> imageList = new ArrayList<>();

    ArrayList<VideoGallery> vdThumbnailList = new ArrayList<>();
    VideoGallery video = null;

    
    

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<VideoGallery> getVideoResult(String search) {
    	
    	ArrayList<VideoGallery> searchVideoList = new ArrayList<>();
        try {
            conn = ConnectionManager.getConnection();

            ps = conn.prepareStatement("select distinct video_id, name, link, image_path from tbl_videogallery where name like '%" + search + "%' order by name");
            
            rs = ps.executeQuery();

            while (rs.next()) {

                int videoID = rs.getInt("video_id");
                String videoName = rs.getString("name");
                String videoLink = rs.getString("link");
                String videoPath = rs.getString("image_path");

                //to prevent duplicates
                video = new VideoGallery(videoID, videoName, videoLink, videoPath);

                searchVideoList.add(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchVideoList;

    }

    public ArrayList<PhotoGallery> getPhotoResult(String search) {
    	ArrayList<PhotoGallery> searchPhotoList = new ArrayList<>();

        try {
            conn = ConnectionManager.getConnection();

            ps = conn.prepareStatement("select distinct gallery_name, gal_image, galery_id from tbl_imggalleries where gallery_name like '%" + search + "%' order by gallery_name");
            rs = ps.executeQuery();

            while (rs.next()) {

                int galleryID = rs.getInt("galery_id");
                String galleryName = rs.getString("gallery_name");
                String galleryPath = rs.getString("gal_image");

                photo = new PhotoGallery(galleryID, galleryName, galleryPath);

                //to prevent duplicates
                searchPhotoList.add(photo);
                addTotalImage(photo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchPhotoList;

    }

    //done 
    public ArrayList<PhotoGallery> getImgThumbnailList() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_imggalleries order by gallery_name");
            rs = ps.executeQuery();

            while (rs.next()) {

                int galleryID = rs.getInt("galery_id");
                String galleryName = rs.getString("gallery_name");
                String galleryPath = rs.getString("gal_image");

                //to prevent duplicates
                if (galleryIDList.indexOf(galleryID) == -1) {
                    photo = new PhotoGallery(galleryID, galleryName, galleryPath);
                    imageList.add(photo);
                    addTotalImage(photo);
                    galleryIDList.add(galleryID);
                }
                //# is delimeter
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return imageList;
    }

    //done
    public ArrayList<VideoGallery> getVideos() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_videogallery order by name");
            rs = ps.executeQuery();

            while (rs.next()) {

                int videoID = rs.getInt("video_id");
                String videoName = rs.getString("name");
                String videoLink = rs.getString("link");
                String videoPath = rs.getString("image_path");

                video = new VideoGallery(videoID, videoName, videoLink, videoPath);

                if (vdThumbnailList.indexOf(video) == -1) {
                    vdThumbnailList.add(video);
                }
                //# is delimeter
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return vdThumbnailList;
    }

    public ArrayList<Integer> getImageIDList() {
        return galleryIDList;
    }

    //getting image list based on IDs retrieved above
    public void addTotalImage(PhotoGallery p) {

        int total = 0;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection conn2 = null;
        ArrayList<PhotoGallery> photoList = new ArrayList<PhotoGallery>();

        try {

            conn2 = ConnectionManager.getConnection();
            ps2 = conn2.prepareStatement("select image_name, image_id,image_path from tbl_imagelist where gallery_id =" + p.getGalleryID());
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String name = rs2.getString("image_name");
                int ID = Integer.parseInt(rs2.getString("image_id"));
                String Path = rs2.getString("image_path");

                PhotoGallery photo = new PhotoGallery(ID, name, Path);
                photoList.add(photo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	p.setPhotoList(photoList);
            ConnectionManager.close(conn2, ps2, rs2);
        }

    }

    public ArrayList<PhotoGallery> getImageList(int id) {

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection conn2 = null;
        ArrayList<PhotoGallery> imageList = new ArrayList<PhotoGallery>();

        try {

            conn2 = ConnectionManager.getConnection();
            ps2 = conn2.prepareStatement("select image_name, image_id,image_path from tbl_imagelist where gallery_id =" + id);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String name = rs2.getString("image_name");
                int ID = Integer.parseInt(rs2.getString("image_id"));
                String Path = rs2.getString("image_path");

                PhotoGallery photo = new PhotoGallery(ID, name, Path);
                imageList.add(photo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn2, ps2, rs2);
        }

        return imageList;

    }

    public String getImageName(int id) {

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection conn2 = null;
        ArrayList<PhotoGallery> imageList = new ArrayList<PhotoGallery>();
        String name = "";

        try {

            conn2 = ConnectionManager.getConnection();
            ps2 = conn2.prepareStatement("select gallery_name from tbl_imggalleries where galery_id =" + id);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                name = rs2.getString("gallery_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn2, ps2, rs2);
        }

        return name;

    }

}
