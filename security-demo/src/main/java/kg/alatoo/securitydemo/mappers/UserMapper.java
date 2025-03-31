package kg.alatoo.securitydemo.mappers;

import kg.alatoo.securitydemo.dao.UserDetailsDao;
import kg.alatoo.securitydemo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDetailsDao toUserDetailsDao(User user) {
        return new UserDetailsDao(user);
    }
}
