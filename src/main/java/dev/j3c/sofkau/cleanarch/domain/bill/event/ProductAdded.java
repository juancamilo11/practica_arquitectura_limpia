package dev.j3c.sofkau.cleanarch.domain.bill.event;

import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;

public class ProductAdded extends DomainEvent {

    private String productId;
    private String productName;
    private Double productPrice;

    public ProductAdded(String productId, String productName, Double productPrice) {
        super("sofkau.bill.productadded");
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}
