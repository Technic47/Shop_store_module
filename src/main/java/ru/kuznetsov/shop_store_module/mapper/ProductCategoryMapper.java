package ru.kuznetsov.shop_store_module.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop_store_module.dto.ProductCategoryDto;
import ru.kuznetsov.shop_store_module.model.ProductCategory;

@Mapper(componentModel = "spring")
public abstract class ProductCategoryMapper implements AbstractMapper<ProductCategory, ProductCategoryDto> {
}
