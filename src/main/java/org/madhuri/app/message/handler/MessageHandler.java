package org.madhuri.app.message.handler;

import java.util.List;
import org.madhuri.app.message.model.Message;
import org.madhuri.app.message.service.MessageService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MessageHandler {

    private MessageService messageService=new MessageService();

    @GET
    @Path("/all")
    public List<Message> getMessages() {
        List<Message> messages = messageService.getAllMessages();
        return messages;
    }
    

    /*
    @POST
    @Path("/add")
    public Message addMessage(Message msg)
    {
    	return messageService.addMessage(msg);
    }
    */
    @POST
    @Path("/add")
    public Message addMessage(Message msg) {
        try {
            return messageService.addMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding message.");
        }
    }

}


