package org.madhuri.app.message.handler;

import java.util.List;

import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.ChannelUser;
import org.madhuri.app.message.model.User;
import org.madhuri.app.message.service.ChannelService;
import org.madhuri.app.message.service.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserHandler {

	private UserService userService = new UserService();
	private ChannelService channelService = new ChannelService();

	@GET
	@Path("/all")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@POST
	@Path("/add-to-channel")
	public Response addUserToChannel(ChannelUser channelUser) {
		User user = userService.getUser(channelUser.getUserId());
		Channel channel = channelService.getChannel(channelUser.getChannelId());

		if (user == null || channel == null) {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"User or channel not found\"}")
					.type(MediaType.APPLICATION_JSON).build();
		}

		channel.addUser(user);
		channelService.updateChannel(channel);

		return Response.ok().entity("{\"message\": \"User added to channel successfully\"}")
				.type(MediaType.APPLICATION_JSON).build();
	}

}
