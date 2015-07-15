/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

/**
 *
 * @author Toshiba PC
 */
public class EnquiryProduct {
    private int quickquoteId;
    private String productName;
    private String quantity;
    
    public EnquiryProduct(int quickquote_id, String product_name, String qnty){
        this.quickquoteId = quickquote_id;
        this.productName = product_name;
        this.quantity = qnty;
    }

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuickquoteId() {
		return quickquoteId;
	}

	public void setQuickquoteId(int quickquoteId) {
		this.quickquoteId = quickquoteId;
	}
    
    
}
