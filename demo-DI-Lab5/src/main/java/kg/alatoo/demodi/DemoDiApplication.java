package kg.alatoo.demodi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoDiApplication implements BeanPostProcessor {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoDiApplication.class, args);

        MainController bean = applicationContext.getBean(MainController.class);
        System.out.println(bean.sayHello());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcess called for bean: " + beanName);
        if (bean instanceof PrimaryGreetingService)
            return new PrimaryGreetingServiceProxy((PrimaryGreetingService) bean);
        return bean;
    }
}
