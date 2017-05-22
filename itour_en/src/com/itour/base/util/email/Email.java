package com.itour.base.util.email;
public class Email {
	//发信人姓名
	private String fromname;
	//收信人
	private String to;
	//内容
	private String content;
	//附件
	private String attachment;
	//主题
	private String subject;
	public Email(){
	}
	public Email(String fromname,String to,String subject,String content){
		this.fromname=fromname;
		this.to=to;
		this.subject=subject;
		this.content=content;
	}
	public Email(String fromname,String to,String subject,String content,String attachment){
		this.fromname=fromname;
		this.to=to;
		this.subject=subject;
		this.content=content;
		this.attachment=attachment;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
