package ru.kuznetsov.shop_store_module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop_store_module.dto.StoreDto;
import ru.kuznetsov.shop_store_module.model.Address;
import ru.kuznetsov.shop_store_module.model.Store;
import ru.kuznetsov.shop_store_module.service.AddressService;

@Mapper(componentModel = "spring")
public abstract class StoreMapper implements AbstractMapper<Store, StoreDto> {
    @Autowired
    protected AddressService addressService;

    @Override
    @Mapping(target = "addressId", source = "entity.address.id")
    @Mapping(target = "address", source = "entity.address", qualifiedByName = "getAddressString")
    public abstract StoreDto entityToDto(Store entity);

    @Override
    @Mapping(target = "address", source = "dto.addressId", qualifiedByName = "idToAddress")
    public abstract Store dtoToEntity(StoreDto dto);

    @Named("getAddressString")
    protected String getAddressString(Address address) {
        return address.getAddressString();
    }

    @Named("idToAddress")
    protected Address idToAddress(Long id) {
        return addressService.findEntityById(id);
    }
}
