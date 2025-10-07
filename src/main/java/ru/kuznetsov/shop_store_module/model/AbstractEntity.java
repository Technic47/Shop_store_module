package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "created")
    protected Date created;
    @Column(name = "updated")
    protected Date updated;
}
