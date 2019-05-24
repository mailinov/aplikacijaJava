package hr.btb.testapi.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hr.btb.testapi.model.Email;
import hr.btb.testapi.model.User;

@Transactional
@Repository
public class MailBuilder {

	// Method za slanje mail-a
	public static void send(Email email) throws UnsupportedEncodingException, MessagingException {

		Properties props = propertiesInitialization();
		System.out.println("MailBuilder prop ok");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		message.setSubject(email.getSubject());
		message.setFrom(new InternetAddress(MailEnvironment.MAIL_USERNAME));
		message = setTo(message, email.getTo());

		InternetHeaders headers = new InternetHeaders();
		headers.addHeader("Content-type", "text/html; charset=UTF-8");

		Multipart multipart = new MimeMultipart();

		MimeBodyPart messageBodyPart1 = new MimeBodyPart(headers, email.getMailTekst().toString().getBytes());
		multipart.addBodyPart(messageBodyPart1);

		message.setContent(multipart);

		Transport transport = session.getTransport("smtp");
		transport.connect(MailEnvironment.MAIL_HOST, MailEnvironment.MAIL_USERNAME, MailEnvironment.MAIL_PASSWORD);
		System.out.println("MailBuilder send start");
		transport.sendMessage(message, message.getAllRecipients());
		System.out.println("MailBuilder send end");
		System.out.println("---------------------------");
		System.out.println();
		transport.close();
	}

	// Metoda za odredjivanje kome saljemo
	private static MimeMessage setTo(MimeMessage message, String[] to) throws MessagingException {

		InternetAddress[] toAddress = new InternetAddress[to.length];

		for (int i = 0; i < to.length; i++) {
			toAddress[i] = new InternetAddress(to[i]);
		}

		for (int i = 0; i < toAddress.length; i++) {
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		return message;
	}

	// inicjalizacija maila sa kojeg se šalje
	private static Properties propertiesInitialization() {

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", MailEnvironment.MAIL_HOST);
		props.put("mail.smtp.user", MailEnvironment.MAIL_USERNAME);
		props.put("mail.smtp.password", MailEnvironment.MAIL_PASSWORD);
		props.put("mail.smtp.port", MailEnvironment.MAIL_PORT);
		props.put("mail.smtp.auth", "true");

		return props;
	}

	public boolean sendMail(User user) throws UnsupportedEncodingException, MessagingException {

		String[] to = null;
		String subject = "";
		StringBuilder mailTekst = null;

		to = new String[] { "mario.ilinovic@btb.hr", ((User) user).getMail() };

		subject = "Novi user";
		mailTekst = new StringBuilder();

		mailTekst.append("<h3> Podaci o korisniku </h3>");
		mailTekst.append("<p> Ime: <b>" + ((User) user).getIme() + "</b> </p>");
		mailTekst.append("<p> Prezime: <b>" + ((User) user).getPrezime() + "</b> </p>");
		mailTekst.append("<p> Korisničko ime: <b>" + ((User) user).getKorisnicko_ime() + "</b> </p>");
		mailTekst.append("<p> Lozinka: <b>" + ((User) user).getLozinka() + "</b> </p>");

		Email email = new Email(to, subject, mailTekst);
		send(email);

		return true;
	}

}
