package kg.alatoo.demodi.services.greetingServices;

import kg.alatoo.demodi.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("EN")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello World!";
    }
}
