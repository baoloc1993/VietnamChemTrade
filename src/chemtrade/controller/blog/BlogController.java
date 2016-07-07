package chemtrade.controller.blog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.entity.Blog;
@WebServlet("/blog")
public class BlogController extends HttpServlet implements Constant{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			ArrayList<Blog> blogList = new ArrayList<Blog>();
			ArrayList<Blog> recentPost = new ArrayList<Blog>();
			int showPage = 1;
			try{
				showPage =  Integer.parseInt(req.getParameter("page"));
			}catch(Exception e){
				showPage  =1;
			}
			try {
				blogList = getBlogList(showPage);
				recentPost =getRecentPost();
				String paging = getNumberPaging(showPage, getBlogSize());
				 resp.setHeader("Content-Length", String.valueOf(1048576));
				req.setAttribute("blogs", blogList);
				req.setAttribute("recentPosts", recentPost);
				req.setAttribute("paging", paging);
				req.getRequestDispatcher("jsp/blog/blog.jsp").forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				resp.sendError(430,e.getMessage());
				//req.getRequestDispatcher("index").forward(req, resp);
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				resp.sendError(431,e.getMessage());
			}

	        
 
		 
		 
		 
		 //BlogDAO dao = new BlogDAO();
         //dao.databaseRetrieval();
         
		
	}
	/**
	 * Get Recent Post
	 * @throws SQLException 
	 */
	
	public ArrayList<Blog> getRecentPost() throws SQLException{
		ArrayList<Blog> recentPost = new ArrayList<Blog>();
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement("select * from tbl_blog order by `created_on` desc limit 10;");
            rs = ps.executeQuery();
            while (rs.next()){
            	recentPost.add(getBlog(rs.getInt("blog_id"),
                        rs.getString("blog_title"),rs.getString("author"), rs.getString("blog_desc"), rs.getString("blog_link"), rs.getString("blog_img"), rs.getString("location"),
                         rs.getString("date"), rs.getString("approved_sts"), rs.getString("status"),rs.getString("created_on"),rs.getString("ip_address"),0));
            }
		return recentPost;
		
	}
	/**
	 *
	 * @author Fla
	 */
	
	     ArrayList<Blog> list = new ArrayList<Blog>();

	    public Blog getBlog(int blog_id,String blog_title,String  author,String  blog_desc,String  blog_link,String  blog_img,String  location,String  date,String  approved_sts,String  status,String created_on,String ip_address, int numComments) {
	        Blog b = new Blog();
	        b.setId(blog_id);
	        b.setTitle(blog_title);
	        b.setDescription(blog_desc);
	        b.setAuthor(author);
	        b.setLink(blog_link);
	        b.setImage(blog_img);
	        b.setDate(date);
	        b.setLocation(location);
	        b.setApproved_sts(approved_sts);
	        b.setStatus(status);
	        b.setCreated_on(created_on);
	        b.setIp_address(ip_address);
	        b.setNumComments(numComments);
	        return b;
	    }

	    /**
	     * Get number of blog
	     */
	    public int getBlogSize() throws SQLException {
	    	 Connection conn = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		       
		            conn = ConnectionManager.getConnection();
		            ps = conn.prepareStatement("select count(*) from tbl_blog");
		            rs = ps.executeQuery();
		            rs.next();
		            return rs.getInt(1);
	    	
	        
	    }
	   /**
	    * Get List of Blog by page
	    */
	    public ArrayList<Blog> getBlogList(int page) throws SQLException {
	    	
	    	ArrayList<Blog> list = new ArrayList<Blog>();
	    	if (page < 1){
	    		page = 1;
	    	}
	    	int first = (page-1) * NUMBER_ITEM_PER_PAGE;
	    	int last = first + NUMBER_ITEM_PER_PAGE;
	    	list = getBlogList(first, last);
	          return list;
	        
	    }
	    /**
	     * Get list of Blog 
	     * @param first begin position in database
	     * @param last  end position in database
	     * @return
	     * @throws SQLException
	     */
	    public ArrayList<Blog> getBlogList(int first, int last) throws SQLException {
	    	int count = last - first;
	    	 if (first < 0 || last < 0){
	    		 count = 0;
	    	 }
	    	ArrayList<Blog> list = new ArrayList<Blog>();
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       
	            conn = ConnectionManager.getConnection();
	            ps = conn.prepareStatement("select * from tbl_blog order by blog_id limit " + count +" OFFSET " + first + ";");
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	            	String sql2 = "select count(*) from tbl_blog_comment  where `blog_id` = '" + rs.getInt(1) + "' and `reply_id` is null order by `id`;";
	            	//System.out.println(sql2);
	            	PreparedStatement ps2 = conn.prepareStatement(sql2);
	            	ResultSet rs2 = ps2.executeQuery();
	            	rs2.next();
	            	
	            	int numComments = rs2.getInt(1);
	                list.add(getBlog(rs.getInt("blog_id"),
	                        rs.getString("blog_title"),rs.getString("author"), rs.getString("blog_desc"), rs.getString("blog_link"), rs.getString("blog_img"), rs.getString("location"),
	                         rs.getString("date"), rs.getString("approved_sts"), rs.getString("status"),rs.getString("created_on"),rs.getString("ip_address"), numComments));
	            }
	          return list;
	        
	    }
	    /**
	     * get paging 
	     * @param showPage
	     * @param pageCount
	     * @return
	     */
	    public String getNumberPaging(int showPage, int pageCount){
	    	String paging = ""; 
	    	if (showPage > 1) {
	    		paging += "<li ><a href=\"blog?page=" + String.valueOf(showPage - 1) + "\">< Previous</a></li>";
	    	}
	        if (showPage > 3) {

	        }
	        for (int i = 1; i <= pageCount; i++) {
	            if (showPage == i) {

	            	paging+="<li  class=\"active\"><a href=\"blog?page=" + i +"\">" + i + "</a></li>";
	            } else {
	            	if (i < showPage + 3 && i > showPage - 3) {
	        
	            		paging += "<li><a href=\"blog?page=" + i +"\">" + i + "</a></li>";
	            	}
	            }
	        }
	        if (showPage < pageCount) {
	        

	        	paging += "<li ><a href=\"blog?page=" + String.valueOf(showPage + 1) + "\">Next ></a></li>";
	        
	        }

	        
			return paging;
	    	
	    }

}
