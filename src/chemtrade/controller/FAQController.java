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

import chemtrade.entity.FAQ;


@WebServlet("/faq")
public class FAQController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        ArrayList<FAQ> faqList = getFAQList();
        int listSize  = faqList.size();
        req.setAttribute("faqList", faqList);
        req.setAttribute("faqSize", listSize);
        req.getRequestDispatcher("jsp/FAQ.jsp").forward(req, resp);
        
	}
	
	/**
	 * Get FAQ List from database
	 * @return
	 */
	public ArrayList<FAQ> getFAQList() {
		Connection conn;
		ArrayList<FAQ> list = new ArrayList<FAQ>();
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from tbl_faq order by faq_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	 FAQ faq = new FAQ();
                 faq.setQuestion(rs.getString("question"));
                 faq.setAnswer(rs.getString("answer"));
                 list.add(faq);
            }
            
            return list;
        } catch (Exception e) {
        	return list;
        } 
    }
	

	

}
