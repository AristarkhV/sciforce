package com.sciforce.test.sciforce.service.impl;

import com.sciforce.test.sciforce.model.Product;
import com.sciforce.test.sciforce.model.ProductAmountStock;
import com.sciforce.test.sciforce.model.Stock;
import com.sciforce.test.sciforce.repository.StockRepository;
import com.sciforce.test.sciforce.service.ProductAmountStockService;
import com.sciforce.test.sciforce.service.ProductService;
import com.sciforce.test.sciforce.service.StockService;
import dto.ProductAmountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;
    private ProductService productService;
    private ProductAmountStockService productAmountService;
    private final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    public StockServiceImpl(StockRepository stockRepository,
                            ProductService productService,
                            ProductAmountStockService productAmountService) {
        this.stockRepository = stockRepository;
        this.productService = productService;
        this.productAmountService = productAmountService;
    }

    @Override
    @Transactional
    public void createStock(List<ProductAmountDTO> products, String name) {

        Stock stock = new Stock(name);
        stockRepository.save(stock);
        logger.info(stock + " is added to DB");

        List<ProductAmountStock> stockProducts = new ArrayList<>();
        if(!products.isEmpty()) {
            products.stream().forEachOrdered(productDTO -> {
                Product product = new Product(productDTO.getProductUuid(),
                        productDTO.getProductName());
                Optional<Product> productDB = productService.getProductByProductUuid(productDTO.getProductUuid());
                if (!productDB.isPresent()) {
                    productService.save(product);
                } else {
                    product.setProduct_id(productDB.get().getProduct_id());
                }
                ProductAmountStock productAmount = new ProductAmountStock(product, stock, productDTO.getAmount());
                stockProducts.add(productAmount);
                productAmountService.save(productAmount);
            });
        }else {
            logger.warn(name + " is empty!");
        }
    }
}
