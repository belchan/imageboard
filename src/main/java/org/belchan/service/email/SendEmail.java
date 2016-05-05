
package org.belchan.service.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class SendEmail extends Thread {
    private EmailAccount emailAccount;
    private String AUTH;
    private String emailTo;
    protected String emailCc;
    protected String subject;
    protected String messageBody;
    protected List<File> attachmentFiles;
    protected Logger logger;

    @Autowired
    public void setSendEmail(EmailAccount myemailAccount) {
        this.emailAccount = myemailAccount;
    }

    public SendEmail(String emailTo, String subject, String messageBody) {
        this(emailTo, (String)null, subject, messageBody, (List)null);
    }

    public SendEmail(String emailTo, String emailCc, String subject, String messageBody, List<File> attachmentFiles) {
        this.AUTH = "true";
        this.logger = LoggerFactory.getLogger(this.getClass().getName());
        this.emailTo = emailTo;
        this.emailCc = emailCc;
        this.subject = subject;
        this.messageBody = messageBody;
        this.attachmentFiles = attachmentFiles;
    }

    public void run() {
        UUID id = UUID.randomUUID();
        this.logger.debug("Start " + id.toString() + ".run()");
        Properties props = new Properties();
        props.put("mail.smtp.auth", this.AUTH);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.emailAccount.getSERVER());
        props.put("mail.smtp.port", this.emailAccount.getSmtpPort());
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SendEmail.this.emailAccount.getLOGIN(), SendEmail.this.emailAccount.getPASSWORD());
            }
        });

        try {
            MimeMessage e = new MimeMessage(session);
            e.setFrom(new InternetAddress(this.emailAccount.getEMAIL()));
            e.setRecipients(RecipientType.TO, InternetAddress.parse(this.emailTo));
            e.setSubject(this.subject);
            e.setText(this.messageBody);
            if(this.attachmentFiles == null) {
                e.setContent(this.messageBody, "text/html; charset=utf-8");
            } else {
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText("messageBody");
                MimeMultipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                messageBodyPart = new MimeBodyPart();
                Iterator var7 = this.attachmentFiles.iterator();

                while(var7.hasNext()) {
                    File file = (File)var7.next();
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

        this.logger.debug("\nSend message : " + id.toString() + "\n" + "Email to : " + this.emailTo + "SUBJ : " + this.subject + "MESSAGE : " + this.messageBody);
    }
}
