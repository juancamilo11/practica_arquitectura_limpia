package dev.j3c.sofkau.cleanarch.application.usecase;

import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;
import dev.j3c.sofkau.cleanarch.domain.generic.EventStoreRepository;
import dev.j3c.sofkau.cleanarch.domain.bill.Bill;
import dev.j3c.sofkau.cleanarch.domain.bill.command.AddProductCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddProductUseCase implements Function<AddProductCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddProductUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddProductCommand command) {
        Bill bill = Bill.from(command.getBillId(), repository.getEventsBy("bill", command.getBillId()));
        bill.addProduct(command.getProductId(),
                command.getProductName(),
                command.getProductPrice());
        return bill.getUncommittedChanges();
    }

}
