package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "store")
public class Store extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
