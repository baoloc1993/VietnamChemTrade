/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Order {

    private String deliveryCountry, deliveryTerm, deliveryDate, port;
    private String paymentTerm, companyName, address, city, callCode, areaCode, companyWeb;
    private String companyType, companyCountry, companyState, companyZip, companyPhone;
    private String companyFax, contactSalution, contactFName, contactCallCode, contactMobile;
    private String contactMessengerType, contactMName, contactLName, contactEmail, contactMessengerID;
    private String comments, verifyCode, ipaddress, timestamp, destinationCountry;
    private int enq_code, approve_sts;
    private ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();

    public int getEnq_code() {
        return enq_code;
    }

    public int getApprove_sts() {
        return approve_sts;
    }
    
//    public Order(int enq_code,String company_name, String company_type, String contact_person_name, String middle_name,
//            String last_name, String country_code_mob, String mobile_no, String email_id, String messenger_type,
//            String messenger_id, String country_code, String area_code, String phone, String fax, String address,
//            String country, String state, String city, String zip, String website, String delivery_term,
//            String payment_term, String destination_port, String destination_country, String target_del_date,
//            String comments, int approve_sts, String ip_address, String created_on) {
//
//        this.approve_sts = approve_sts;
//        this.enq_code = enq_code;
//        this.companyName = company_name;
//        this.companyType = company_type;
//        this.contactFName = contact_person_name;
//        this.contactMName = middle_name;
//        this.contactLName = last_name;
//        this.contactCallCode = country_code_mob;
//        this.contactMobile = mobile_no;
//        this.contactEmail = email_id;
//        this.contactMessengerType = messenger_type;
//        this.contactMessengerID = messenger_id;
//        this.callCode = country_code;
//        this.areaCode = area_code;
//        this.companyPhone = phone;
//        this.companyFax = fax;
//        this.address = address;
//        this.companyCountry = country;
//        this.companyState = state;
//        this.city = city;
//        this.companyZip = zip;
//        this.companyWeb = website;
//        this.deliveryTerm = delivery_term;
//        this.paymentTerm = payment_term;
//        this.port = destination_port;
//        this.destinationCountry = destination_country;
//        this.deliveryDate = target_del_date;
//        this.comments = comments;
//        this.ipaddress = ip_address;
//        this.timestamp = created_on;
//        
//        orderList = new ArrayList<OrderDetail>();
//        
//    }
   
    public void addProductToCart(OrderDetail od) {
        orderList.add(od);
    }

	/**
	 * @return the deliveryCountry
	 */
	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	/**
	 * @param deliveryCountry the deliveryCountry to set
	 */
	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	/**
	 * @return the deliveryTerm
	 */
	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	/**
	 * @param deliveryTerm the deliveryTerm to set
	 */
	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the paymentTerm
	 */
	public String getPaymentTerm() {
		return paymentTerm;
	}

	/**
	 * @param paymentTerm the paymentTerm to set
	 */
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the companyWeb
	 */
	public String getCompanyWeb() {
		return companyWeb;
	}

	/**
	 * @param companyWeb the companyWeb to set
	 */
	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the callCode
	 */
	public String getCallCode() {
		return callCode;
	}

	/**
	 * @param callCode the callCode to set
	 */
	public void setCallCode(String callCode) {
		this.callCode = callCode;
	}

	/**
	 * @return the companyType
	 */
	public String getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	/**
	 * @return the companyZip
	 */
	public String getCompanyZip() {
		return companyZip;
	}

	/**
	 * @param companyZip the companyZip to set
	 */
	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}

	/**
	 * @return the companyState
	 */
	public String getCompanyState() {
		return companyState;
	}

	/**
	 * @param companyState the companyState to set
	 */
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	/**
	 * @return the companyPhone
	 */
	public String getCompanyPhone() {
		return companyPhone;
	}

	/**
	 * @param companyPhone the companyPhone to set
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	/**
	 * @return the companyCountry
	 */
	public String getCompanyCountry() {
		return companyCountry;
	}

	/**
	 * @param companyCountry the companyCountry to set
	 */
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	/**
	 * @return the companyFax
	 */
	public String getCompanyFax() {
		return companyFax;
	}

	/**
	 * @param companyFax the companyFax to set
	 */
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	/**
	 * @return the contactFName
	 */
	public String getContactFName() {
		return contactFName;
	}

	/**
	 * @param contactFName the contactFName to set
	 */
	public void setContactFName(String contactFName) {
		this.contactFName = contactFName;
	}

	/**
	 * @return the contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * @param contactMobile the contactMobile to set
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	/**
	 * @return the contactCallCode
	 */
	public String getContactCallCode() {
		return contactCallCode;
	}

	/**
	 * @param contactCallCode the contactCallCode to set
	 */
	public void setContactCallCode(String contactCallCode) {
		this.contactCallCode = contactCallCode;
	}

	/**
	 * @return the contactSalution
	 */
	public String getContactSalution() {
		return contactSalution;
	}

	/**
	 * @param contactSalution the contactSalution to set
	 */
	public void setContactSalution(String contactSalution) {
		this.contactSalution = contactSalution;
	}

	/**
	 * @return the contactMessengerID
	 */
	public String getContactMessengerID() {
		return contactMessengerID;
	}

	/**
	 * @param contactMessengerID the contactMessengerID to set
	 */
	public void setContactMessengerID(String contactMessengerID) {
		this.contactMessengerID = contactMessengerID;
	}

	/**
	 * @return the contactMessengerType
	 */
	public String getContactMessengerType() {
		return contactMessengerType;
	}

	/**
	 * @param contactMessengerType the contactMessengerType to set
	 */
	public void setContactMessengerType(String contactMessengerType) {
		this.contactMessengerType = contactMessengerType;
	}

	/**
	 * @return the contactLName
	 */
	public String getContactLName() {
		return contactLName;
	}

	/**
	 * @param contactLName the contactLName to set
	 */
	public void setContactLName(String contactLName) {
		this.contactLName = contactLName;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactMName
	 */
	public String getContactMName() {
		return contactMName;
	}

	/**
	 * @param contactMName the contactMName to set
	 */
	public void setContactMName(String contactMName) {
		this.contactMName = contactMName;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the destinationCountry
	 */
	public String getDestinationCountry() {
		return destinationCountry;
	}

	/**
	 * @param destinationCountry the destinationCountry to set
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	/**
	 * @return the ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}

	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	/**
	 * @return the verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}

	/**
	 * @param verifyCode the verifyCode to set
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	public ArrayList<OrderDetail> getOrderList() {
		// TODO Auto-generated method stub
		return orderList;
	}

    public void setOrderList(ArrayList<OrderDetail> orderList) {
		this.orderList = orderList;
	}
    public void setApprove_sts(int approve_sts) {
		this.approve_sts = approve_sts;
	}
    
    public void setEnq_code(int enq_code) {
		this.enq_code = enq_code;
	}

}
