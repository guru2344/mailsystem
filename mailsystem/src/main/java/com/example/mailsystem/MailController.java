package com.example.mailsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailRequest request){

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(request.getFrom());
        mail.setTo(request.getTo());
        mail.setSubject(request.getSubject());
        mail.setText(request.getMessage());

        mailSender.send(mail);

        return "Email Sent Successfully!";
    }

}