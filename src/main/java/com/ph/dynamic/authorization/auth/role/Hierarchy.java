package com.ph.dynamic.authorization.auth.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Hierarchy {
    SYSTEM("", "Madive System admin"),
    COMPANY("", "Company"),
    STORE("", "Store table");

    private String tableName;
    private String description;

}
