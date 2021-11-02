package dev.j3c.sofkau.cleanarch.application.usecase;

import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;
import dev.j3c.sofkau.cleanarch.domain.generic.EventStoreRepository;
import dev.j3c.sofkau.cleanarch.domain.generic.StoredEvent;
import dev.j3c.sofkau.cleanarch.domain.program.Bill;
import dev.j3c.sofkau.cleanarch.domain.program.command.GenerateBillCommand;

import java.util.List;
import java.util.function.Function;

public class GenerateBillUseCase implements Function<GenerateBillCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(GenerateBillCommand command) {
        Bill bill = new Bill(command.getBillId(),
                command.getCustomerId(),
                command.getCustomerName(),
                command.getCustomerPhoneNumber());
        return bill.getUncommittedChanges();
    }

}
