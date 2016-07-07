package chemtrade.controller.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.entity.Comment;

@WebServlet("/blog-comment")
public class CommentController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = resp.getWriter();
	        Comment comment = new Comment();
	        try {
	       // CommentDAO cd = new CommentDAO();
	       // cd.databaseRetrieval();
	        //ArrayList<Comment> list= ge;
	        //int id=1;
	       // if(!list.isEmpty()) id = list.get(list.size()-1).getId()+1;
	        	int id = getLastCommentId();
	        comment.setId(id + 1);
	        comment.setFname(request.getParameter("fname"));
	        comment.setLname(request.getParameter("lname"));
	        comment.setEmail(request.getParameter("email"));
	        comment.setWebsite(request.getParameter("website"));
	        comment.setComment(request.getParameter("comment"));
	        try{
	        comment.setReply_id(Integer.parseInt(request.getParameter("reply_id")));
	        comment.setBlog_id(Integer.parseInt(request.getParameter("blog_id")));
	        }catch (Exception e){
	            comment.setReply_id(0);
	            comment.setBlog_id(0);
	        }
	        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	        comment.setDatetime(str_date2);
	        
				addComment(comment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				resp.sendError(411, e.getMessage());
			}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String blogId = req.getParameter("id");
		ArrayList<Comment> comments = getComments(blogId);
		ArrayList<CommentWrapper> commentWrappers = new ArrayList<CommentController.CommentWrapper>();
		for (Comment comment : comments){
			ArrayList<Comment>replies =  getReply(comment);
			CommentWrapper commentWrapper = new CommentWrapper();
			commentWrapper.setComment(comment);
			commentWrapper.setReplies(replies);
			commentWrappers.add(commentWrapper);
		}
		
		req.setAttribute("commentWrappers", commentWrappers);
		
		req.getRequestDispatcher("jsp/blog/comment.jsp").forward(req, resp);
		//super.doGet(req, resp);
	}
	
	
		/**
		 * Get all reply of 1 comment
		 * @param comment
		 * @return
		 */
	    public ArrayList<Comment> getReply(Comment comment) {
		// TODO Auto-generated method stub
	    	ArrayList<Comment> replies = new ArrayList<Comment>();
	    		int commentId = comment.getId();
	    		 ArrayList<Comment> comments = new ArrayList<Comment>();
	 	        Connection conn = null;
	 	        PreparedStatement ps = null;
	 	        ResultSet rs = null;
	 	        try {
	 	            conn = ConnectionManager.getConnection();
	 	            ps = conn.prepareStatement("select * from tbl_blog_comment order by id where blog_id = '" + commentId + "';");
	 	            rs = ps.executeQuery();
	 	            rs.next();
	 	            do {
	 	                comments.add(getComment(rs.getInt("id"), rs.getString("fname"),
	 	                        rs.getString("lname"),rs.getString("email"), rs.getString("website"), rs.getString("comment"), rs.getString("datetime"), rs.getInt("reply_id"),rs.getInt("blog_id"), rs.getInt("status")));
	 	            }while (rs.next());
	 	        } catch (Exception e) {
	 	        } finally {
	 	            ConnectionManager.close(conn, ps, rs);
	 	        }
	 			return replies;	
		//return null;
	}



		public Comment getComment(int id, String fname, String lname, String email, String website, String comment, String datetime, int reply_id, int blog_id,int status) {
	        Comment c = new Comment();
	        c.setId(id);
	        c.setFname(fname);
	        c.setLname(lname);
	        c.setEmail(email);
	        c.setWebsite(website);
	        c.setComment(comment);
	        c.setDatetime(datetime);
	        c.setStatus(status);
	        c.setReply_id(reply_id);
	        c.setBlog_id(blog_id);
	        return c;
	    }

	  

		/**
		 * Get list of comments with given blog ID
		 * @param blogId
		 * @return
		 */
	    public ArrayList<Comment> getComments(String blogId) {
	    	 ArrayList<Comment> comments = new ArrayList<Comment>();
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            conn = ConnectionManager.getConnection();
	            String sql  = "select * from tbl_blog_comment  where `blog_id` = '" + blogId + "' and `reply_id` is null order by `id`;";
	            System.out.println (sql);
	            ps = conn.prepareStatement(sql);
	           
	            rs = ps.executeQuery();
	            rs.next();
	            do {
	                comments.add(getComment(rs.getInt("id"), rs.getString("fname"),
	                        rs.getString("lname"),rs.getString("email"), rs.getString("website"), rs.getString("comment"), rs.getString("datetime"), rs.getInt("reply_id"),rs.getInt("blog_id"), rs.getInt("status")));
	            }while (rs.next());
	        } catch (Exception e) {
	        } finally {
	            ConnectionManager.close(conn, ps, rs);
	        }
			return comments;
	    }
	    
	    public void addComment(Comment c) throws SQLException {
	        Connection conn = null;
	        Statement stat = null;
	        
	            conn = ConnectionManager.getConnection();
	            stat = conn.createStatement();
	            stat.executeUpdate("INSERT INTO `tbl_blog_comment` (`id`, `fname`, `lname`, `email`, `website`, `comment`, `reply_id`, `blog_id`, `datetime`, `status`) VALUES\n" +
	            			"("+c.getId()+", '"+c.getFname()+"', '"+c.getLname()+"', '"+c.getEmail()+"', '"+c.getWebsite()+"', '"+c.getComment()+"', "+c.getReply_id()+", "+c.getBlog_id()+", '"+c.getDatetime()+"', "+c.getStatus()+");");
	        
	    }
	    /**
	     * Get last id of comment
	     * @throws SQLException 
	     */
	    public int getLastCommentId() throws SQLException{
	    	 Connection conn = null;
		        Statement stat = null;
		      
		            conn = ConnectionManager.getConnection();
		            String sql = "select max(id) from `tbl_blog_comment`";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            rs.next();
		            return rs.getInt(1);
		       
	    }
	    
	    /**
	     * Class stor information to send to jsp file
	     * @author luisngo
	     *
	     */
	    public class CommentWrapper{
	    	private Comment comment;
	    	private ArrayList<Comment> replies = new ArrayList<Comment>();
			public Comment getComment() {
				return comment;
			}
			public void setComment(Comment comment) {
				this.comment = comment;
			}
			public ArrayList<Comment> getReplies() {
				return replies;
			}
			public void setReplies(ArrayList<Comment> replies) {
				this.replies = replies;
			}
	    }
}
