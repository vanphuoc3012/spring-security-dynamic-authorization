package com.ph.dynamic.authorization;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "Dynamic authorization", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.COOKIE)
public class SpringSecurityDynamicAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDynamicAuthorizationApplication.class, args);
    }

}
