package com.abdelaziz.projects.springredditclone.service;

import com.abdelaziz.projects.springredditclone.config.ConfigProperties;
import com.abdelaziz.projects.springredditclone.exception.SpringRedditException;
import com.abdelaziz.projects.springredditclone.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final MailContentBuilder mailContentBuilder;
    private final ConfigProperties configProperties;

    void processEmailNotification(NotificationEmail notificationEmail) throws SpringRedditException {


        MimeMessagePreparator messagePreparator = msg -> {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(notificationEmail.getRecipient());
            helper.setSubject(notificationEmail.getSubject());
            helper.setFrom(configProperties.getEmailFrom());
            helper.setText(notificationEmail.getBody(), true);
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Email is sent successfully");
        } catch (MailException ex) {

        }

    }
}
