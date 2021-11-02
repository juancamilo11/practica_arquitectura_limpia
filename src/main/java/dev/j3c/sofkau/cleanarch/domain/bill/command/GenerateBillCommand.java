package dev.j3c.sofkau.cleanarch.domain.bill.command;

import dev.j3c.sofkau.cleanarch.domain.generic.Command;

public class GenerateBillCommand extends Command {

    private String billId;
    private String customerId;
    private String customerName;
    private String customerPhoneNumber;

    public GenerateBillCommand() {
    }

    public GenerateBillCommand(String billId, String customerId, String customerName, String customerPhoneNumber) {
        this.billId = billId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
