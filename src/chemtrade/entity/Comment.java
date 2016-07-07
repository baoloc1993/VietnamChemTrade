/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

/**
 *
 * @author Fla
 */
public class Comment {
   private int id;
    private String  fname, lname, email, website,comment,datetime;
   private int reply_id,blog_id,status;
public int getBlog_id() {
	return blog_id;
}
public void setBlog_id(int blog_id) {
	this.blog_id = blog_id;
}
public int getReply_id() {
	return reply_id;
}
public void setReply_id(int reply_id) {
	this.reply_id = reply_id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getDatetime() {
	return datetime;
}
public void setDatetime(String datetime) {
	this.datetime = datetime;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
