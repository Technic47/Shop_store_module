package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock extends AbstractEntity {
    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
