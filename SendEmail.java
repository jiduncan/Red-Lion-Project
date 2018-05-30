import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

/* Program will send a simple text message to the emails specified. 
   Email will be sent to SMTP2GO on port 25.
   Created By: Johnny Duncan
   Version:    5/30/2018
*/
public class SendEmail {
   public static void main(String[] args) {
      //logon credentials for SMTP2G0
      final String username = "gwsredlion";
      final String password = "Bf3elite123!";
      //properties to log into SMTP2GO
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "mail.smtp2go.com");
      props.put("mail.smtp.port", "25");
      //creating a login session to the SMTP2GO server
      Session session = Session.getInstance(props, new javax.mail.Authenticator() { 
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      //creates and sends message.
      try {
         Message message = new MimeMessage(session);
         Multipart mp = new MimeMultipart("alternative");
         BodyPart textmessage = new MimeBodyPart();
         textmessage.setText("hello n");
         BodyPart htmlmessage = new MimeBodyPart();
         htmlmessage.setContent("Im a little tea pot short and stout", "text/html");
         mp.addBodyPart(textmessage);
         mp.addBodyPart(htmlmessage);
         message.setFrom(new InternetAddress("seedwardgayland@gmail.com"));
         //add multiple recipients seperated by commas.
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse("evilonyxx@gmail.com,johnny@gaylandwardseed.com"));
         message.setSubject("Java Mail using SMTP2GO");
         message.setContent(mp);
         Transport.send(message);
         System.out.println("Done");
      }
      catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}