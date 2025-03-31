package kg.alatoo.securitydemo.config;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityConfigChecker {

    private final SecurityFilterChain chain;

    @PostConstruct
    public void init() {
        List<Filter> filters = chain.getFilters();

        System.out.println("********** Filters **************");
        for (Filter filter : filters) {
            System.out.println(filter.getClass().getName());
        }
        System.out.println("********** Filters **************");


    }

}
