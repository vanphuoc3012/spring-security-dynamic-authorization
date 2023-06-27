package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.role.type.CompanyRoleType;
import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.entities.UserEntity;

import javax.persistence.*;

@Entity
public class CompanyRole {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @Enumerated(EnumType.STRING)
    private CompanyRoleType type;
}

