package ru.kuznetsov.shop_store_module.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop_store_module.model.Product;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {
}
