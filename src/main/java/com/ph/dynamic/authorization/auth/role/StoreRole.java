package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.role.type.StoreRoleType;
import com.ph.dynamic.authorization.entities.StoreEntity;
import com.ph.dynamic.authorization.entities.UserEntity;

import javax.persistence.*;

@Entity
public class StoreRole {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    private StoreEntity storeEntity;
    @Enumerated(EnumType.STRING)
    private StoreRoleType type;
}
