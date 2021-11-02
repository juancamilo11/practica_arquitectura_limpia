package dev.j3c.sofkau.cleanarch.domain.program;

import java.util.Objects;

public class Customer {

    private String id;
    private String name;
    private String phoneNumber;

    public Customer(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

}
