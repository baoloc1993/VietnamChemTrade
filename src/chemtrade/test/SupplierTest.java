package chemtrade.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Supplier;

import com.sun.org.apache.xml.internal.utils.NSInfo;

import chemtrade.controller.SupplierController;
import chemtrade.entity.DetSupplier;
import chemtrade.entity.SupplierProduct;
import junit.framework.TestCase;

public class SupplierTest extends TestCase{
	
	public void testInsertSupplyProduct(){
		SupplierController supplierController = new SupplierController();
		try {
			DetSupplier detSupplier = new DetSupplier();
			detSupplier.setCreated_on(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			SupplierProduct supplierProduct = new SupplierProduct();
			supplierController.insertSupplierProduct(supplierProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertEquals(false, true);
			e.printStackTrace();
		}
	}

	
	public void testInsertSupply(){
		SupplierController supplierController = new SupplierController();
		try {
			DetSupplier detSupplier = new DetSupplier();
			detSupplier.setCreated_on(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			supplierController.insertSupplier(detSupplier);
			//System.out.println (suppliers.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(false, true);
			e.printStackTrace();
		}
	}
	
	public void testGetLastSupplier(){
		SupplierController supplierController = new SupplierController();
		try {
			DetSupplier detSupplier = supplierController.getLastSupplier();
			
			 //DetSupplier detSupplier = getLastSupplier();
		        int id = detSupplier.getDet_supplier_id() + 1;
		        String supidTemp = detSupplier.getEnq_code();
		        supidTemp = supidTemp.substring(4, 6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
