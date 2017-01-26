import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {

	public static void main(String[] args) {
		
		/**
		 * This example use the libs:
		 *   - activation-1.1.1.jar
		 *   - commons-email-1.2.jar
		 *   - mail-1.4.3.jar
		 */
		
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.addTo("danielsantosr.rj@gmail.com", "Daniel Rocha");
			email.setFrom("danielsantosr.rj@gmail.com", "Daniel Rocha");
			email.setSubject("[EMAIL TESTE] Assunto");
			email.setMsg("[EMAIL TESTE] Corpo do Email");
			email.setSSL(true);
			email.setAuthentication("USERNAME@PROVIDEREMAIL.COM", "PASSWORD");
			email.send();
			System.out.println("Email enviado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
