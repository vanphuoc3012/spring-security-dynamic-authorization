package com.ph.dynamic.authorization.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "companyEntity")
    private List<StoreEntity> storeEntityList;
}
