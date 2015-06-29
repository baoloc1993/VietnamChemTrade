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
public class OrderDetail {
    
    
    private double price, quantity;
    private String unit;
    private Product p;
    

    public Product getP() {
        return p;
    }
    public OrderDetail (Product p, double price, String unit, double quantity) {
        
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.p = p;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
    public void setP(Product p) {
		this.p = p;
	}
    
    public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
    public void setUnit(String unit) {
		this.unit = unit;
	}
    
    public void setPrice(double price) {
		this.price = price;
	}
   
    
}
