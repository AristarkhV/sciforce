package com.sciforce.test.sciforce.service.impl;

import com.sciforce.test.sciforce.model.Product;
import com.sciforce.test.sciforce.repository.ProductRepository;
import com.sciforce.test.sciforce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductByProductUuid(String uuid) {
        return productRepository.getProductByProductUuid(uuid);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
