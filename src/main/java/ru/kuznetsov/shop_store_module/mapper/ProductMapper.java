package ru.kuznetsov.shop_store_module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop_store_module.dto.ProductDto;
import ru.kuznetsov.shop_store_module.model.Product;
import ru.kuznetsov.shop_store_module.model.ProductCategory;
import ru.kuznetsov.shop_store_module.service.ProductCategoryService;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Autowired
    protected ProductCategoryService productCategoryService;

    @Override
    @Mapping(target = "category", source = "entity.category.name")
    public abstract ProductDto entityToDto(Product entity);

    @Override
    @Mapping(target = "category", source = "category", qualifiedByName = "nameToEntity")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("nameToEntity")
    protected ProductCategory entityToEntity(String name) {
        return productCategoryService.findByName(name);
    }
}
