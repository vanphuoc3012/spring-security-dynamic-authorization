package com.ph.dynamic.authorization.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(generator = "uuid")
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
