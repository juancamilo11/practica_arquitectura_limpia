package dev.j3c.sofkau.cleanarch.application.usecase;

import dev.j3c.sofkau.cleanarch.domain.generic.DomainEvent;
import dev.j3c.sofkau.cleanarch.domain.bill.Bill;
import dev.j3c.sofkau.cleanarch.domain.bill.command.GenerateBillCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class GenerateBillUseCase implements Function<GenerateBillCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(GenerateBillCommand command) {
        System.out.println("use case apply");
        Bill bill = new Bill(command.getBillId(),
                command.getCustomerId(),
                command.getCustomerName(),
                command.getCustomerPhoneNumber());
        return bill.getUncommittedChanges();
    }

}
