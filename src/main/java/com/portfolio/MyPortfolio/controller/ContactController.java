package com.portfolio.MyPortfolio.controller;

import com.portfolio.MyPortfolio.model.ContactInfo;
import com.portfolio.MyPortfolio.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class ContactController {

    public MailService mailService;

    @Autowired
    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new ContactInfo());
        return "contact";
    }

    @PostMapping("/send-mail")
    public String sendMail(@ModelAttribute("contact") ContactInfo contact) throws MessagingException, UnsupportedEncodingException {
        mailService.sendMail(contact);
        return "redirect:/";
    }

}
