package chemtrade.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import chemtrade.controller.blog.BlogController;
import chemtrade.controller.blog.CommentController;
import chemtrade.entity.Blog;
import chemtrade.entity.Comment;
import junit.framework.TestCase;

public class BlogTest extends TestCase {

	
	public void testBlog(){
		BlogController blogController = new BlogController();
		ArrayList<Blog> blogList;
		try {
			blogList = blogController.getBlogList(1);
			assertEquals(2,blogList.size());
			assertEquals(1,blogList.get(0).getNumComments());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testGetRecentPost(){
		BlogController blogController = new  BlogController();
		ArrayList<Blog> blogList;
		try {
			blogList = blogController.getRecentPost();
			assertEquals(2,blogList.size());
			//assertEquals(1,blogList.get(0).getNumComments());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testComment(){
		CommentController commentController = new CommentController();
		ArrayList<Comment>comments = commentController.getComments("2");
		System.out.println (comments.size());
		
		try {
			int id = commentController.getLastCommentId();
			System.out.println (id);
			Comment comment = new Comment();
			comment.setBlog_id(2);
			comment.setFname("First Name");
			comment.setLname("last name");
			String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	        comment.setDatetime(str_date2);
			
			commentController.addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//commentController.getReply(comments.get(0));
	}
	public void testAll(){
		BlogController blogController = new  BlogController();
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		ArrayList<Blog> recentPost = new ArrayList<Blog>();
		int showPage = 1;
//		try{
//			showPage =  Integer.parseInt(req.getParameter("page"));
//		}catch(Exception e){
//			showPage  =1;
//		}
		try {
			blogList = blogController.getBlogList(showPage);
			recentPost =blogController.getRecentPost();
			String paging = blogController.getNumberPaging(showPage, blogController.getBlogSize());
//			 resp.setHeader("Content-Length", String.valueOf(1048576));
//			req.setAttribute("blogs", blogList);
//			req.setAttribute("recentPosts", recentPost);
//			req.setAttribute("paging", paging);
//			req.getRequestDispatcher("jsp/blog/blog.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//resp.sendError(430,e.getMessage());
			//req.getRequestDispatcher("index").forward(req, resp);
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			//resp.sendError(431,e.getMessage());
		}
	}
}
