package com.sciforce.test.sciforce.service.impl;

import com.sciforce.test.sciforce.model.Product;
import com.sciforce.test.sciforce.model.ProductAmountStock;
import com.sciforce.test.sciforce.repository.ProductAmountStockRepository;
import com.sciforce.test.sciforce.service.ProductAmountStockService;
import com.sciforce.test.sciforce.service.ProductService;
import com.sciforce.test.sciforce.dto.ProductAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductAmountStockServiceImpl implements ProductAmountStockService {

    private final ProductAmountStockRepository productAmountRepository;
    private ProductService productService;
    private int currentAmount;

    @Autowired
    public ProductAmountStockServiceImpl(ProductAmountStockRepository productRepository,
                                         ProductService productService) {
        this.productAmountRepository = productRepository;
        this.productService = productService;
    }

    @Override
    public void save(ProductAmountStock productAmount) {
        productAmountRepository.save(productAmount);
    }

    @Override
    public List<ProductAmountDTO> getAllDTO() {

        List<ProductAmountDTO> productAmountDTOList = new ArrayList<>();
        List<Product> products = productService.findAll();

        products.stream().forEach(product -> {
            List<ProductAmountStock> productAmountStockList = productAmountRepository
                                                                .findAllByProduct_ProductUuid(product.getProductUuid());
            currentAmount = 0;
            productAmountStockList.forEach(productAmountStock -> currentAmount += productAmountStock.getAmount());
            productAmountDTOList.add(new ProductAmountDTO(product.getProductUuid(),
                                                          product.getProductName(),
                                                          currentAmount));
        });
        return productAmountDTOList;
    }
}
