/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import entity.Order;
import entity.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    ArrayList<String> deliveryTermList = new ArrayList<String>();
    ArrayList<String> paymentTermList = new ArrayList<String>();
    ArrayList<String> companyList = new ArrayList<String>();

    public ArrayList<String> getDeliveryTerms() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tbl_delivery_terms");
            rs = ps.executeQuery();

            while (rs.next()) {

                deliveryTermList.add(rs.getString("delivery_term"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return deliveryTermList;

    }

    public ArrayList<String> getCompanyTypes() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tbl_companytype");
            rs = ps.executeQuery();

            while (rs.next()) {

                companyList.add(rs.getString("company_type"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return companyList;

    }

    public ArrayList<String> getPaymentTerms() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tbl_payment_terms");
            rs = ps.executeQuery();

            while (rs.next()) {

                paymentTermList.add(rs.getString("payment_term"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return paymentTermList;

    }

    public int processOrder(Order order) throws Exception {
//String company_name, String company_type, String contact_person_name, String middle_name, String last_name, String country_code_mob, String mobile_no, String email_id, String messenger_type, String messenger_id, String country_code, String area_code, String phone, String fax, String address, String country, String state, String city, String zip, String website, String delivery_term, String payment_term, String destination_port, String destination_country, String target_del_date, String comments, String ip_address, String created_on

        int row = 0;
        int orderID = getLastOrderID() + 1;

        int enq_code = order.getEnq_code();
        String company_name = order.getCompanyName();
        String company_type = order.getCompanyType();
        String contact_person_name = order.getContactFName();
        String middle_name = order.getContactMName();
        String last_name = order.getContactLName();
        String country_code_mob = order.getContactCallCode();
        String mobile_no = order.getContactMobile();
        String email_id = order.getContactEmail();
        String messenger_type = order.getContactMessengerType();
        String messenger_id = order.getContactMessengerID();
        String country_code = order.getContactCallCode();
        String area_code = order.getAreaCode();
        String phone = order.getCompanyPhone();
        String fax = order.getCompanyFax();
        String address = order.getAddress();
        String country = order.getCompanyCountry();
        String state = order.getCompanyState();
        String city = order.getCompanyState();
        String zip = order.getCompanyZip();
        String website = order.getCompanyWeb();
        String delivery_term = order.getDeliveryTerm();
        String payment_term = order.getPaymentTerm();
        String destination_port = order.getPort();
        String destination_country = order.getDeliveryCountry();
        String target_del_date = order.getDeliveryDate();
        String comments = order.getComments();
        int approve_sts = 0;
        String ip_address = order.getIpaddress();
        String created_on = order.getTimestamp();

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("INSERT INTO tbl_order(order_id,enq_code, company_name,"
                    + "company_type, contact_person_name,middle_name, last_name, country_code_mob, mobile_no, email_id,"
                    + "messenger_type, messenger_id, country_code,area_code, phone, fax, address, country, state, city,"
                    + "zip, website, delivery_term, payment_term,destination_port, destination_country, target_del_date,"
                    + "comments, approve_sts, created_on, ip_address) "
                    + "VALUES(" + orderID + ",'" + enq_code + "','" + company_name + "','" + company_type + "','" + contact_person_name + "','"
                    + middle_name + "','" + last_name + "','" + country_code_mob + "','" + mobile_no + "','" + email_id + "','"
                    + messenger_type + "','" + messenger_id + "','" + country_code + "','" + area_code + "','" + phone + "','"
                    + fax + "','" + address + "','" + country + "','" + state + "','" + city + "','" + zip + "','" + website + "','"
                    + delivery_term + "','" + payment_term + "','" + destination_port + "','" + destination_country + "','"
                    + target_del_date + "','" + comments + "'," + approve_sts + ",'" + created_on + "','" + ip_address + "')");

            row = ps.executeUpdate();
            if (row < 1) {
                return 0;
            } else {
                row = insertOrderDetails(order, orderID);
                if (row < 1) {
                    return 0;
                }
            }
         } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        return 1;
    }
    
    public int insertOrderDetails(Order order, int orderID) {

        ArrayList<OrderDetails> orderList = order.getOrderList();
        int row = 1;


        for (OrderDetails o : orderList) {
            try {

                conn = ConnectionManager.getConnection();
                ps = conn.prepareStatement("INSERT INTO tbl_order_details (order_id ,  quantity ,  unit ,  expc_price ,  product_id ,  product_name ) VALUES ('" + orderID + "','" + o.getQuantity() + "','" + o.getUnit() + "','" + o.getPrice() + "','" + o.getP().getProduct_id() + "','" + o.getP().getProduct_name() + "')");
                row = ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, ps, rs);
            }
        }

        return row;
    }

   

    public int getLastOrderID() {

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("SELECT MAX(order_id) as max FROM tbl_order");
            rs = ps.executeQuery();

            while (rs.next()) {

                return rs.getInt("max");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, ps, rs);
        }

        //if no return result from rs.next(), return 0 as new ID
        return 0;

    }

}
