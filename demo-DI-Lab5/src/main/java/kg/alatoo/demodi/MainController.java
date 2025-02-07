package kg.alatoo.demodi;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class MainController implements
        BeanNameAware, ApplicationContextAware,
        InitializingBean

{
    private GreetingService greetingService;

    private ApplicationContext applicationContext;
    private String beanName;

//    public MainController(
//            @Qualifier("greetingService") GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    public String sayHello() {
        System.out.println("running sayHello in MainController with beanName: " + beanName);
        System.out.println(applicationContext.getBean("primaryGreetingService").getClass().getName());
        return greetingService.getGreeting();
    }


    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        System.out.println("Injecting dependency: GreetingService");
        this.greetingService = greetingService;
    }

    @Override
    public void setBeanName(String name) {
        System.out.printf("Bean with name %s has been created%n", name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Beans available in context at the moment my bean creating:");
        System.out.println(String.join(", ", applicationContext.getBeanDefinitionNames()));

        this.applicationContext = applicationContext;
    }

    @Value("${java.version}")
    public void setJavaVersion(String javaVersion) {
        System.out.println("Java version using: " + javaVersion);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean interface afterPropertiesSet method running");
    }

    @PostConstruct
    public void init() {
        System.out.println("My Custom init method running");
    }
}
