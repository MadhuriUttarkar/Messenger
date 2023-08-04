package org.madhuri.app.message.handler;

import org.madhuri.app.message.service.GroupService;
import java.util.List;
import org.madhuri.app.message.model.MessageGroup;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupHandler {
	
	
	private GroupService groupService = new GroupService();
	
	@GET
    @Path("/all")
    public List<MessageGroup> getGroupMessages() {
        return groupService.getGroups();
    } 
    
}

