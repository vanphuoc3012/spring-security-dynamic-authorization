package com.ph.dynamic.authorization.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private UserType type;
    private String requireChangePassword;
    private String errCount;
    private String status;

    public enum UserType {
        MBO, APO, MFO
    }
}
