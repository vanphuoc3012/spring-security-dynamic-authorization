package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.role.type.SystemRoleType;
import com.ph.dynamic.authorization.entities.UserEntity;

import javax.persistence.*;

@Entity
public class SystemRole {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private SystemRoleType type;
}
