package kg.alatoo.demodi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoDiApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    MainController mainController;

    @Test
    void contextLoads() {

        MainController bean = context.getBean(MainController.class);
        System.out.println(bean.sayHello());
    }

}
