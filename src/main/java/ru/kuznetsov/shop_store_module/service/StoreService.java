package ru.kuznetsov.shop_store_module.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop_store_module.dto.StoreDto;
import ru.kuznetsov.shop_store_module.mapper.StoreMapper;
import ru.kuznetsov.shop_store_module.model.Store;
import ru.kuznetsov.shop_store_module.repository.StoreRepository;

@Service
public class StoreService extends AbstractService<Store, StoreDto, StoreRepository, StoreMapper> {
    protected StoreService(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    public Store findByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }
}
