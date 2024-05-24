package com.emial1.email1.Model;



public class EmailMessage {

	private String Name;
    private String to;
    private String subject;
    private String message;

    public EmailMessage() {
    }

    public EmailMessage(String to, String subject, String message,String name) {
    	this.Name=name;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
