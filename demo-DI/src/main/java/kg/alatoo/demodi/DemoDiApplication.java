package kg.alatoo.demodi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoDiApplication {

    @Autowired
    private MainController mainController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoDiApplication.class, args);

        MainController bean = applicationContext.getBean(MainController.class);
        System.out.println(bean.sayHello());
    }

}
