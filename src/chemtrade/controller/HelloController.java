package chemtrade.controller;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");

//        String now = (new Date()).toString();
        //logger.info("Returning hello view with " + now);
        ArrayList<ArrayList<Item>> list = new ArrayList<ArrayList<Item>>();
        for (int i = 0; i<5; i++){
        	ArrayList<Item> list2 =  new ArrayList<Item>();
        	for (int j = 0; j < 5 ; j++){
        		list2.add(new Item(String.valueOf(i*j)));
        	}
        	list.add(list2);
        	
        }
        ModelAndView model = new ModelAndView("hello");
        model.addObject("now", list);

        return model;
    }
    
    public class Item {
    	private String name ="";
    	public Item(String name) {
			// TODO Auto-generated constructor stub
    		this.setName(name);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    	
    
    }

}