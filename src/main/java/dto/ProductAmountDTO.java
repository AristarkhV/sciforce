package dto;

import java.util.Objects;

public class ProductAmountDTO {

    private String productUuid;
    private String productName;
    private Integer amount;

    public ProductAmountDTO(String productUuid, String productName, Integer amount) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.amount = amount;
    }

    public ProductAmountDTO() {
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
        ProductAmountDTO that = (ProductAmountDTO) o;
        return Objects.equals(productUuid, that.productUuid) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productUuid, productName, amount);
    }

    @Override
    public String toString() {
        return "ProductAmountDTO{" +
                ", productUuid='" + productUuid + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
