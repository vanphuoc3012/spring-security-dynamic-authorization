package com.ph.dynamic.authorization.entities;

import com.ph.dynamic.authorization.auth.role.CompanyRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private String requireChangePassword;
    private String errCount;
    private String status;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyRole> companyRole;
    public enum UserType {
        MBO, APO
    }
}
