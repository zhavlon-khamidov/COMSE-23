package kg.alatoo.demodi.services;

//@Primary
//@Service
public class PrimaryGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello from Primary Greeting Service!";
    }
}
