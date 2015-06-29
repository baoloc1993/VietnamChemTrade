package chemtrade.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import chemtrade.controller.HelloController;
import chemtrade.controller.HelloController.Item;

public class HelloControllerTests extends TestCase {

    
    public void testHandleRequestView() throws Exception{
        HelloController controller = new HelloController();
        
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        //assertEquals("jsp/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        ArrayList<ArrayList<Item>> item =  (ArrayList<ArrayList<Item>>) modelAndView.getModel().get("now");
        assertEquals(5, item.size());
        assertEquals(5, item.get(0).size());
        assertEquals("0", item.get(0).get(0).getName());
    }
}