package dev.j3c.sofkau.cleanarch.infrastructure.handle;

import dev.j3c.sofkau.cleanarch.application.usecase.GenerateBillUseCase;
import dev.j3c.sofkau.cleanarch.domain.bill.command.GenerateBillCommand;
import dev.j3c.sofkau.cleanarch.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateProgramUseCaseHandle extends UseCaseHandle {

    private final GenerateBillUseCase generateBillUseCase;

    public CreateProgramUseCaseHandle(GenerateBillUseCase generateBillUseCase) {
        this.generateBillUseCase = generateBillUseCase;
    }

    @ConsumeEvent(value="sofkau.bill.generatebill", blocking=true)
    void consumeBlocking(GenerateBillCommand command) {
        System.out.println("Generate handle");
        var events = generateBillUseCase.apply(command);
        saveBill(command.getBillId(), events);
    }
}