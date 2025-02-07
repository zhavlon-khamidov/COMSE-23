package kg.alatoo.demodi;

import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello From Greeting Service Implementation";
    }
}
