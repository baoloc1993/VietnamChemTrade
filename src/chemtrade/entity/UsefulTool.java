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
public class UsefulTool {
    
    private int id;
    private String name, code;
    private String link;
    private String shortname;
    
    public UsefulTool(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public void setCode(String code) {
		this.code = code;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShortname() {
		if (name.length() > 20){
			return name.substring(0,20)+ "...";
		}
			return name;
		
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}   
    
    
}
