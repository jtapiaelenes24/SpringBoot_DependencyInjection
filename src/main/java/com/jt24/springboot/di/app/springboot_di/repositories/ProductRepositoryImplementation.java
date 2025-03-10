package com.jt24.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.jt24.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryImplementation implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImplementation() {
        this.data = Arrays.asList(
                new Product(1L, "CocaCola", 2L),
                new Product(2L, "Fanta", 3L),
                new Product(3L, "Sprite", 3L),
                new Product(4L, "SevenUp", 2L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
