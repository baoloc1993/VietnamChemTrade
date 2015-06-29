package chemtrade.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author ngolebaoloc
 * 
 * Class handle the create event form in jsp/event/addNewEvent.jsp
 *
 */
public class CreateEvent {
	
	private String title;
	private String description;
	private String link;
	private String img;
	private String date;
	private String location;
	private char status;
	private String createdOn;
	
	
	/*
	 * 1 is active in carousel
	 * 0 is inactive
	 */
	private int active = 0;
	private List<String> listCodes;
	private String areaCode;
	private String phone;
	private String email;
	private String salutation;
	private List<Salutation> salutationList = new ArrayList<Salutation>();
	private String firstName;
	private String lastName;
	private String middleName;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public List<?> getListCodes() {
		return listCodes;
	}
	public void setListCodes(List<String> listCodes) {
		this.listCodes = listCodes;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public List<Salutation> getSalutationList() {
		salutationList = new ArrayList<Salutation>();
		salutationList.add(new Salutation(0, "Select"));
		salutationList.add(new Salutation(1, "Mr"));
		salutationList.add( new Salutation(2,"Mrs"));
		salutationList.add(new Salutation(3, "Ms"));
		salutationList.add( new Salutation(4,"Dr"));
		salutationList.add( new Salutation(5,"Prof"));
		return salutationList;
	}
	public void setSalutationList(List<Salutation> salutationList) {
		this.salutationList = salutationList;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
}
