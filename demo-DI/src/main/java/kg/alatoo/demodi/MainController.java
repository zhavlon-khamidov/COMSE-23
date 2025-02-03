package kg.alatoo.demodi;

import kg.alatoo.demodi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final GreetingService greetingService;

    public MainController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.getGreeting();
    }
}
