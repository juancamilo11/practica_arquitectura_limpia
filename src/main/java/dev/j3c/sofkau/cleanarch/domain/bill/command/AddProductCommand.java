package dev.j3c.sofkau.cleanarch.domain.bill.command;

import dev.j3c.sofkau.cleanarch.domain.generic.Command;

public class AddProductCommand extends Command {

    private String billId;
    private String productId;
    private String productName;
    private Double productPrice;

    public AddProductCommand() {
    }

    public AddProductCommand(String billId, String productId, String productName, Double productPrice) {
        this.billId = billId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
