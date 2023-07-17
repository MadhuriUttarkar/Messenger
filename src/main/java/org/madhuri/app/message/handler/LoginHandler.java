package org.madhuri.app.message.handler;

import java.util.Optional;

import org.madhuri.app.message.dao.ProfileDAO;
import org.madhuri.app.message.model.Profile;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class LoginHandler {

    private ProfileDAO profileDAO;

    public LoginHandler() {
        this.profileDAO = new ProfileDAO();
    }

    @POST
    public Response login(Profile profile) {
        Optional<Profile> foundProfile = profileDAO.findByUsername(profile.getUsername());

        if (foundProfile.isPresent()) {
            if (foundProfile.get().getPassword().equals(profile.getPassword())) {
            	System.out.println("Profile found");
                return Response.ok(foundProfile).build();
            } else {
            	System.out.println("unauthorized user");
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
        	System.out.println("profile not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}