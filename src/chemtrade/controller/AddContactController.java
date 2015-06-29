/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import chemtrade.configuration.ConnectionManager;



@WebServlet("/add-contact-us")
public class AddContactController extends HttpServlet {
    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       
//        Connection conn = null; //connection to the database
        String replyMessage = ""; //message will be sent back to the client
        
        try {
        	 String firstName = request.getParameter("firstname");
             String lastName = request.getParameter("lastname");
             String descr = request.getParameter("description");
             String email_ = request.getParameter("email");
             String country_ = request.getParameter("country");
             String message_ = request.getParameter("message");
             
            replyMessage = addContactFormToDatabase(firstName, lastName, descr, email_,
					country_, message_);

        }
        catch (SQLException e){
            replyMessage = "ERROR: " + e.getMessage();
            e.printStackTrace();
            request.getRequestDispatcher("index").forward(request, response);
        }
        
        HttpSession session = request.getSession(false);
        //request.setAttribute("databaseMessage", replyMessage); //sets message in session
        request.getRequestDispatcher("index").forward(request, response);
        
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	    Connection conn = null; //connection to the database
        String replyMessage = ""; //message will be sent back to the client
        
        try {
        	 String firstName = request.getParameter("firstname");
             String lastName = request.getParameter("lastname");
             String descr = request.getParameter("description");
             String email_ = request.getParameter("email");
             String country_ = request.getParameter("country");
             String message_ = request.getParameter("message");
             
            replyMessage = addContactFormToDatabase(firstName, lastName, descr, email_,
					country_, message_);

        }
        catch (SQLException e){
            replyMessage = "ERROR: " + e.getMessage();
            e.printStackTrace();
            request.getRequestDispatcher("index").forward(request, response);
        }
        
        HttpSession session = request.getSession(false);
        //request.setAttribute("databaseMessage", replyMessage); //sets message in session
        request.getRequestDispatcher("index").forward(request, response);
        return;
	}
	
    
    
    /**
     * Add info of contact form to database
     * @param firstName
     * @param lastName
     * @param descr
     * @param email_
     * @param country_
     * @param message_
     * @return
     * @throws SQLException
     */
	private String addContactFormToDatabase(String firstName,
			String lastName, String descr, String email_, String country_,
			String message_) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		String replyMessage = "";
		//connects to the database
		
		//conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		
		//constructs SQL statement
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_contact_us "
		        + "(firstname, lastname, description, email, country, message) values (?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,firstName);
		stmt.setString(2,lastName);
		stmt.setString(3,descr);
		stmt.setString(4,email_);
		stmt.setString(5,country_);
		stmt.setString(6,message_);
		
		int row = stmt.executeUpdate(); //sends statement to the database server
		if (row > 0) {
		    replyMessage = "We've received your query. Thank you.";
		}
		conn.close();
		return replyMessage;
	}
   

	
}
