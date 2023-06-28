package com.ph.dynamic.authorization.entities;

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
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private String order;
    private String url;
    private String parent;
    private String level;
    private char line;

    @ManyToMany
    private List<StoreEntity> storeEntityList;


}
