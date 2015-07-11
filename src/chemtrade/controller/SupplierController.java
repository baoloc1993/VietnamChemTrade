package chemtrade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.entity.CountryCode;
@WebServlet("/supplier")
public class SupplierController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CountryCode> countryCodes= new CountryCodeController().getCountryCodes();
		String verificationCode = "";
        for (int i = 0; i < 6; i++) {
            String rand = String.valueOf((char) (97 + new Random().nextInt(26)));
            verificationCode += rand;
        }
        req.setAttribute("vCode", verificationCode);
		req.setAttribute("country", countryCodes);
		req.getRequestDispatcher("jsp/new-supplier.jsp").forward(req, resp);
	}
}
