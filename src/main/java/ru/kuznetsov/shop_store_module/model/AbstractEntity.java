package ru.kuznetsov.shop_store_module.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "created")
    protected LocalDateTime created;
    @Column(name = "updated")
    protected LocalDateTime updated;
}
