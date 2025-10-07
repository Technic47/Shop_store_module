package ru.kuznetsov.shop_store_module.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop_store_module.model.Stock;

import java.util.List;

@Repository
public interface StockRepository extends AbstractRepository<Stock> {

    List<Stock> findAllByProductId(Long productId);

    List<Stock> findAllByStoreId(Long storeId);
}
