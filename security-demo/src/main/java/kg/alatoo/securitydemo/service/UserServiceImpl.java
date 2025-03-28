package kg.alatoo.securitydemo.service;

import kg.alatoo.securitydemo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    //TODO:
    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }

    //TODO:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
