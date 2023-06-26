package com.ph.dynamic.authorization.entities;

import lombok.Data;

@Data
public class MenuEntity {
    private String id;
    private String name;
    private String order;
    private String url;
    private String parent;
    private String level;
    private char line;
}
