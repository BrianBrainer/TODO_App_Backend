package com.TrainorInc.rest.webservices.restfulwebservices.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromAddress;

    public void sendRegistrationEmail(String toEmailAddress)
    {
        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setFrom(fromAddress);
        registrationEmail.setTo(toEmailAddress);
        registrationEmail.setSubject("Registration");
        registrationEmail.setText("Thanks for registering!");
        javaMailSender.send(registrationEmail);

    }
}
