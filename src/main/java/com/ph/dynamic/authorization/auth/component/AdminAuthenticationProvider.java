package com.ph.dynamic.authorization.auth.component;

import com.ph.dynamic.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final var password = authentication.getCredentials().toString();
        final var email = (String) authentication.getPrincipal();
        log.debug("## password: {}", password);
        log.debug("## email: {}", email);
        if (!"password".equals(password)) {
            throw new AuthenticationServiceException("Invalid username and password");
        }
        return userRepository.findByEmail(email
                )
                .map(user -> new AdminAuthentication(user.getEmail()))
                .orElseThrow(() -> new AuthenticationServiceException("Invalid username and password"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
