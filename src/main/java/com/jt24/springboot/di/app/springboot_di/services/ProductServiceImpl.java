package com.jt24.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jt24.springboot.di.app.springboot_di.models.Product;
import com.jt24.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${config.price.tax}")
    private Double tax;
    private ProductRepository respository;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository respository) {
        this.respository = respository;
    }

    @Override
    public List<Product> findAll() {
        return respository.findAll().stream().map(p -> {
            Double taxPrice = p.getPrice() * tax;

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
