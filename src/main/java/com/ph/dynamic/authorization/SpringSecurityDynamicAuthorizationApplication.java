package com.ph.dynamic.authorization;

import com.ph.dynamic.authorization.auth.role.ResourceType;
import com.ph.dynamic.authorization.auth.role.RoleEntity;
import com.ph.dynamic.authorization.auth.role.RoleType;
import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.entities.UserEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import com.ph.dynamic.authorization.repository.RoleRepository;
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
    CommandLineRunner commandLineRunner(UserRepository userRepository, CompanyRepository companyRepository, RoleRepository roleRepository) {
        return args -> {
            var sysAdmin = new UserEntity();
            sysAdmin.setEmail("admin");
            sysAdmin.setPassword("password");

            userRepository.save(sysAdmin);

            var com1 = new CompanyEntity();
            com1.setName("Company 1");
            com1 = companyRepository.save(com1);

            var com2 = new CompanyEntity();
            com2.setName("Company 2");
            com2 = companyRepository.save(com2);

            var adCom1 = new UserEntity();
            adCom1.setEmail("adcom1");
            adCom1.setPassword("password");
            adCom1 = userRepository.save(adCom1);

            var roleForAdCom1 = new RoleEntity();
            roleForAdCom1.setResourceId(com1.getId());
            roleForAdCom1.setUserEntity(adCom1);
            roleForAdCom1.setRoleType(RoleType.COMPANY_DELETE);
            roleForAdCom1.setResourceType(ResourceType.COMPANY);
            roleRepository.save(roleForAdCom1);


            var adCom2 = new UserEntity();
            adCom2.setEmail("adcom2");
            adCom2.setPassword("password");
            adCom2 = userRepository.save(adCom2);

            var roleForAdCom2 = new RoleEntity();
            roleForAdCom2.setResourceId(com2.getId());
            roleForAdCom2.setUserEntity(adCom2);
            roleForAdCom2.setRoleType(RoleType.COMPANY_DELETE);
            roleForAdCom2.setResourceType(ResourceType.COMPANY);
            roleRepository.save(roleForAdCom2);
        };
    }
}
