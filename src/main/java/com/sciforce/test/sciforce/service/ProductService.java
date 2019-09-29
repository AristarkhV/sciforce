package com.sciforce.test.sciforce.service;

import com.sciforce.test.sciforce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void save(Product product);

    Optional<Product> getProductByProductUuid(String uuid);

    List<Product> findAll();
}
