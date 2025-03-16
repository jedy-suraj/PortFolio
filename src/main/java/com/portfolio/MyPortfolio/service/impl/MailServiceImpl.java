package com.portfolio.MyPortfolio.service.impl;

import com.portfolio.MyPortfolio.model.ContactInfo;
import com.portfolio.MyPortfolio.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

@Service
public class MailServiceImpl implements MailService {


    private final JavaMailSenderImpl mailSender;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine, JavaMailSenderImpl mailSender) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.mailSender = mailSender;
    }
    @Override
    public void sendMail(ContactInfo contactInfo) throws MessagingException, UnsupportedEncodingException {

        String to="surajshindemn@gmail.com";
        String message=contactInfo.getMessage();
        String contactMail=contactInfo.getEmail();
        String name=contactInfo.getName();
        String from="surajshindeas@gmail.com";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Contact From Portfolio");
        mimeMessageHelper.setFrom(from,"Portfolio: Suraj Shinde");

        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("email", contactMail);
        context.setVariable("message", message);

        String htmlContent = templateEngine.process("email-noti.html", context);
        mimeMessageHelper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
        System.out.println("Mail sent");

    }
}
