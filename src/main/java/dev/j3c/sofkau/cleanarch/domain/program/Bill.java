package dev.j3c.sofkau.cleanarch.domain.program;

import dev.j3c.sofkau.cleanarch.domain.generic.AggregateRoot;
import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;
import dev.j3c.sofkau.cleanarch.domain.generic.EventChange;
import dev.j3c.sofkau.cleanarch.domain.program.event.BillGenerated;

import java.time.LocalDate;
import java.util.Map;

public class Bill extends AggregateRoot implements EventChange {

    private Customer customer;
    private LocalDate generationDate;
    private Map<String, Product> products;
    private Double TotalPrice;

    protected Bill(String billId, String customerId, String customerName, String customerPhoneNumber) {
        super(billId);
        appendChange(new BillGenerated(customerId, customerName, customerPhoneNumber)).apply();
    }



}
