package kg.alatoo.securitydemo.service;

public interface EmailService {

    void sendSimpleMail(String to, String subject, String content);
}
