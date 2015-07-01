/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

import java.sql.Timestamp;

/**
 *
 * @author Qianpin
 */
public class Category {

    private int id;
    private String name;
    private Timestamp date;
    private String status, parentsId;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the parentsId
	 */
	public String getParentsId() {
		return parentsId;
	}
	/**
	 * @param parentsId the parentsId to set
	 */
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}
	
    
}
