package ru.kuznetsov.shop_store_module.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop_store_module.dto.AddressDto;
import ru.kuznetsov.shop_store_module.model.Address;

@Mapper(componentModel = "spring")
public abstract class AddressMapper implements AbstractMapper<Address, AddressDto> {
}
