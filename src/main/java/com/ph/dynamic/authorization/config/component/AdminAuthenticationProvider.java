package com.ph.dynamic.authorization.config.component;

import com.ph.dynamic.authorization.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        log.debug("## username: {}", username);
        log.debug("## password: {}", password);

        UserEntity user = UserEntity.builder()
                .email(username)
                .password(password)
                .build();


        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
