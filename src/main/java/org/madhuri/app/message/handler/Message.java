package org.madhuri.app.message.handler;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;
import org.madhuri.app.message.model.Msg;
import org.madhuri.app.message.service.MessageService;

@Path("/messages")
public class Message {
	
	MessageService messageService = new MessageService();
	
	
}
