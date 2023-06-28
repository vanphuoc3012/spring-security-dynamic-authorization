package com.ph.dynamic.authorization.entities;

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
@Table(name = "ad_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    private String name;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private String requireChangePassword;
    private String errCount;
    private String status;

    public enum UserType {
        MBO, APO
    }
}
