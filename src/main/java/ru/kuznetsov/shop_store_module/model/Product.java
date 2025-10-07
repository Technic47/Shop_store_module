package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
}
