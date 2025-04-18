package kg.alatoo.oauth2;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    private final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        Map<String, Object> attributes = new HashMap<>(oAuth2User.getAttributes());

        if ("google".equals(registrationId)) {
            // Handle Google attributes
        } else if ("github".equals(registrationId)) {
            // Handle GitHub attributes
            /*
            GitHub profile emails can be private.
            The default /user endpoint (which Spring uses by default) only includes public email.
            So, you have to explicitly fetch the emails from a different endpoint (/user/emails) to get private ones.
            */
            System.out.println(userRequest.getAdditionalParameters());
            String email = fetchGithubPrimaryEmail(userRequest);
            attributes.put("email", email);
        } else if ("facebook".equals(registrationId)) {
            // Handle Facebook attributes
        }

        // Return a custom user implementation
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                "email" // or whatever your "nameAttributeKey" is
        );
    }


    private String fetchGithubPrimaryEmail(OAuth2UserRequest userRequest) {
        OAuth2AccessToken accessToken = userRequest.getAccessToken();
        String token = accessToken.getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                "https://api.github.com/user/emails",
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {}
        );

        return Objects.requireNonNull(response.getBody()).stream()
                .filter(emailEntry -> Boolean.TRUE.equals(emailEntry.get("primary")))
                .findFirst()
                .map(emailEntry -> (String) emailEntry.get("email"))
                .orElse(null);
    }
}
