/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

/**
 *
 * @author ASUS
 */
public class Home {
    
    private int homeID;
    private String name, filepath, date;

    public Home(int homeID, String name, String filepath, String date) {
        this.homeID = homeID;
        this.name = name;
        this.filepath = filepath;
        this.date = date;
    }

    public int getHomeID() {
        return homeID;
    }

    public String getName() {
        return name;
    }

    public String getFilepath() {
        return filepath;
    }

    
    

    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
		this.date = date;
	}
    public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
    public void setHomeID(int homeID) {
		this.homeID = homeID;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    
}
