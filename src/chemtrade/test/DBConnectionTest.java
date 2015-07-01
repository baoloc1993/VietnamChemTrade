package chemtrade.test;

import java.sql.Connection;
import java.sql.SQLException;

import chemtrade.configuration.ConnectionManager;



import junit.framework.TestCase;

public class DBConnectionTest extends TestCase {

	public void testConnection(){
		try {
			Connection conn = ConnectionManager.getConnection();
			assertEquals(1, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(1, 2);
			
		}
	}
}
