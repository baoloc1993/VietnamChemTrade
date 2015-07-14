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
public class SupplierProduct {
    private int sup_pdt_id;
    private String supplier_id,product_name,sample_status,price;
	public int getSup_pdt_id() {
		return sup_pdt_id;
	}
	public void setSup_pdt_id(int sup_pdt_id) {
		this.sup_pdt_id = sup_pdt_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSample_status() {
		return sample_status;
	}
	public void setSample_status(String sample_status) {
		this.sample_status = sample_status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
