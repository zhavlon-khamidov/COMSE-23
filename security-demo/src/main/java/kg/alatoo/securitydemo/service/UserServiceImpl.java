package kg.alatoo.securitydemo.service;

import kg.alatoo.securitydemo.entity.User;
import kg.alatoo.securitydemo.mappers.UserMapper;
import kg.alatoo.securitydemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    //TODO:
    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    //TODO:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUsername(username)
                .map(userMapper::toUserDetailsDao)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User with username '" + username + "' not found")
        );
    }
}
