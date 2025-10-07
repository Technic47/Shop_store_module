package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "store")
@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
