
package chemtrade.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;

import chemtrade.entity.UsefulTool;
/**
 * 
 * @author ngolebaoloc
 *
 */
@WebServlet("/usefulTools")
public class UsefulToolsController extends HttpServlet{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<UsefulTool> widgetList = new ArrayList<UsefulTool>();
	ArrayList<UsefulTool> resourceList = new ArrayList<UsefulTool>();
	ArrayList<UsefulTool> associationList = new ArrayList<UsefulTool>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id  = 1;
		
		try{
			id = Integer.parseInt(req.getParameter("id"));
			
		}catch(Exception e){
			id  = 1;
		}
	    //UsefulToolsDAO toolDAO = new UsefulToolsDAO();
	    getWidgets();
	    populateLinks();
	    getResources();
	    getAssociationResource();
	    
	    req.setAttribute("id", id);
	    req.setAttribute("widgets", widgetList );
	    req.setAttribute("resources", resourceList);
	    req.setAttribute("associations", associationList);
	    req.getRequestDispatcher("jsp/usefulTools.jsp").forward(req,resp);
		//super.doGet(req, resp);
	}
	
	


	 public ArrayList<UsefulTool> getWidgets() {
		 widgetList.clear();
	    try {
	        conn = ConnectionManager.getConnection();
	        ps = conn.prepareStatement("select * from tbl_widgets order by widget_id");
	        rs = ps.executeQuery();

	        while (rs.next()) {

	            int widgetID = rs.getInt("widget_id");
	            String widgetName = rs.getString("widget_name");
	            String widgetCode = rs.getString("widget_code");
	            
	            UsefulTool usefulTool = new UsefulTool(widgetID, widgetName, widgetCode);
	            widgetList.add(usefulTool);       
	          
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return widgetList;

	}
	 
	 public void populateLinks() {
		 resourceList.clear();
		 associationList.clear();
	    try {
	        conn = ConnectionManager.getConnection();
	        ps = conn.prepareStatement("select * from tbl_usefull_tools order by usefull_id");
	        rs = ps.executeQuery();

	        while (rs.next()) {

	            int id = rs.getInt("usefull_id");
	            String name = rs.getString("title");
	            String link = rs.getString("link");
	            String category = rs.getString("category");
	            
	            UsefulTool usefulTool = new UsefulTool(id, name, link); 
	            
	            if (category.equalsIgnoreCase("resources")) {
	                resourceList.add(usefulTool);
	            } else {
	                associationList.add(usefulTool);
	            }              
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	 
	 public ArrayList<UsefulTool> getAssociationResource(){
		 ArrayList<UsefulTool> associationResources = new ArrayList<UsefulTool>();
		 try {
		        conn = ConnectionManager.getConnection();
		        ps = conn.prepareStatement("select * from tbl_usefull_tools order by usefull_id");
		        rs = ps.executeQuery();

		        while (rs.next()) {

		            int id = rs.getInt("usefull_id");
		            String name = rs.getString("title");
		            String link = rs.getString("link");
		            //String category = rs.getString("category");
		            
		            UsefulTool usefulTool = new UsefulTool(id, name, "");
		            usefulTool.setLink(link);
		            //UsefulTool usefulTool = new UsefulTool(id, name, link); 
		           associationResources.add(usefulTool);
		           if (associationResources.size() >= 5) break;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 return associationResources;
	 }
	 public ArrayList<UsefulTool> getResources() {
	     return resourceList;
	 }

	 public ArrayList<UsefulTool> getAssociations() {
	     return associationList;
	 }
}




