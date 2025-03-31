package kg.alatoo.securitydemo.service;

import kg.alatoo.securitydemo.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    User saveUser(User user);
}
