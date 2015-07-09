package chemtrade.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.HelloController;
import chemtrade.controller.HelloController.Item;

@WebServlet("/test")
public class HelloControllerTests extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int code = Integer.decode("º");
//		BufferedReader in = new BufferedReader(
//		        new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String str = (String.format("And this is an hexa code: %x", (int) 'a'));

		///req.setAttribute("test","\\u" +code);
		
		req.setAttribute("message","\u00BA");
		req.getRequestDispatcher("jsp/test.jsp").forward(req, resp);
	}

		
    
//    public void testHandleRequestView() throws Exception{
//        HelloController controller = new HelloController();
//        
//        ModelAndView modelAndView = controller.handleRequest(null, null);
//        assertEquals("hello", modelAndView.getViewName());
//        //assertEquals("jsp/hello.jsp", modelAndView.getViewName());
//        assertNotNull(modelAndView.getModel());
//        ArrayList<ArrayList<Item>> item =  (ArrayList<ArrayList<Item>>) modelAndView.getModel().get("now");
//        assertEquals(5, item.size());
//        assertEquals(5, item.get(0).size());
//        assertEquals("0", item.get(0).get(0).getName());
//    }
	
	
}