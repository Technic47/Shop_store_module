package ru.kuznetsov.shop_store_module.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop_store_module.dto.StockDto;
import ru.kuznetsov.shop_store_module.mapper.StockMapper;
import ru.kuznetsov.shop_store_module.model.Stock;
import ru.kuznetsov.shop_store_module.repository.StockRepository;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }
}
