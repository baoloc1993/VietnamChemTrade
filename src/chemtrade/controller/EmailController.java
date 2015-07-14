package chemtrade.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;








import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;
import chemtrade.entity.EmailAccount;


public class EmailController implements Constant{
	 ArrayList<EmailAccount> emailList = new ArrayList<EmailAccount>();
	/**
	 * Setting the Gmail SMTP for sending email
	 * @return
	 */
	private Session settingGmail() {
		Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth", "true");
        
        properties.put("mail.smtp.starttls.enable","true");
	    properties.put("mail.smtp.debug", "true");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.socketFactory.port", PORT);
	    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    properties.put("mail.smtp.socketFactory.fallback", "false");;
	    
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASS);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
		return session;
	}
	
	
	/**
	 * Create setting for sending email through email
	 * Send email via gmail
	 * @param email
	 * @param mailBody
	 * @throws Exception 
	 */
	public void sendEmailViaGmail(final String email, String mailBody, String subject) throws Exception {
		// sets SMTP server properties
        Session session = settingGmail();
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        //try {
			msg.setFrom(new InternetAddress(USER));
			 InternetAddress[] toAddresses = { new InternetAddress(email) };
		        msg.setRecipients(Message.RecipientType.TO, toAddresses);
		        msg.setSubject(subject);
		       // msg.setContent(mailBody, "text/html; charset=utf-8");
		        msg.setSentDate(new Date());
		        msg.setText(mailBody);
		        msg.setContent(mailBody, "text/html; charset=utf-8");
		 
		        // sends the e-mail
		        Transport.send(msg);
		  //      return "SUCCESS";
		
	}
	
	
	public void getEmailAccounts() {
		Connection conn;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT distinct * FROM `tbl_email_accounts` where status=1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String emailType = rs.getString("email_type");
                String email = rs.getString("email_account");
                String status = rs.getString("status");

                EmailAccount emailAccount = new EmailAccount(id, emailType, email, status);
                emailList.add(emailAccount);

            }
            //System.out.println (emailList.size());
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
    
    public String getAdminEmail() {
        getEmailAccounts();        
        for (EmailAccount ea:emailList) {
        	System.out.println (ea.getAccountType());
            if (ea.getAccountType().equalsIgnoreCase("admin")) {
                return ea.getEmailAccount();
            }
        }
        return "";
        
    }
}
