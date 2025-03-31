package kg.alatoo.securitydemo.bootstrap;

import kg.alatoo.securitydemo.entity.Role;
import kg.alatoo.securitydemo.entity.User;
import kg.alatoo.securitydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitUsers implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .name("User")
                .password("123456")
                .username("user")
                .roles(List.of(Role.USER))
                .build();

        User admin = User.builder()
                .name("Admin")
                .password("123456")
                .username("admin")
                .roles(List.of(Role.ADMIN, Role.USER))
                .build();

        userService.saveUser(user);
        userService.saveUser(admin);
    }
}
