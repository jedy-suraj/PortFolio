package com.portfolio.MyPortfolio.service;

import com.portfolio.MyPortfolio.model.ContactInfo;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface MailService {

    public void sendMail(ContactInfo contactInfo) throws MessagingException, UnsupportedEncodingException;
}
