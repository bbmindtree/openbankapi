/**
 * 
 */
package com.mindtree.bbapis.register.service;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindtree.bbapis.entity.Customer;
import com.mindtree.bbapis.repository.CustomerRepository;

/**
 * @author M1037565
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setId(customer.getMobile());
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setEnabled(Boolean.TRUE);
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer oldCustomer = customerRepo.findByMobile(customer.getMobile());
		oldCustomer.setEmailId(customer.getEmailId());
		oldCustomer.setName(customer.getName());
		return customerRepo.save(oldCustomer);
	}

	@Override
	public Customer findByLoginId(String loginId) {
		return customerRepo.findByMobile(loginId);
	}

	@Override
	public Boolean updatePassword(Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepo.save(customer);
		return Boolean.TRUE;
	}

	@Override
	public Boolean sendPasswordChangeLink(String userId) {
		String from = "akki1495@gmail.com";
		String password = "withalldues";
		String ToAddress = customerRepo.findByMobile(userId).getEmailId();
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", 465);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		/* properties.setProperty("mail.smtp.port", "587"); */
		/* Session session = Session.getInstance(properties); */
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToAddress));
			message.setSubject("test mail");
			BodyPart messageBody = new MimeBodyPart();
			message.setContent("<a href='https://www.google.co.in'>click here</a>", "text/html");
			Transport.send(message);
			System.out.println("message " + message + " sent!");
			return Boolean.TRUE;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return Boolean.FALSE;
		}
	}

}
