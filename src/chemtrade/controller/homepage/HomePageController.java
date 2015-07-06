package chemtrade.controller.homepage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.CaptchaController;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.UsefulToolsController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.Event;
import chemtrade.entity.Home;
import chemtrade.entity.Product;
import chemtrade.entity.SocialMedia;
import chemtrade.entity.UsefulTool;
import chemtrade.entity.Website;

/**
 * 
 * @author ngolebaoloc
 * Controll all data of homepage
 * use link : /index.htm
 *
 */

@WebServlet("/index")
public class HomePageController extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TOP_PRODUCT_SIZE = 4;

	/**
	 * Handle method GET from url index
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartMessage = "";
		//req.g
		ArrayList<WrapperProducts> wrapperTopProducts = new ArrayList<WrapperProducts>();
		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
		ArrayList<Website> otherWebsites = new OtherWebsiteController().getOtherWebsite();
		ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
		ArrayList<Product> topProducts = new ProductController().getTopProducts();
		//ArrayList<Product> topProducts = new ProductController().getProductListFromDB(1, 12);
		
		/*
		 * Use for search bar
		 */
		String searchComplete = "";
		ArrayList<Product> products =  new ProductController().getProductListFromDB();
		for (Product product : products){
			searchComplete += product.getProductName() + ",";
		}
		
		/*
		 * Control cart
		 */
		ArrayList<Product> cartList = getCart(req, cartMessage);
		String uri3 = req.getRequestURI();
	    String pageName3 = uri3.substring(uri3.lastIndexOf("/") + 1);
	    
	    /*
	     * Control Social Media
	     */
	    ArrayList<SocialMedia> mediaLinks = getSocialList();
		
		/*
		 * Get Useful Tool
		 */
		UsefulToolsController userfulToolsController = new UsefulToolsController();
		ArrayList<UsefulTool> widgets = userfulToolsController.getWidgets();
		ArrayList<UsefulTool> associationResources = userfulToolsController.getAssociationResource();
		
		
		/*
		 * Get Captcha 
		 */
		String captcha = new CaptchaController().getCaptchaHTML();
		
		
		wrapperTopProducts = configWrapperProduct(topProducts);
		ArrayList<WrapperBanners> wrapperBanners = new ArrayList<WrapperBanners>();
		
			try {
				wrapperBanners = getBanners();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//ModelAndView model = new ModelAndView("index/index");
		
		
		//storeSearchWords(search, req.getRemoteAddr());
		
		
		req.setAttribute("countryCodes", countryCodes);
		//req.setAttribute("searchComplete", searchComplete);

		req.setAttribute("otherWebsites", otherWebsites);
		req.setAttribute("latestEvents", latestEvents);
		req.setAttribute("wrapperTopProducts", wrapperTopProducts);
		req.setAttribute("widgets", widgets);
		req.setAttribute("assoRes", associationResources);
		//req.setAttribute("capcha", captcha);
		req.setAttribute("cartMessage", cartMessage);
		req.setAttribute("carts", cartList);
		//req.setAttribute("pageName3", pageName3);
		//req.setAttribute("wrapperBanners", wrapperBanners);
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req,resp);
	}


	/**
	 * Config topProduct part
	 * @param wrapperTopProducts
	 * @param topProducts
	 */
	public ArrayList<WrapperProducts> configWrapperProduct(ArrayList<Product> topProducts) {
		ArrayList<WrapperProducts> wrapperTopProducts = new ArrayList<WrapperProducts>();
		/**
		 * Config wrapperTopProduct
		 * Each item of wrapperTopProduct is the list of Product (i.e topProduct)
		 * topProduct is a list of 6 products
		 */
		int i = 0;
		
		while (true){
			WrapperProducts wrapperProduct = new WrapperProducts();
			ArrayList<Product> products = new ArrayList<Product>();
			if((i+TOP_PRODUCT_SIZE) > topProducts.size()){
				
				break;
			}
			for (int j = i; j < i+TOP_PRODUCT_SIZE; j++){
				products.add(topProducts.get(j));
			}
			wrapperProduct.setProducts(products);
			
			// The 1st item is active
			if (i == 0){
				wrapperProduct.setActive("active");
			}
			wrapperTopProducts.add(wrapperProduct);
			i = i+TOP_PRODUCT_SIZE;
			
			
		}
		
		ArrayList<Product> products2 = new ArrayList<Product>();
		for (int j = i; j < topProducts.size(); j++){
			products2.add(topProducts.get(j));
		}
		WrapperProducts wrapperProduct = new WrapperProducts();
		wrapperProduct.setProducts(products2);
		wrapperTopProducts.add(wrapperProduct);
		return wrapperTopProducts;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Product> getCart(HttpServletRequest request, String cartMessage){
		ArrayList<Product> cartList = new ArrayList<Product>();
	    HttpSession session = request.getSession();

	    if (session.getAttribute("cartList") == null) {
	        cartList = new ArrayList<Product>();
	    } else {
	        cartList = (ArrayList<Product>) session.getAttribute("cartList");
	    }
	    //ProductDAO productDAO = new ProductDAO();

	   // String cartMessage = "";

	    if (cartList != null && cartList.size() != 0) {
	        cartMessage = "<b>Product Details</b>";	           
            
	    }else{
	    	cartMessage = "EMPTY";
	    }
	    return cartList;
	}
	
	/**
	 * Get list of social media
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<SocialMedia> getSocialList() {
		ArrayList<SocialMedia> socialList = new ArrayList<SocialMedia>();
	    Connection conn = null;
	    
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_socialinfo where linkedin like '%A'order by socialinfo_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SocialMedia social = new SocialMedia(rs.getInt("socialinfo_id"), rs.getString("skype_account"),
                        rs.getString("facebook_account"), rs.getString("twitter_account"), rs.getString("email_account"),
                        rs.getString("linkedin"), rs.getString("youtube"));
                socialList.add(social);

            }
        } catch(Exception e){
        
        }finally{
        	return socialList;
        }
        
    }
	
	
		
	
	/**
	 * Get List of Banner
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
    @SuppressWarnings("finally")
	public ArrayList<WrapperBanners> getBanners() throws SQLException  {
        ArrayList<WrapperBanners> bannerList = new ArrayList<WrapperBanners>();
    
        String[] btnName = {"DOWNLOAD OUR FREE eBOOK", "SUBSCRIBE TO OUR BLOG", "GET FREE QUOTE", "VIEW OUR PRODUCTS", "DOWNLOAD OUR CASE STUDY"};
        String[] btnLink = {"eBook.jsp", "blog.jsp", "quote.jsp", "product.jsp", "case-study.jsp"};
        String[] btnColor = {"btn-danger", "btn-info", "btn-warning", "btn-success", "btn-primary"};
        //int count = 0;
        
        //html code to display slide
        //String slideMessage = "";
        
        int count = 0 ;
    	Connection conn = null;
        
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT banner_id ,name ,file_path , date  FROM tbl_banner WHERE status like '%A'");
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next()) {
                Home h = new Home(rs.getInt("banner_id"), rs.getString("name"), rs.getString("file_path"), rs.getString("date"));
                WrapperBanners wrapperBanners = new WrapperBanners();
                wrapperBanners.setBanner(h);
                wrapperBanners.setBtnColor(btnColor[count]);
                wrapperBanners.setBtnName(btnName[count]);
                wrapperBanners.setBtnLink(btnLink[count]);
                if (count == 0){
                	wrapperBanners.setActive("active");
                }
                wrapperBanners.setIndex(count);
                bannerList.add(wrapperBanners);
                count++;
            }
            conn.close();
        	return bannerList;
        
    }
    
	/**
	 * Each WrapperProducts object is analog to the carousel item
	 * @author ngolebaoloc
	 *
	 */
	public class WrapperProducts {
		private ArrayList<Product> products;
		
		/**
		 * 0 = not active
		 * 1 = active
		 */
		private String active = "";
		public ArrayList<Product> getProducts() {
			return products;
		}
		public void setProducts(ArrayList<Product> products) {
			this.products = products;
		}
		/**
		 * @return the active
		 */
		public String getActive() {
			return active;
		}
		/**
		 * @param active the active to set
		 */
		public void setActive(String active) {
			this.active = active;
		}
		
	}	
	
	/**
	 * Each WrapperProducts object is analog to the carousel item
	 * @author ngolebaoloc
	 *
	 */
	public class WrapperBanners{
		private Home banner;
		private String btnColor = "";
		private String btnLink = "";
		private String btnName = "";
		private int index;
		/**
		 * 0 = not active
		 * 1 = active
		 */
		private String active = "";
		
		
		/**
		 * @return the banner
		 */
		public Home getBanner() {
			return banner;
		}
		/**
		 * @param banner the banner to set
		 */
		public void setBanner(Home banner) {
			this.banner = banner;
		}
		/**
		 * @return the active
		 */
		public String getActive() {
			return active;
		}
		/**
		 * @param active the active to set
		 */
		public void setActive(String active) {
			this.active = active;
		}
		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}
		/**
		 * @param index the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
		}
		
		public void setBtnColor(String btnColor) {
			this.btnColor = btnColor;
		}
		
		public void setBtnLink(String btnLink) {
			this.btnLink = btnLink;
		}
		public void setBtnName(String btnName) {
			this.btnName = btnName;
		}
		
		public String getBtnColor() {
			return btnColor;
		}
		public String getBtnLink() {
			return btnLink;
		}
		
		public String getBtnName() {
			return btnName;
		}
		
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest req,
//			HttpServletResponse resp) throws Exception {
//		
//		String cartMessage = "";
//		
//		ArrayList<WrapperProducts> wrapperTopProducts = new ArrayList<WrapperProducts>();
//		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
//		ArrayList<Website> otherWebsites = new OtherWebsiteController().getOtherWebsite();
//		ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
//		ArrayList<Product> topProducts = new TopProductController().getTopProduct();
//		//ArrayList<Product> topProducts = new ProductController().getProductListFromDB(1, 12);
//		
//		/*
//		 * Use for search bar
//		 */
//		String searchComplete = "";
//		ArrayList<Product> products =  new ProductController().getProductListFromDB();
//		for (Product product : products){
//			searchComplete += product.getProductName() + ",";
//		}
//		
//		/*
//		 * Control cart
//		 */
//		ArrayList<Product> cartList = getCart(req, cartMessage);
//		String uri3 = req.getRequestURI();
//	    String pageName3 = uri3.substring(uri3.lastIndexOf("/") + 1);
//	    
//	    /*
//	     * Control Social Media
//	     */
//	    ArrayList<SocialMedia> mediaLinks = getSocialList();
//		
//		/*
//		 * Get Useful Tool
//		 */
//		UsefulToolsController userfulToolsController = new UsefulToolsController();
//		ArrayList<UsefulTool> widgets = userfulToolsController.getWidgets();
//		ArrayList<UsefulTool> associationResources = userfulToolsController.getAssociationResource();
//		
//		
//		/*
//		 * Get Captcha 
//		 */
//		String captcha = new CaptchaController().getCaptchaHTML();
//		
//		
//		configWrapperProduct(wrapperTopProducts, topProducts);
//		ArrayList<WrapperBanners> wrapperBanners = new ArrayList<WrapperBanners>();
//		
//			try {
//				wrapperBanners = getBanners();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		//ModelAndView model = new ModelAndView("index/index");
//		
//		
//		//storeSearchWords(search, req.getRemoteAddr());
//		
//		ModelAndView modelAndView = new ModelAndView("index/index");
//		
//		
//		modelAndView.addObject("countryCodes", countryCodes);
//		//modelAndView.addObject("searchComplete", searchComplete);
//
//		modelAndView.addObject("otherWebsites", otherWebsites);
//		modelAndView.addObject("latestEvents", latestEvents);
//		modelAndView.addObject("wrapperTopProducts", wrapperTopProducts);
//		modelAndView.addObject("widgets", widgets);
//		modelAndView.addObject("assoRes", associationResources);
//		modelAndView.addObject("capcha", captcha);
//		modelAndView.addObject("cartMessage", cartMessage);
//		modelAndView.addObject("carts", cartList);
//		//modelAndView.addObject("pageName3", pageName3);
//		//modelAndView.addObject("wrapperBanners", wrapperBanners);
////		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req,resp);
//		// TODO Auto-generated method stub
//		//if (arg0.getMethod().equals("GET")){
//			//doGet(arg0, arg1);
//		//}
//		return modelAndView;
//	}	
}
