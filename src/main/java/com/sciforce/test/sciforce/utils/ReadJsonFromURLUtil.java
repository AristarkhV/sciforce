package com.sciforce.test.sciforce.utils;

import com.sciforce.test.sciforce.dto.ProductAmountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReadJsonFromURLUtil {

    private static List<ProductAmountDTO> products = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ReadJsonFromURLUtil.class);

    public ReadJsonFromURLUtil() {
    }

    public static List<ProductAmountDTO> getProductAmountDTOListFromURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductAmountDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                                                          new ParameterizedTypeReference<List<ProductAmountDTO>>() {});
        if (response.getBody() != null) {
            products = response.getBody();
        } else {
            products = new ArrayList<>();
            logger.warn(url + "get empty product list");
        }
        return products;
    }
}
