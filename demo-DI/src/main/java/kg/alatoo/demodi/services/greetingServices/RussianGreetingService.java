package kg.alatoo.demodi.services.greetingServices;

import kg.alatoo.demodi.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("RU")
public class RussianGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        return "Привет Мир!";
    }
}
