package ru.kuznetsov.shop_store_module.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop_store_module.dto.ProductCategoryDto;
import ru.kuznetsov.shop_store_module.mapper.ProductCategoryMapper;
import ru.kuznetsov.shop_store_module.model.ProductCategory;
import ru.kuznetsov.shop_store_module.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService extends AbstractService<ProductCategory, ProductCategoryDto, ProductCategoryRepository, ProductCategoryMapper> {
    protected ProductCategoryService(ProductCategoryRepository repository, ProductCategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Cacheable(value = "PRODUCT_CATEGORY_CACHE")
    public ProductCategoryDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict(value = "PRODUCT_CATEGORY_CACHE")
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public ProductCategory findByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }
}
