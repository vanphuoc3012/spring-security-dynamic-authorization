package com.ph.dynamic.authorization;

import com.ph.dynamic.authorization.auth.role.ResourceType;
import com.ph.dynamic.authorization.auth.role.RoleEntity;
import com.ph.dynamic.authorization.auth.role.RoleType;
import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.entities.StoreEntity;
import com.ph.dynamic.authorization.entities.UserEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import com.ph.dynamic.authorization.repository.RoleRepository;
import com.ph.dynamic.authorization.repository.StoreRepository;
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
    CommandLineRunner commandLineRunner(UserRepository userRepository, CompanyRepository companyRepository,
                                        RoleRepository roleRepository, StoreRepository storeRepository) {
        return args -> {
            var sysAdmin = new UserEntity();
            sysAdmin.setEmail("admin");
            sysAdmin.setPassword("password");
            sysAdmin = userRepository.save(sysAdmin);

            var roleForSysAdmin = new RoleEntity();
            roleForSysAdmin.setResourceId(null);
            roleForSysAdmin.setUserEntity(sysAdmin);
            roleForSysAdmin.setRoleType(RoleType.MASTER_ADMIN);
            roleForSysAdmin.setResourceType(ResourceType.ALL);
            roleRepository.save(roleForSysAdmin);

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
            roleForAdCom1.setRoleType(RoleType.COMPANY_FULL_ACCESS);
            roleForAdCom1.setResourceType(ResourceType.COMPANY);
            roleRepository.save(roleForAdCom1);


            var adCom2 = new UserEntity();
            adCom2.setEmail("adcom2");
            adCom2.setPassword("password");
            adCom2 = userRepository.save(adCom2);

            var roleForAdCom2 = new RoleEntity();
            roleForAdCom2.setResourceId(com2.getId());
            roleForAdCom2.setUserEntity(adCom2);
            roleForAdCom2.setRoleType(RoleType.COMPANY_FULL_ACCESS);
            roleForAdCom2.setResourceType(ResourceType.COMPANY);
            roleRepository.save(roleForAdCom2);

            var store1ForCom1 = new StoreEntity();
            store1ForCom1.setCompanyEntity(com1);
            store1ForCom1 = storeRepository.save(store1ForCom1);

            var viewerSt1 = new UserEntity();
            viewerSt1.setEmail("viewerstore1");
            viewerSt1.setPassword("password");
            userRepository.save(viewerSt1);

            var roleViewerSt1 = new RoleEntity();
            roleViewerSt1.setResourceId(store1ForCom1.getId());
            roleViewerSt1.setUserEntity(viewerSt1);
            roleViewerSt1.setRoleType(RoleType.STORE_VIEWER);
            roleViewerSt1.setResourceType(ResourceType.STORE);
            roleRepository.save(roleViewerSt1);

            var store2ForCom2 = new StoreEntity();
            store2ForCom2.setCompanyEntity(com1);
            store2ForCom2 = storeRepository.save(store2ForCom2);

            var viewerSt2 = new UserEntity();
            viewerSt2.setEmail("viewerstore2");
            viewerSt2.setPassword("password");
            userRepository.save(viewerSt2);

            var roleViewerSt2 = new RoleEntity();
            roleViewerSt2.setResourceId(store2ForCom2.getId());
            roleViewerSt2.setUserEntity(viewerSt2);
            roleViewerSt2.setRoleType(RoleType.STORE_VIEWER);
            roleViewerSt2.setResourceType(ResourceType.STORE);
            roleRepository.save(roleViewerSt2);
        };
    }
}
