package kg.alatoo.oauth2;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(SecurityContext securityContext) {
        Object principal = securityContext.getAuthentication().getPrincipal();
        return Map.of("principal", principal,
                "principal type", principal.getClass().getName());
    }
}
