package com.sciforce.test.sciforce.repository;

import com.sciforce.test.sciforce.model.ProductAmountStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAmountStockRepository extends JpaRepository<ProductAmountStock, Long> {

    List<ProductAmountStock> findAllByProduct_ProductUuid(String uuid);
}
