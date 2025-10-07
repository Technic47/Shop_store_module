package ru.kuznetsov.shop_store_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuznetsov.shop_store_module.dto.ProductDto;
import ru.kuznetsov.shop_store_module.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.findAll();
    }
}
