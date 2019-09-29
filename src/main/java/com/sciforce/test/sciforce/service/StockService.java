package com.sciforce.test.sciforce.service;

import dto.ProductAmountDTO;

import java.util.List;

public interface StockService {

    void createStock(List<ProductAmountDTO> sourceResponse, String name);
}
