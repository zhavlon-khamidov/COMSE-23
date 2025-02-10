package kg.alatoo.bookstore.controllers;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class MainController {

    @Setter(onMethod_ = @Value("${java.version}"))
    private String javaVersion;

    @Setter(onMethod_ = @Value("${spring.application.name}"))
    private String appName;


    @PostConstruct
    public void init() {
        log.warn("AppInfo: {} {}", appName, javaVersion);
//        System.out.println(javaVersion);
//        System.out.println(appName);
    }
}
