package org.madhuri.app.message.handler;

import java.util.Date;
import java.util.List;
import org.madhuri.app.message.model.ChannelUser;
import org.madhuri.app.message.model.User;
import org.madhuri.app.message.service.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
	

	@GET
	@Path("/all")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@POST
	@Path("/create")
	public User createUser(User newUser) {
		
		return userService.createUser(newUser);
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteChannel(@PathParam("id") long id) {
		userService.deleteUser(id);
	}

	@PUT
	@Path("/update/{id}")
	public User updateUser(@PathParam("id") long id, User updatedUser) {
		User existingUser = userService.getUserById(id);

		if (existingUser != null) {
			existingUser.setName(updatedUser.getName());

			// Set updatedAt to the latest date
			existingUser.setUpdatedAt(new Date());

			return userService.updateUser(id, existingUser);
		}

		throw new NotFoundException("User not found with id: " + id);

	}

	@POST
	@Path("/add-to-channel")
	public Response addUserToChannel(ChannelUser channelUser) {
	    try {
	        Long userId = channelUser.getUserId();
	        Long channelId = channelUser.getChannelId();

	     // Assuming UserService manages transactions and database operations
            User addedUser = userService.addUserToChannel(userId, channelId);

            if (addedUser != null) {
                return Response.status(Response.Status.OK)
                        .entity(channelUser)  
                        .build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("User or channel not found")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add user to channel: " + e.getMessage())
                    .build();
        }
    }

	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") long id) {
		return userService.getUserById(id);
	}
}
