package com.ph.dynamic.authorization.auth.component;

import com.ph.dynamic.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final var password = authentication.getCredentials().toString();

        if (!"password".equals(password)) {
            throw new AuthenticationServiceException("Invalid username and password");
        }
        return userRepository.findById((String) authentication.getPrincipal())
                .map(user -> new AdminAuthentication(user.getEmail()))
                .orElseThrow(() -> new AuthenticationServiceException("Invalid username and password"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
