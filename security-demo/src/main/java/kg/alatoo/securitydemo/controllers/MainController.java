package kg.alatoo.securitydemo.controllers;

import kg.alatoo.securitydemo.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final EmailService emailService;

    @Value("${test.email}")
    private String testEmail;

    @GetMapping
    public String homePage() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println("Principal: " + principal);
        return "home";
    }


    @ResponseBody
    @GetMapping("/testemail")
    public String sendTestMail() {
        emailService.sendSimpleMail(
                this.testEmail,
                "Test Email",
                "This is a test email");
        return "mail sent";
    }
}
