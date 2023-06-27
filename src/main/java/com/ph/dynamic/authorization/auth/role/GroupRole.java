package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.role.type.GroupRoleType;
import com.ph.dynamic.authorization.entities.GroupEntity;
import com.ph.dynamic.authorization.entities.UserEntity;

import javax.persistence.*;

@Entity
public class GroupRole {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private GroupEntity groupEntity;

    @Enumerated(EnumType.STRING)
    private GroupRoleType type;

}
