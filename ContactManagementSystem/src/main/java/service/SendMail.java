package service;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendMail {
	public SendMail(String receipient, String subject, String messageBody) throws AddressException, MessagingException {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String email = "example@gmail.com";
		String password = "app-password";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipient));
		message.setSubject(subject);
		message.setText(messageBody);

		Transport.send(message);
		System.out.println("Mail Sent");

	}
}
