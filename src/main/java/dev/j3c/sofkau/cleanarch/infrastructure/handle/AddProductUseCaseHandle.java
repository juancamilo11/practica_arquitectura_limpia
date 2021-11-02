package dev.j3c.sofkau.cleanarch.infrastructure.handle;

import dev.j3c.sofkau.cleanarch.application.usecase.AddProductUseCase;
import dev.j3c.sofkau.cleanarch.domain.bill.command.AddProductCommand;
import dev.j3c.sofkau.cleanarch.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AddProductUseCaseHandle extends UseCaseHandle {

    private final AddProductUseCase addProductUseCase;

    public AddProductUseCaseHandle(AddProductUseCase addProductUseCase) {
        this.addProductUseCase = addProductUseCase;
    }

    @ConsumeEvent(value="sofkau.bill.productadded", blocking=true)
    void consumeBlocking(AddProductCommand command) {
        var events = addProductUseCase.apply(command);
        saveBill(command.getBillId(), events);
    }


}