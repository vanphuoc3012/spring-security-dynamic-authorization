package com.ph.dynamic.authorization.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad_store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String token;
    private String storeHash;
    private String domain;
    private String showStatus;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private CompanyEntity companyEntity;

    @ManyToMany
    @JsonIgnore
    private List<MenuEntity> menuEntityList;
    private String status;

    @OneToMany(mappedBy = "storeEntity")
    @JsonIgnore
    private List<GroupEntity> groupEntityList;
}
