package com.jt24.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jt24.springboot.di.app.springboot_di.models.Product;
import com.jt24.springboot.di.app.springboot_di.repositories.ProductRepositoryImplementation;

public class ProductServiceImplementation implements ProductService {

    private ProductRepositoryImplementation respository = new ProductRepositoryImplementation();

    @Override
    public List<Product> findAll() {
        return respository.findAll().stream().map(p -> {
            Double taxPrice = p.getPrice() * 2.25d;
            // Product newProduct = new Product(p.getId(), p.getName(),
            // taxPrice.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(taxPrice.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return respository.findById(id);
    }
}
