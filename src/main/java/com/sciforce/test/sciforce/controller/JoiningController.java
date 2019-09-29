package com.sciforce.test.sciforce.controller;

import com.sciforce.test.sciforce.service.ProductAmountStockService;
import com.sciforce.test.sciforce.service.StockService;
import com.sciforce.test.sciforce.utils.ReadJsonFromFileUtil;
import com.sciforce.test.sciforce.utils.ReadJsonFromURLUtil;
import com.sciforce.test.sciforce.dto.ProductAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoiningController {

    private StockService stockService;
    private ProductAmountStockService productAmountStockService;

    @Autowired
    public JoiningController(StockService stockService,
                             ProductAmountStockService productAmountStockService) {
        this.stockService = stockService;
        this.productAmountStockService = productAmountStockService;
    }

    @GetMapping(path = {"/get"})
    public List<ProductAmountDTO> getProductsList(@RequestParam String url,
                                                  @RequestParam String path) {

        List<ProductAmountDTO> remoteProducts;
        List<ProductAmountDTO> localProducts;

        ReadJsonFromURLUtil urlHandler = new ReadJsonFromURLUtil();
        remoteProducts = urlHandler.getProductAmountDTOListFromURL(url);
        stockService.createStock(remoteProducts, url);

        ReadJsonFromFileUtil fileHandler = new ReadJsonFromFileUtil();
        localProducts = fileHandler.getProductAmountDTOListFromFile(path);
        stockService.createStock(localProducts, path);

        return productAmountStockService.getAllDTO();
    }
}
