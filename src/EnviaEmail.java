import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {

	public static void main(String[] args) {

		/**
		 * This example use the libs: - activation-1.1.1.jar -
		 * commons-email-1.2.jar - mail-1.4.3.jar
		 */

		try {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(
					"/dominios/hom/riocard/ressarcimento/rcti_boleto_registrado/saida/cnab400_7_13002885_2017-01-27-13.48.14.575.txt");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Picture of John");
			attachment.setName("John");

			/*
			 * SimpleEmail email = new SimpleEmail();
			 * email.setHostName("smtp.gmail.com"); email.setSmtpPort(465);
			 * email.addTo("danielsantosr.rj@gmail.com", "Daniel Rocha");
			 * email.setFrom("danielsantosr.rj@gmail.com", "Daniel Rocha");
			 * email.setSubject("[EMAIL TESTE] Assunto"); email.setMsg(
			 * "[EMAIL TESTE] Corpo do Email"); email.setSSL(true);
			 * email.setAuthentication("USERNAME@PROVIDEREMAIL.COM","PASSWORD"); email.send();
			 */

			MultiPartEmail email = new MultiPartEmail();
			
			email.setHostName("smtp.gmail.com");
		    email.setSmtpPort(465);
		    email.setSSL(true);
		    email.setAuthentication("email", "password");
		    email.setCharset("UTF-8");			

			email.addTo("danielsantosr.rj@gmail.com", "John Doe");
			email.setFrom("me@apache.org", "Me");
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");
			
			email.attach(attachment);
			
			email.send();

			System.out.println("Email enviado!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
