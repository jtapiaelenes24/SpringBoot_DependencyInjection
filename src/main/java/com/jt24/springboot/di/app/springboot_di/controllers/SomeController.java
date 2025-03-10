package com.jt24.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt24.springboot.di.app.springboot_di.models.Product;
import com.jt24.springboot.di.app.springboot_di.services.ProductServiceImplementation;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImplementation service = new ProductServiceImplementation();

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}
