package com.ph.dynamic.authorization.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String token;
    private String storeHash;
    private String domain;
    private String showStatus;
    private String companyId;
    private String status;
}
