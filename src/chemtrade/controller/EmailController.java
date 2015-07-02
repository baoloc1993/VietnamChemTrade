package chemtrade.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import chemtrade.configuration.Constant;

public class EmailController implements Constant{

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
	 */
	public void sendEmailViaGmail(final String email, String mailBody, String subject) throws Exception{
		// sets SMTP server properties
        Session session = settingGmail();
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        //try {
			msg.setFrom(new InternetAddress(USER));
			 InternetAddress[] toAddresses = { new InternetAddress(email) };
		        msg.setRecipients(Message.RecipientType.TO, toAddresses);
		        msg.setSubject(subject);
		        msg.setContent(mailBody, "text/html; charset=utf-8");
		        msg.setSentDate(new Date());
		        msg.setText(mailBody);
		 
		        // sends the e-mail
		        Transport.send(msg);
		  //      return "SUCCESS";
		
	}
}
