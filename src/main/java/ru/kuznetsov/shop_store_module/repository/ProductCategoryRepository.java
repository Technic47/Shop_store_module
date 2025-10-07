package ru.kuznetsov.shop_store_module.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop_store_module.model.ProductCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends AbstractRepository<ProductCategory> {

    Optional<ProductCategory> findByName(String name);
}
