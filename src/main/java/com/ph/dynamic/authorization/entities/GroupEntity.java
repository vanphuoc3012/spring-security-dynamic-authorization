package com.ph.dynamic.authorization.entities;

import lombok.Data;

@Data
public class GroupEntity {
    private String id;
    private String name;
    private char status;
    private String storeId;
}
