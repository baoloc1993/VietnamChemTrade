package chemtrade.entity;

import java.sql.Blob;
import java.sql.Date;

public class Product {
	private int productId = 0;
	private String productName = "";
	private String productDir = "";
	//Default value 'Clear, Colorless Liquid'
	private String physicalAppear = "Clear, Colorless Liquid";
	private String seoKeyword = "";
	private String seoTitle = "";
	private String seoDesc = "";
	private String categoryId = "";
	private String iupacName = "";
	private String casNumber = "";
	private String hsCode = "";
	private String commonNames = "";
	private String thumbImage = "";
	private String chemicalFormula = "";
	private String productImage = "";
	private String application = "";
	private String specification = "";
	private String msds = "";
	private String packingDetail = "";
	private String countryOrigin = "";
	private String countryCode = "";
	private String grade = "";
	private String galleryId = "";
	private String facebookUrl = "";
	private String twitterUrl  = "";
	private String linkedinUrl = "";
	private String skypeId = "";
	private String msnId = "";
	private int clickCount =0;
	private String website = "";
	private String rDate = "";
	private char rStatus;
	private String insertedBy = "";
	private String updatedBy = "";
	private String updatedOn = "";
	private String prDescription = "";
	private String prApplication = "";
	
	
	private Blob description;
	
	
	/**
	 * Contructor
	 * @param product_id
	 * @param product_name
	 * @param product_dir
	 * @param physical_appear
	 * @param seo_keyword
	 * @param seo_title
	 * @param seo_desc
	 * @param category_id
	 * @param iupac_name
	 * @param cas_number
	 * @param hs_code
	 * @param common_names
	 * @param thumb_image
	 * @param chemical_formula
	 * @param product_image
	 * @param description
	 * @param application
	 * @param specification
	 * @param msds
	 * @param packing_details
	 * @param country_origin
	 * @param grade
	 * @param gallery_id
	 * @param facebook_url
	 * @param twitter_url
	 * @param linkedin_url
	 * @param skype_id
	 * @param msn_id
	 * @param click_count
	 * @param website
	 * @param r_date
	 * @param r_status
	 * @param inserted_by
	 * @param updated_on
	 * @param pr_description
	 * @param pr_application
	 * @return
	 */

	public Product() {
		
		// TODO Auto-generated constructor stub
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDir() {
		return productDir;
	}

	public void setProductDir(String productDir) {
		this.productDir = productDir;
	}

	public String getPhysicalAppear() {
		return physicalAppear;
	}

	public void setPhysicalAppear(String physicalAppear) {
		this.physicalAppear = physicalAppear;
	}

	public String getSeoKeyword() {
		return seoKeyword;
	}

	public void setSeoKeyword(String seoKeyword) {
		this.seoKeyword = seoKeyword;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoDesc() {
		return seoDesc;
	}

	public void setSeoDesc(String seoDesc) {
		this.seoDesc = seoDesc;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getIupacName() {
		return iupacName;
	}

	public void setIupacName(String iupacName) {
		this.iupacName = iupacName;
	}

	public String getCasNumber() {
		return casNumber;
	}

	public void setCasNumber(String casNumber) {
		this.casNumber = casNumber;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public String getCommonNames() {
		return commonNames;
	}

	public void setCommonNames(String commonNames) {
		this.commonNames = commonNames;
	}

	public String getThumbImage() {
		return thumbImage;
	}

	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}

	

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getMsds() {
		return msds;
	}

	public void setMsds(String msds) {
		this.msds = msds;
	}

	public String getPackingDetail() {
		return packingDetail;
	}

	public void setPackingDetail(String packingDetail) {
		this.packingDetail = packingDetail;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(String galleryId) {
		this.galleryId = galleryId;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getLinkedlinUrl() {
		return linkedinUrl;
	}

	public void setLinkedlinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String string) {
		this.skypeId = string;
	}

	public String getMsnId() {
		return msnId;
	}

	public void setMsnId(String msnId) {
		this.msnId = msnId;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public char getrStatus() {
		return rStatus;
	}

	public void setrStatus(char rStatus) {
		this.rStatus = rStatus;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getPrDescription() {
		return prDescription;
	}

	public void setPrDescription(String prDescription) {
		this.prDescription = prDescription;
	}

	public String getPrApplication() {
		return prApplication;
	}

	public void setPrApplication(String prApplication) {
		this.prApplication = prApplication;
	}

	public Blob getDescription() {
		return description;
	}

	public void setDescription(Blob description) {
		this.description = description;
	}

	public String getChemicalFormula() {
		return chemicalFormula;
	}

	public void setChemicalFormula(String chemicalFormula) {
		this.chemicalFormula = chemicalFormula;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
