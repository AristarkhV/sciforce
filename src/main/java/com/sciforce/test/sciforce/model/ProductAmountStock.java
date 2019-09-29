package com.sciforce.test.sciforce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Product_amount_stock")
public class ProductAmountStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_amount_id")
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "amount")
    private Integer amount;

    public ProductAmountStock(Product product, Stock stock, Integer amount) {
        this.product = product;
        this.stock = stock;
        this.amount = amount;
    }

    public ProductAmountStock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAmountStock that = (ProductAmountStock) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, stock, amount);
    }

    @Override
    public String toString() {
        return "ProductAmountStock{" +
                "id=" + id +
                ", product=" + product +
                ", stock=" + stock +
                ", amount=" + amount +
                '}';
    }
}
