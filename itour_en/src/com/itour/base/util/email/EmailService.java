package com.itour.base.util.email;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.SystemVariable;

//import static com.itour.base.util.email.EmailProperty.pass_MAIL_QUITWAIT;
//import static com.itour.base.util.email.EmailProperty.pass_MAIL_SMTP_TIMEOUT;
//import static com.itour.base.util.email.EmailProperty.pass_MAIL_TIMEOUT;
import static com.itour.base.util.email.EmailProperty.pass_MAIL_SMTP_AUTH;
import static com.itour.base.util.email.EmailProperty.pass_MAIL_SMTP_HOST;
import static com.itour.base.util.email.EmailProperty.pass_MAIL_SMTP_PORT;
import static com.itour.base.util.email.EmailProperty.pass_MAIL_TRANSPORT_PROTOCOL;
import static com.itour.base.util.email.EmailProperty.pass_MAIL_TRANSPORT_SSL;


public class EmailService {
	//private EmailProperty prop = new EmailProperty();
	private Properties env = System.getProperties();
	public static void main(String[] args) throws Exception {
		//String receive_email = PropUtil.getValue("receive_email","zzz@163.com");
		//System.out.println(receive_email);
		 //trustAllHttpsCertificates();  
		 //HttpsURLConnection.setDefaultHostnameVerifier(hv);  
		// SslUtils.ignoreSsl();
		// EmailService.sendEmail("zpc@sina.com", "mai test", "testmail","zpc@sina.com","123456","mail.sina.com","25");
		//	emailTemplateService.sendEmail(userMap, acctMap, eventType);
		
		try {
			 String title="主角旅行itours网站";
			 String content = "尊敬的客户您好：您的预定信息已收到，预定成功信息将于24小时内发送到您的邮箱，请留意查看";
			 String receivers = SystemVariable.cache.get("receive_email");
			 String sender = SystemVariable.cache.get("sender_email");
			 String pwd = SystemVariable.cache.get("sender_pwd");
			 String host = SystemVariable.cache.get("sender_host");
			 String port = SystemVariable.cache.get("sender_port");
			 String auth = SystemVariable.cache.get("sender_auth");
			 String ssl = SystemVariable.cache.get("sender_ssl");
			 String protocol = SystemVariable.cache.get("sender_protocol");
			 String attachement ="";
			// String [] emails = receivers.split(";");
			// for(String email:emails){						 
				 EmailService.sendEmail(receivers, title, receivers,sender,pwd,host,port,auth,ssl,protocol,attachement);
			// }
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}   
	/**
	 * 
	 * @param title
	 * @param receive_email
	 * @param subject
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static boolean sendEmail(String title,String receive_email, String subject, String content,String attachment)throws Exception {
		// String receivers = SystemVariable.map.get("receive_email");
		if(SystemVariable.cache.isEmpty()){
			SystemVariable.init();
		}
		 String sender = SystemVariable.cache.get("sender_email");
		 String pwd = SystemVariable.cache.get("sender_pwd");
		 String host = SystemVariable.cache.get("sender_host");
		 String port = SystemVariable.cache.get("sender_port");
		 String auth = SystemVariable.cache.get("sender_auth");
		 String ssl = SystemVariable.cache.get("sender_ssl");
		 String protocol = SystemVariable.cache.get("sender_protocol");
		 return EmailService.sendEmail(receive_email, title, content,sender,pwd,host,port,auth,ssl,protocol,attachment);
	}
	/**
	 * 
	 * @param receive_email
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @param stmp
	 * @param smtp_port
	 * @param auth
	 * @param ssl
	 * @param protocol
	 * @return
	 * @throws Exception
	 */
	public static boolean sendEmail(String receive_email, String subject, String content,String username,String password,String stmp,String smtp_port,String auth,String ssl,String protocol,String attachment)throws Exception {
		try {
			 EmailProperty	prop = new EmailProperty(receive_email,username,password,stmp,smtp_port,auth,ssl,protocol);
			// Properties prop = new Properties();
			// InputStream in = new FileInputStream("email.properties");
			// prop.load(in);
			// String receive_email = prop.getProperty("receive_email");
			EmailService service = new EmailService(prop);
			String [] receivers = receive_email.split(";");
			Email email = null;
		//	Session session = Session.getDefaultInstance(env,
		//			(new MyPasswordAuthenticator(username, password)));
			for(String receiver:receivers){	
				email = new Email(username, receiver, subject, content);
				if(StringUtils.isNotEmpty(attachment)){
					email.setAttachment(attachment);
				}
				service.send(email,prop);
				//System.out.println("邮箱为"+receiver+"的发送成功!!");
			}
	  		email = null;
	  		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			//throw e;
		}finally{
			
		}
	}

	public EmailService(EmailProperty prop) {
		// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		env.setProperty(pass_MAIL_SMTP_HOST, prop.getSmtp());
		env.setProperty(pass_MAIL_SMTP_AUTH, prop.getAuth());
		env.setProperty(pass_MAIL_TRANSPORT_SSL, prop.getSsl());
		env.setProperty(pass_MAIL_SMTP_PORT, prop.getSmtp_port());
		env.setProperty(pass_MAIL_TRANSPORT_PROTOCOL, prop.getProtocol());
	//	env.setProperty("mail.smtp.starttls.enable", "true");
		// env.setProperty("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
	//	env.setProperty("mail.smtp.socketFactory.fallback", "false");
	}
	
	/**
	 * 
	 * @param email
	 * @param prop
	 * @return
	 * @throws Exception
	 */
	public boolean send(Email email, EmailProperty prop) throws Exception {
		final String username = prop.getUsername();
		final String password = prop.getPassword();
//		Session session = Session.getDefaultInstance(env,
//				(new MyPasswordAuthenticator(username, password)));
		Session session =Session.getInstance(env, new MyPasswordAuthenticator(username, password));
		session.setDebug(false);
		//session.setDebug(true);
		Message msg = new MimeMessage(session);
		Transport tr;
		try {
			String to = StringUtils.trimToEmpty(email.getTo());
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(email.getSubject());
			Multipart container = new MimeMultipart();
			MimeBodyPart mdp;
			try {
				String attachment = email.getAttachment();
				if(attachment != null){
					File tmp = new File(attachment);
					if (tmp.exists()) {
						FileDataSource fds = new FileDataSource(attachment);
						mdp = new MimeBodyPart();
						mdp.setDataHandler(new DataHandler(fds));
						mdp.setFileName(MimeUtility.encodeText(fds.getName()));
						container.addBodyPart(mdp);
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setContent(email.getContent(),"text/plain;charset=utf-8");
			container.addBodyPart(textBodyPart);
			msg.setContent(container);
			msg.setSentDate(new Date());
			msg.saveChanges();
			tr = session.getTransport("smtp");
			//SslUtils.ignoreSsl();
			tr.connect(prop.getSmtp(), username, password);
			try {
				tr.send(msg);
				System.out.println("收件人邮箱为："+email.getTo()+"发送成功！！");
			} finally {
				try {
					tr.close();
					session = null;
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		} catch (SendFailedException e) {
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	private static boolean validEmail(String email){
		 //String email = "cwj@163.cn";  
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";  
		return email.matches(regex);  
	  /* if (cwj1) {  
	       System.out.println("是邮箱！");  
	       
	   }else {  
	     System.out.println("不是邮箱！");  
	   }  */
	}
	
}
class MyPasswordAuthenticator extends Authenticator {
	private String user;
	private String pw;

	public MyPasswordAuthenticator(String username, String password) {
		super();
		this.user = username;
		this.pw = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pw);
	}

}
