package chemtrade.configuration;

public interface Constant {
	
	
	/**
	 * 
	 */
	
	
	/**
	 * Constant for Sending Email
	 */
	String HOST = "smtp.gmail.com";
    String PORT = "465";
    String USER = "no-reply@chemtradeasia.com";
    String PASS = "Ch3mTr4d3as14";
    
    
    /**
     * Constant for connect DATABASE
     */
    String DRIVER_NAME ="com.mysql.jdbc.Driver";
//  String URL = "jdbc:mysql://localhost/tradeus_vietnam";
//  String USERNAME = "prodchem_chemlib";
//  String PASSWORD = "prodchem_chemlib";

//   String URL = "jdbc:mysql://localhost/tradeasia";
//   String USERNAME = "root";
//   String PASSWORD = "ngolebaoloc";
   
   
   String URL = "jdbc:mysql://localhost/tradeus_vietnam";
   String USERNAME = "root";
   String PASSWORD = "ngolebaoloc";
//   
   
   
   /**
    * 
    */
   String CAPTCHA_PRIVATE_KEY = "6LcodwgTAAAAAPVnzcwlz0t7ZJ99b-XC0NiBRw_q";
   String ROOT = "chemtradeasia.com";
   
   /**
    * BASE SQL
    */
   String PRODUCT_BASE_SQL = "SELECT p.description, p.application, p.product_id, p.product_name,p.specification,p.product_dir, p.msds, p.product_image, p.cas_number, p.chemical_formula, p.country_origin, c.country,a.phy_appear_name, pk.packaging_name "
		   				+ "FROM tbl_product p "
		   				+ "inner join tbl_countries c on p.country_origin = c.ccode "
		   				+ "inner join tbl_phy_appear a on p.physical_appear = a.phy_appear_id "
		   				+ "inner join tbl_packaging pk on p.packing_details = pk.id "
   						+ "where p.r_status ='A'";
   String PRODUCT_ID = "product_id";
   String PRODUCT_NAME = "product_name";
   String PRODUCT_DIR = "product_dir";
   String PRODUCT_PHY_APPEAR = "phy_appear_name";
   String PRODUCT_CAS_NUMBER = "cas_number";
   String PRODUCT_FORMULA = "chemical_formula";
   String PRODUCT_SEO_DESC = "seo_desc";
   String PRODUCT_IMAGE = "product_image";
   String PRODUCT_SPECIFICATION = "specification";
   String PRODUCT_MSDS = "msds";
   String PRODUCT_PACKAGE = "packaging_name";
   String PRODUCT_COUNTRY = "country";
   String PRODUCT_COUNTRY_CODE = "country_origin";
   String PRODUCT_DESC = "description";
   String PRODUCT_APPLICATION = "application";
   
   //String PRODUCT_FIELD_ID = "product_id";
   
   
   int NUMBER_ITEM_PER_PAGE = 10;
   
}
