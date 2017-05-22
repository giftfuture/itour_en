package com.itour.base.util.email;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class EmailProperty {
	
	private String receiver;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 地址
	private String smtp;
	// 端口号
	private String smtp_port;
	
	private String auth;
	
	private String protocol;
	
	private String ssl;
	
	public static final String pass_MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String pass_MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String pass_MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String pass_MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	public static final String pass_MAIL_TRANSPORT_SSL ="mail.smtp.ssl";
	public static final String pass_MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
	public static final String pass_MAIL_TIMEOUT = "5000";
	public static final String pass_MAIL_QUITWAIT="mail.smtp.quitwait";

	public  EmailProperty(){
	  
    }
	

	public EmailProperty(String username,String password,String stmp,String smtp_port) {
		//Properties prop = new Properties();
		//InputStream inStream;
		try {
			// inStream =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream("email.properties");
			// inStream = new FileInputStream("./resource/email.properties");
			// InputStreamReader rd = new InputStreamReader(inStream, "utf-8");
			// prop.load(rd);// 说明 在jdk1.5时不可用
			// prop.load(inStream);
			this.username = username;
			this.password = password;
			this.smtp = stmp;
			this.smtp_port =smtp_port;
			// inStream.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public EmailProperty(String receiver,String username,String password,String stmp,String smtp_port,String auth,String ssl,String protocol) {
			this.receiver = receiver;
			this.username = username;
			this.password = password;
			this.smtp = stmp;
			this.smtp_port =smtp_port;
			this.ssl = ssl;
			this.protocol = protocol;
			this.auth = auth;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getSmtp_port() {
		return smtp_port;
	}

	public void setSmtp_port(String smtpPort) {
		smtp_port = smtpPort;
	}


	public String getAuth() {
		return auth;
	}


	public void setAuth(String auth) {
		this.auth = auth;
	}


	public String getProtocol() {
		return protocol;
	}


	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


	public String getSsl() {
		return ssl;
	}


	public void setSsl(String ssl) {
		this.ssl = ssl;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
}
