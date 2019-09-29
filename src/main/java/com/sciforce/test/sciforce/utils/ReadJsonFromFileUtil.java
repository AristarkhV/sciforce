package com.sciforce.test.sciforce.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ProductAmountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadJsonFromFileUtil {

    private List<ProductAmountDTO> products = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(ReadJsonFromFileUtil.class);

    public ReadJsonFromFileUtil() {
    }

    public List<ProductAmountDTO> getProductAmountDTOListFromFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = Arrays.asList(mapper.readValue(new FileReader(path), ProductAmountDTO[].class));
        } catch (FileNotFoundException e) {
            logger.error("Bad path: " + e);
            e.printStackTrace();
            return new ArrayList<>();
        } catch (JsonParseException e) {
            logger.error("Bad json format: " + e);
            e.printStackTrace();
        } catch (JsonMappingException e) {
            logger.error("Mapping exception: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Something wrong :( " + e);
            e.printStackTrace();
        }
        return products;
    }
}
