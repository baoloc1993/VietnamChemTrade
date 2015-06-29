package chemtrade.controller.homepage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chemtrade.controller.CaptchaController;
import chemtrade.controller.CountryCodeController;
import chemtrade.controller.UsefulToolsController;
import chemtrade.entity.CountryCode;
import chemtrade.entity.Event;
import chemtrade.entity.Product;
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
	private static final int TOP_PRODUCT_SIZE = 6;

	/**
	 * Handle method GET from url index
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<WrapperProducts> wrapperTopProducts = new ArrayList<WrapperProducts>();
		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
		ArrayList<Website> otherWebsites = new OtherWebsiteController().getOtherWebsite();
		ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
		ArrayList<Product> topProducts = new TopProductController().getTopProduct();
		
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
		
		
		configWrapperProduct(wrapperTopProducts, topProducts);
		
		//ModelAndView model = new ModelAndView("index/index");
		
		req.setAttribute("countryCodes", countryCodes);
		req.setAttribute("otherWebsites", otherWebsites);
		req.setAttribute("latestEvents", latestEvents);
		req.setAttribute("wrapperTopProducts", wrapperTopProducts);
		req.setAttribute("widgets", widgets);
		req.setAttribute("assoRes", associationResources);
		req.setAttribute("capcha", captcha);
		
		req.getRequestDispatcher("/jsp/index/index.jsp").forward(req,resp);
	}
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest arg0,
//			HttpServletResponse arg1) throws Exception {
//		// TODO Auto-generated method stub
//		
//		// Each wrapper has 6 items. Each wrapper is analog to a cousrel item
//		ArrayList<WrapperProducts> wrapperTopProducts = new ArrayList<WrapperProducts>();
//		ArrayList<CountryCode> countryCodes = new CountryCodeController().getCountryCodes();
//		ArrayList<Website> otherWebsites = new OtherWebsiteController().getOtherWebsite();
//		ArrayList<Event> latestEvents = new LatestEventController().getLatestEvent();
//		ArrayList<Product> topProducts = new TopProductController().getTopProduct();
//		
//		/**
//		 * Config wrapperTopProduct
//		 * Each item of wrapperTopProduct is the list of Product (i.e topProduct)
//		 * topProduct is a list of 6 products
//		 */
//		int i = 0;
//		
//		while (true){
//			WrapperProducts wrapperProduct = new WrapperProducts();
//			ArrayList<Product> products = new ArrayList<Product>();
//			if((i+6) > topProducts.size()){
//				
//				break;
//			}
//			for (int j = i; j < i+6; j++){
//				products.add(topProducts.get(j));
//			}
//			wrapperProduct.setProducts(products);
//			
//			// The 1st item is active
//			if (i == 0){
//				wrapperProduct.setActive(1);
//			}
//			wrapperTopProducts.add(wrapperProduct);
//			i = i+6;
//			
//			
//		}
//		
//		ArrayList<Product> products2 = new ArrayList<Product>();
//		for (int j = i; j < topProducts.size(); j++){
//			products2.add(topProducts.get(j));
//		}
//		WrapperProducts wrapperProduct = new WrapperProducts();
//		wrapperProduct.setProducts(products2);
//		wrapperTopProducts.add(wrapperProduct);
//		
//		ModelAndView model = new ModelAndView("index/index");
//		model.addObject("countryCodes", countryCodes);
//		model.addObject("otherWebsites", otherWebsites);
//		model.addObject("latestEvents", latestEvents);
//		model.addObject("wrapperTopProducts", wrapperTopProducts);
//		
//		return model;
//	}

	private void configWrapperProduct(
			ArrayList<WrapperProducts> wrapperTopProducts,
			ArrayList<Product> topProducts) {
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
				wrapperProduct.setActive(1);
			}
			wrapperTopProducts.add(wrapperProduct);
			i = i+6;
			
			
		}
		
		ArrayList<Product> products2 = new ArrayList<Product>();
		for (int j = i; j < topProducts.size(); j++){
			products2.add(topProducts.get(j));
		}
		WrapperProducts wrapperProduct = new WrapperProducts();
		wrapperProduct.setProducts(products2);
		wrapperTopProducts.add(wrapperProduct);
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
		private int active = 0;
		public ArrayList<Product> getProducts() {
			return products;
		}
		public void setProducts(ArrayList<Product> products) {
			this.products = products;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
	}	
}
