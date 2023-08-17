package org.madhuri.app.message.handler;

import org.madhuri.app.message.service.ChannelService;
import org.madhuri.app.message.service.UserService;

import java.util.List;
import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.ChannelUser;
import org.madhuri.app.message.model.User;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/channels")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChannelHandler {

	private ChannelService channelService = new ChannelService();
	private UserService userService = new UserService();

	@GET
	@Path("/all")
	public List<Channel> getChannelMessages() {
		return channelService.getChannels();
	}

	@POST
	@Path("/create")
	public Channel createChannel(Channel channel) {
		return channelService.createChannel(channel);
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteChannel(@PathParam("id") long id) {
		channelService.deleteChannel(id);
	}

	@PUT
	@Path("/update/{id}")
	public Response updateChannel(@PathParam("id") long id, Channel updatedChannel) {
		Channel existingChannel = channelService.getChannelById(id);
		if (existingChannel == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		updatedChannel.setId(id);

		Channel updated = channelService.updateChannel(updatedChannel);
		return Response.ok(updated).build();
	}

}
