package org.madhuri.app.message.handler;

import org.madhuri.app.message.model.Profile;
import org.madhuri.app.message.service.LoginService;

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

	private LoginService loginService;

    public LoginHandler() {
        this.loginService = new LoginService();
    }

    @POST
    public Response login(Profile profile) {
        boolean isAuthenticated = loginService.authenticate(profile.getUsername(), profile.getPassword());

        if (isAuthenticated) {
            System.out.println("Authorized user");
            return Response.ok().build();
        } else {
            System.out.println("Unauthorized user");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
