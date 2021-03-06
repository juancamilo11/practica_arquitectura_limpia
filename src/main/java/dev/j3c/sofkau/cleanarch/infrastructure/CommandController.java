package dev.j3c.sofkau.cleanarch.infrastructure;

import dev.j3c.sofkau.cleanarch.domain.bill.command.AddProductCommand;
import dev.j3c.sofkau.cleanarch.domain.bill.command.GenerateBillCommand;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class CommandController {

    private final MessageService messageService;

    public CommandController(MessageService messageService){
        this.messageService = messageService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createBill")
    public Response executor(GenerateBillCommand command) {
        System.out.println("controller");
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addProduct")
    public Response executor(AddProductCommand command) {
        System.out.println("controller");
        messageService.send(command);
        return Response.ok().build();
    }

}
