package chemtrade.controller.homepage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.configuration.ConnectionManager;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.UsefulToolsController;
import chemtrade.controller.blog.BlogController;
import chemtrade.controller.product.ProductController;
import chemtrade.entity.Blog;
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
		ArrayList<BlogWrapper> blogWrappers = new ArrayList<BlogWrapper>();
		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
		ArrayList<Website> otherWebsites = new OtherWebsiteController().getOtherWebsite();
		ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
		ArrayList<Product> topProducts = new ProductController().getTopProducts();
		//ArrayList<Product> topProducts = new ProductController().getProductListFromDB(1, 12);
		try{
			if (topProducts.size() >= 20){
				topProducts = new ArrayList<Product>( topProducts.subList(0, 5));
			}
			
			//ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
			if (latestEvents.size() >= 5){
				latestEvents = new ArrayList<Event>(latestEvents.subList(0, 5));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
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
		//String captcha = new CaptchaController().getCaptchaHTML();
		
		
		wrapperTopProducts = configWrapperProduct(topProducts);
		
		ArrayList<String> blogImages = new ArrayList<String>();
		ArrayList<String> blogLinks = new ArrayList<String>();
		ArrayList<String>blogNames = new ArrayList<String>();
		ArrayList<String>blogActive = new ArrayList<String>();
		try {
			
			
			blogWrappers = configBlogWrapper();
			for(BlogWrapper blogWrapper : blogWrappers){
				blogActive.add(blogWrapper.getActive());
				blogImages.add(blogWrapper.getImage());
				blogLinks.add(blogWrapper.getLink());
				blogNames.add(blogWrapper.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ArrayList<WrapperBanners> wrapperBanners = new ArrayList<WrapperBanners>();
//		
//			try {
//				wrapperBanners = getBanners();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		//ModelAndView model = new ModelAndView("index/index");
		
		
		//storeSearchWords(search, req.getRemoteAddr());
		
			String verificationCode = "";
	        for (int i = 0; i < 6; i++) {
	            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
	            verificationCode += rand;
	        }
	        req.setAttribute("vCode", verificationCode);
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
		ArrayList<String> test = new ArrayList<String>();
		
		//Set attribute for Blog
		//req.setAttribute("blogNames",blogNames);
		//req.setAttribute("blogLinks",blogLinks);
		//req.setAttribute("blogActive",blogActive);
		//req.setAttribute("blogImages",blogImages);
		
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req,resp);
	}


	private ArrayList<BlogWrapper> configBlogWrapper() throws SQLException {
		// TODO Auto-generated method stub
		BlogController blogController = new BlogController();
		ArrayList<BlogWrapper> blogWrappers = new ArrayList<HomePageController.BlogWrapper>();
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		blogs = blogController.getBlogList(1,5); 
		for (int i = 0 ;  i < blogs.size(); i++){
			BlogWrapper blogWrapper = new BlogWrapper();
			if (i== 0 ){
				blogWrapper.setActive("active");
			}
			Blog blog = blogs.get(i);
			blogWrapper.setImage(blog.getImage());
			blogWrapper.setLink(blog.getLink());
			blogWrapper.setName(blog.getTitle());
			blogWrappers.add(blogWrapper);
		}
		return blogWrappers;
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
		
		while (i< topProducts.size()){
			//System.out.println (i);
			
			WrapperProducts wrapperProduct = new WrapperProducts();
			ArrayList<Product> products = new ArrayList<Product>();
			System.out.println (i);
			if (i == 0){
				//The first slide is set active
				wrapperProduct.setActive("active");
			}
			for (int j = i; j < Math.min(i+TOP_PRODUCT_SIZE, topProducts.size()); j++){
				System.out.println ("j=" + j);
				products.add(topProducts.get(j));
				wrapperProduct.setProducts(products);
			}
			
			
			// The 1st item is active
			
			wrapperTopProducts.add(wrapperProduct);
			i = i+TOP_PRODUCT_SIZE;

		}
		

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
	
	
		
	
//	/**
//	 * Get List of Banner
//	 * @return
//	 * @throws SQLException 
//	 * @throws Exception
//	 */
//    @SuppressWarnings("finally")
//	public ArrayList<WrapperBanners> getBanners() throws SQLException  {
//        ArrayList<WrapperBanners> bannerList = new ArrayList<WrapperBanners>();
//    
//        String[] btnName = {"DOWNLOAD OUR FREE eBOOK", "SUBSCRIBE TO OUR BLOG", "GET FREE QUOTE", "VIEW OUR PRODUCTS", "DOWNLOAD OUR CASE STUDY"};
//        String[] btnLink = {"eBook.jsp", "blog.jsp", "quote.jsp", "product.jsp", "case-study.jsp"};
//        String[] btnColor = {"btn-danger", "btn-info", "btn-warning", "btn-success", "btn-primary"};
//        //int count = 0;
//        
//        //html code to display slide
//        //String slideMessage = "";
//        
//        int count = 0 ;
//    	Connection conn = null;
//        
//            conn = ConnectionManager.getConnection();
//            PreparedStatement ps = conn.prepareStatement("SELECT banner_id ,name ,file_path , date  FROM tbl_banner WHERE status like '%A'");
//            ResultSet rs  = ps.executeQuery();
//            
//            while (rs.next()) {
//                Home h = new Home(rs.getInt("banner_id"), rs.getString("name"), rs.getString("file_path"), rs.getString("date"));
//                WrapperBanners wrapperBanners = new WrapperBanners();
//                wrapperBanners.setBanner(h);
//                wrapperBanners.setBtnColor(btnColor[count]);
//                wrapperBanners.setBtnName(btnName[count]);
//                wrapperBanners.setBtnLink(btnLink[count]);
//                if (count == 0){
//                	wrapperBanners.setActive("active");
//                }
//                wrapperBanners.setIndex(count);
//                bannerList.add(wrapperBanners);
//                count++;
//            }
//            conn.close();
//        	return bannerList;
//        
//    }
    
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
	
	public class BlogWrapper{
		
		//private Blog blog;
		private String name, image, link;
		private String active = "";
		
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		
	}
	
	

	
}
