package com.sciforce.test.sciforce.service;

import com.sciforce.test.sciforce.model.ProductAmountStock;
import dto.ProductAmountDTO;

import java.util.List;

public interface ProductAmountStockService {

    void save(ProductAmountStock productAmount);

    List<ProductAmountDTO> getAllDTO();
}
