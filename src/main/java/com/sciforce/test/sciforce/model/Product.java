package com.sciforce.test.sciforce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "productUuid")
    private String productUuid;

    @Column(name = "productName")
    private String productName;

    public Product() {
    }

    public Product(String productUuid, String productName) {
        this.productUuid = productUuid;
        this.productName = productName;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id) &&
                Objects.equals(productUuid, product.productUuid) &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, productUuid, productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", productUuid='" + productUuid + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
