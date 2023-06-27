package com.ph.dynamic.authorization.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private char status;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;
}
