package ru.kuznetsov.shop_store_module.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop_store_module.dto.AddressDto;
import ru.kuznetsov.shop_store_module.mapper.AddressMapper;
import ru.kuznetsov.shop_store_module.model.Address;
import ru.kuznetsov.shop_store_module.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {
    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }
}
