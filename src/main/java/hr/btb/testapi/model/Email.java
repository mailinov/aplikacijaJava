package hr.btb.testapi.model;

public class Email {
	private String[] to;
	private String subject;
	private StringBuilder mailTekst;

	public Email() {
	}

	public Email(String[] to, String subject, StringBuilder mailTekst) {
		this.to = to;
		this.subject = subject;
		this.mailTekst = mailTekst;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public StringBuilder getMailTekst() {
		return mailTekst;
	}

	public void setMailTekst(StringBuilder mailTekst) {
		this.mailTekst = mailTekst;
	}

}