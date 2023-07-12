package org.madhuri.app.message.handler;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)

public class InjectDemo {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param")String matrixParam,
			@HeaderParam("customHeaderValue")String header,
			@CookieParam("name")String cookie)
	{
		return "Matrix param:" +matrixParam + "HeaderParam:" +header +"Cookie" +cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "path: " + path + "Cookies" +cookies;
	}
}
