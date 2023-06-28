package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private Long resourceId;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
}
