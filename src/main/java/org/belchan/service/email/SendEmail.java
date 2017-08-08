
package org.belchan.service.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Service
public class SendEmail {
    
    @Autowired
    private EmailAccount emailAccount;

    private String AUTH = "true";;
    private Logger logger = LoggerFactory.getLogger(SendEmail.class);

    public void send(String emailTo, String subject, String messageBody) {
        send(emailTo, null, null, subject, messageBody, Collections.emptyList());
    }

    public void send(String emailTo, String emailCc, String emailBCC, String subject, String messageBody, List<File> attachmentFiles) {
        Runnable runnable = () -> {
            Properties props = new Properties();
            props.put("mail.smtp.auth", AUTH);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", emailAccount.getSERVER());
            props.put("mail.smtp.port", emailAccount.getSmtpPort());
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailAccount.getLOGIN(), emailAccount.getPASSWORD());
                }
            });

            try {
                MimeMessage e = new MimeMessage(session);
                e.setFrom(new InternetAddress(emailAccount.getEMAIL()));
                Assert.notNull(emailTo);
                e.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
                if (emailCc != null) {
					e.setRecipients(Message.RecipientType.CC, InternetAddress.parse(emailCc));
				}
                if (emailBCC != null) {
					e.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(emailBCC));
				}
                e.setSubject(subject);
                e.setText(messageBody);
                if(attachmentFiles == null) {
                    e.setContent(messageBody, "text/html; charset=utf-8");
                } else {
                    MimeBodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText(messageBody);
                    MimeMultipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);
                    messageBodyPart = new MimeBodyPart();

					for (File file : attachmentFiles) {
						FileDataSource source = new FileDataSource(file);
						messageBodyPart.setDataHandler(new DataHandler(source));
						messageBodyPart.setFileName(file.getName());
						multipart.addBodyPart(messageBodyPart);
					}

                    e.setContent(multipart);
                }

                Transport.send(e);
            } catch (MessagingException var10) {
                var10.printStackTrace();
            }

            logger.debug("\nSend message :\n" + "Email to : " + emailTo + "SUBJ : " + subject + "MESSAGE : " + messageBody);
        };
        new Thread(runnable).start();
    }
}
