package kg.alatoo.demodi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String getGreeting() {
        return "Hello From Primary Greeting Service";
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing my primary bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying my primary bean");
    }

}
