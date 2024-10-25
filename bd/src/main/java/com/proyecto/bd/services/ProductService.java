package com.proyecto.bd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Product;
import com.proyecto.bd.repository.ProductRepository;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
