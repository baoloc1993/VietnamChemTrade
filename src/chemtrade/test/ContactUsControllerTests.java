package chemtrade.test;



import junit.framework.TestCase;



import chemtrade.controller.ContactUsController;


import chemtrade.entity.Contact;

public class ContactUsControllerTests extends TestCase {

    
    public void testHandleRequestView() throws Exception{
        ContactUsController controller = new ContactUsController();
        
        
        
        Contact contact = controller.getContactByCountryId("1");
        assertEquals("Singapore",contact.getProvince());
        
        	
        
        
        
        
        
        
    }
}