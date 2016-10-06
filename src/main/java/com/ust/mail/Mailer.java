package com.ust.mail;
import java.io.StringWriter;

import org.apache.velocity.Template;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mailer {
    private MailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }



    public void sendRestPasswordLink(Mail mail, String link) 
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());

        Template template = velocityEngine.getTemplate(mail.getTemplateName());

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("resetlink", link);

        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());

        mailSender.send(message);
    }
    
    public void sendLoginLink(Mail mail, String link) 
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());

        Template template = velocityEngine.getTemplate(mail.getTemplateName());

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("Loginlink", link);

        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());

        mailSender.send(message);
    }
    
    public void contactUs(Mail mail) 
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        message.setText(mail.getMailContent());
        
       
      //Template template = velocityEngine.getTemplate(mail.getTemplateName());

        //VelocityContext velocityContext = new VelocityContext();
        //velocityContext.put("Loginlink", link);

       // StringWriter stringWriter = new StringWriter();

      //  template.merge(velocityContext, stringWriter);

        //message.setText(stringWriter.toString());

        mailSender.send(message);
    }

}