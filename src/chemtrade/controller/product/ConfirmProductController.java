package chemtrade.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;


@WebServlet("/confirmProduct")
public class ConfirmProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id  = req.getParameter("id");
		String message = "";
		try {
			confirmProduct(id);
			message = getSuccessMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = getFailMessage();
		}finally{
			req.setAttribute("message", message);
			req.getRequestDispatcher("jsp/product/confirm_product.jsp").forward(req, resp);
		}
	}
	
	private String getSuccessMessage(){
		 String message = "<tr>";
         message += "<td>";
         message +="<img src=\"images/confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
         message +="<br>";
         message += "<div class=\"confirmation-mainheader\">Xác nhận yêu cầu</div>";
         message += "<hr>";
         message += "<div class=\"confirmation-details\">";
         message += "Cảm ơn bạn đã gửi yêu cầu. Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất.";
         message += "<br>";
         message += "Chúng tôi hy vọng có cơ hội làm việc với bạn trong tương lai.";
         message +="<br>";
         message +="</div>";
         message += "<a href=\"index\"><input class=\"confirmation-btn\" value=\"Quay lại\" type=\"submit\"></a>";
          message += "</td>";
          message += "</tr>";
          
          return message;
	}
	
	private String getFailMessage(){
		 String message = "<tr>";
        message += "<td>";
        message +="<img src=\"images/no-confirmation-icon.png\" style=\"display: block; margin-left: auto; margin-right: auto\">";
        message +="<br>";
        message += "<div class=\"confirmation-mainheader\">Không tìm thấy dữ liệu</div>";
        message += "<hr>";
        message += "<div class=\"confirmation-details\">";
        message += "Không tìm thấy dữ liệu ";
        message += "<br>";
        message += "Xin hãy điền lại thông tin và gửi cho chúng tôi.";
        message +="<br>";
        message += "Chúng tôi hy vọng có cơ hội làm việc với bạn trong tương lai.";
        message += "<br>";
        message +="</div>";
        message += " <a href=\"index\"><input class=\"confirmation-btn\" value=\"Quay lại\" type=\"button\"></a>";
         message += "</td>";
         message += "</tr>";
         
         return message;
         
	}
	
	public void confirmProduct(String id) throws SQLException{
		Connection conn = ConnectionManager.getConnection();
		String sql="select count(*) from tbl_enquiry where `enquiry_id`='"+ id + "' and `approved_status` = 0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (rs.getInt(1) == 1){
			String sql2 =  "UPDATE tbl_enquiry SET `approved_status` = 1 where `enquiry_id` = '" + id + "';";
			//System.out.println (sql2);
			PreparedStatement ps2  = conn.prepareStatement(sql2);
			ps2.execute();
		}else{
			throw new SQLException();
		}
	}
	
	
	
}
