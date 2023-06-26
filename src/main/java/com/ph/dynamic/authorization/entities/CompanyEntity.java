package com.ph.dynamic.authorization.entities;

import lombok.Data;

import java.util.Date;

@Data
public class CompanyEntity {
    private String id;
    private String name;
    private String contractHolder;
    private String email;
    private String phone;
    private String clientId;
    private String secretKey;
    private String domain;
    private Date contractStartDate;
    private Date contractEndDate;
    private char status;
}
