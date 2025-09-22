package models;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServices {
	
	private final static String senderMail="rahuldhonnar74@gmail.com";
	private final static String senderPass="fvpz invh vlxm iucp";  

	public static void sendBookingConfirmation(String name, int days, double rentalRate, double bill, String vehicleID, String email)
	{
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String subject="Vehicle Rental Confirmation ";
		String body="Hello "+name+", your booked vehicle succesfully .with vehicleID :"+vehicleID+"\n Rental Rate :"+rentalRate+" \n No of days"+days+"\n Total Bill :"+bill;
		
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		
		//javax
		//activation

		 Session session=Session.getInstance(properties,new Authenticator() {
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication() {

			 return new PasswordAuthentication(senderMail, senderPass);

			 }
			 });
		 
		 Message message =new MimeMessage(session);

		 try {

		 message.setFrom(new InternetAddress(senderMail));
		 message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		 message.setSubject(subject);
		 message.setText(body);
		 Transport.send(message);
		 System.out.println("mail sent to "+email+" .......");

		 } catch (MessagingException e) {
		 System.out.println("Some issues occured");
		 e.printStackTrace();
		 }
		 
		
//		System.out.println("Booking confirmation mail sent succesfully ");
	}

}
