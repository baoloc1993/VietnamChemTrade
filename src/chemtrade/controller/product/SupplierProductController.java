/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller.product;


import java.sql.*;
import java.util.*;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.SupplierProduct;


/**
 *
 * @author Fla
 */
public class SupplierProductController {


    public SupplierProduct getProduct(int sup_pdt_id, String supplier_id, String product_name, String sample_status, String price) {
        SupplierProduct p = new SupplierProduct();
        p.setSup_pdt_id(sup_pdt_id);
        p.setSupplier_id(supplier_id);
        p.setProduct_name(product_name);
        p.setSample_status(sample_status);
        p.setPrice(price);
        return p;
    }

    public ArrayList<SupplierProduct> getSupplierProductList() {
        ArrayList<SupplierProduct> list = new ArrayList<SupplierProduct>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_supplier_product order by sup_pdt_id;");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(getProduct(rs.getInt("sup_pdt_id"), rs.getString("supplier_id"), rs.getString("product_name"), rs.getString("sample_status"), rs.getString("price")));
            }
        } catch (Exception e) {
        } finally {
            ConnectionManager.close(conn, ps, rs);
    		return list;

        }
    }
    /**
     * Get supplier product Id in table tbl_supplier_product
     * @return
     * @throws SQLException 
     */
    public int getMaxId() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select max(sup_pdt_id) from tbl_supplier_product ");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        
    }
   
}
