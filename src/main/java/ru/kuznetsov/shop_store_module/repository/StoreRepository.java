package ru.kuznetsov.shop_store_module.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop_store_module.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends AbstractRepository<Store> {

    Optional<Store> findByName(String name);
}
