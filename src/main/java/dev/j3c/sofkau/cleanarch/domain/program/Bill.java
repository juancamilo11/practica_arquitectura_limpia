package dev.j3c.sofkau.cleanarch.domain.program;

import dev.j3c.sofkau.cleanarch.domain.generic.AggregateRoot;
import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;
import dev.j3c.sofkau.cleanarch.domain.generic.EventChange;
import dev.j3c.sofkau.cleanarch.domain.program.event.BillGenerated;
import dev.j3c.sofkau.cleanarch.domain.program.event.ProductAdded;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bill extends AggregateRoot implements EventChange {

    private Customer customer;
    private LocalDate generationDate;
    private Map<String, Product> products;
    private Double totalPrice;

    public Bill(String billId, String customerId, String customerName, String customerPhoneNumber) {
        super(billId);
        appendChange(new BillGenerated(customerId, customerName, customerPhoneNumber)).apply();
    }

    private Bill(String billId){
        super(billId);
        subscribe(this);

        listener((BillGenerated event)-> {
            this.customer = new Customer(event.customerId(),
                    event.customerName(),
                    event.customerPhoneNumber());
            this.generationDate = LocalDate.now();
            this.products = new HashMap<>();
            this.totalPrice = 0.0;
        });

        listener((ProductAdded event) -> products.put(event.getProductId(),
                new Product(event.getProductId(),
                        event.getProductName(),
                        event.getProductPrice())));
    }

    public static Bill from(String billId, List<DomainEvent> events){
        var bill = new Bill(billId);
        events.forEach(bill::applyEvent);
        return bill;
    }

    public void addProduct(String productId, String name, Double price){
        appendChange(new ProductAdded(productId, name, price)).apply();
    }

}
