package chemtrade.test;

import java.util.ArrayList;

import chemtrade.controller.UsefulToolsController;
import chemtrade.entity.UsefulTool;
import junit.framework.TestCase;

public class UsefulToolControllerTest extends TestCase{
	
	public void testLoadReource(){
		
		UsefulToolsController use = new UsefulToolsController();
		ArrayList<UsefulTool> toolList =  use.getAssociationResource();
		
		assertEquals(5, toolList.size());
		
	}
	

}
