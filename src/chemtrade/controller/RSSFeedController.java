package chemtrade.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import chemtrade.entity.RSSFeed;

@WebServlet ("/rssfeed")
public class RSSFeedController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> categories = new ArrayList<String>();
		ArrayList<RSSFeedWrapper> rssWrappers = new ArrayList<RSSFeedWrapper>();
		try {
			categories = getCategory();
			for (String category : categories){
				ArrayList<RSSFeed> rssFeeds = getRSSFeedList(category);
				RSSFeedWrapper rssFeedWrapper = new RSSFeedWrapper();
				rssFeedWrapper.setCategory(category);
				rssFeedWrapper.setRssFeeds(rssFeeds);
				rssWrappers.add(rssFeedWrapper);
			}
			req.setAttribute("wrappers", rssWrappers);
			req.getRequestDispatcher("jsp/rssfeed.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			req.getRequestDispatcher("index").forward(req, resp);
		}
		
	}
	
	/**
	 * Get list of category in RSS Table
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<String> getCategory() throws SQLException, UnsupportedEncodingException{
		ArrayList<String> categories = new ArrayList<String>();
		Connection conn =  ConnectionManager.getConnection();
		String sql = "select distinct category from tbl_rss_feeds";
		PreparedStatement ps =  conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			categories.add(new String(rs.getBytes(1), "UTF-8"));
		}
		
		return categories;
		
	}
	public ArrayList<RSSFeed> getRSSFeedList(String category) throws UnsupportedEncodingException, SQLException{
		ArrayList<RSSFeed> rssFeeds = new ArrayList<RSSFeed>();
		Connection conn =  ConnectionManager.getConnection();
		String sql = "select * from tbl_rss_feeds where `status`='A' and `category`='" + category + "'";
		PreparedStatement ps =  conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			RSSFeed rssFeed = new RSSFeed();
			rssFeed.setName(new String(rs.getBytes("feed_name"), "UTF-8"));
			rssFeed.setLink(rs.getString("link"));
			rssFeeds.add(rssFeed);
		}
		
		return rssFeeds;
		
	}
	
	public class RSSFeedWrapper{
		private ArrayList<RSSFeed> rssFeeds;
		private String category;
		public ArrayList<RSSFeed> getRssFeeds() {
			return rssFeeds;
		}
		public void setRssFeeds(ArrayList<RSSFeed> rssFeeds) {
			this.rssFeeds = rssFeeds;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
	}
}
