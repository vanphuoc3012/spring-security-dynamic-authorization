package com.ph.dynamic.authorization;

import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.entities.UserEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import com.ph.dynamic.authorization.repository.UserRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@SecurityScheme(name = "Dynamic authorization", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.COOKIE, scheme = "JSESSIONID")
public class SpringSecurityDynamicAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDynamicAuthorizationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, CompanyRepository companyRepository){
        return args -> {
            var sysAdmin = new UserEntity();
            sysAdmin.setEmail("admin@email.com");
            sysAdmin.setPassword("password");

            userRepository.save(sysAdmin);

            var com1 = new CompanyEntity();
            com1.setName("Company 1");
            com1 = companyRepository.save(com1);

            var com2 = new CompanyEntity();
            com2.setName("Company 2");
            com2 = companyRepository.save(com2);

            var adCom1 = new UserEntity();
            adCom1.setEmail("adcom1@email.com");
            adCom1.setPassword("password");
            adCom1 = userRepository.save(adCom1);

            var adCom2 = new UserEntity();
            adCom2.setEmail("adcom2@email.com");
            adCom2.setPassword("password");
            adCom2 = userRepository.save(adCom2);

        };
    }
}
