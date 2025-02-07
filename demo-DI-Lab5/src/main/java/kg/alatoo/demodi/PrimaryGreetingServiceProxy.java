package kg.alatoo.demodi;

public class PrimaryGreetingServiceProxy implements GreetingService {

    private final PrimaryGreetingService primaryGreetingService;

    public PrimaryGreetingServiceProxy(PrimaryGreetingService primaryGreetingService) {
        this.primaryGreetingService = primaryGreetingService;
    }

    @Override
    public String getGreeting() {
        System.out.println("primarygreeting service called");
        return primaryGreetingService.getGreeting();
    }
}
