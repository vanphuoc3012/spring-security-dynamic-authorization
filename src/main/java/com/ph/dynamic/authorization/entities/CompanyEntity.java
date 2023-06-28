package com.ph.dynamic.authorization.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad_company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "companyEntity")
    private List<StoreEntity> storeEntityList;

}
