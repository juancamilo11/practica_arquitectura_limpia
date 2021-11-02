package dev.j3c.sofkau.cleanarch.domain.program.event;

import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;

public class BillGenerated extends DomainEvent {

    private String customerId;
    private String customerName;
    private String customerPhoneNumber;

    public BillGenerated(String customerId, String customerName, String customerPhoneNumber) {
        super("sofkau.bill.billgenerated");
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String customerId() {
        return customerId;
    }

    public String customerName() {
        return customerName;
    }

    public String customerPhoneNumber() {
        return customerPhoneNumber;
    }
}
