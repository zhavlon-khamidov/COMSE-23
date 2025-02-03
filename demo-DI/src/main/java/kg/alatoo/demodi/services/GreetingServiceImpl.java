package kg.alatoo.demodi.services;

//@Service("myGreetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello from GreetingServiceImpl!";
    }

}
