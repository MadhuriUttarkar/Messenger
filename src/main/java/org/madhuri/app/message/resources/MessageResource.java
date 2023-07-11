package org.madhuri.app.message.resources;

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
import org.madhuri.app.message.resources.beans.MessageFilterBean;
import org.madhuri.app.message.service.MessageService;
@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Msg> getMessages(@BeanParam MessageFilterBean filterBean)
	{
		if(filterBean.getYear()>0)
		{
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart()>=0 && filterBean.getSize()>=0)
		{
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Msg message,@Context UriInfo uriInfo)
	{
		//System.out.println(uriInfo.getAbsolutePath());
		Msg newMessage=messageService.addMessage(message);
		String newId=String.valueOf(newMessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
		.entity(newMessage)
		.build();
		//return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Msg updateMessage(@PathParam("messageId")long id,Msg message)
	{
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")long id)
	{
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Msg getMessage(@PathParam("messageId")long messageId,@Context UriInfo uriInfo)
	{
		Msg message=messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo,message),"self");
		message.addLink(getUriForProfile(uriInfo,message),"profile");
		message.addLink(getUriForComments(uriInfo,message),"comments");
		return message;
		
	}
	private String getUriForComments(UriInfo uriInfo, Msg message) {
		URI uri=uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class,"getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build();
		return uri.toString();
	}
	private String getUriForProfile(UriInfo uriInfo, Msg message) {
		URI uri=uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor())
				.build();
		return uri.toString();
	}
	private String getUriForSelf(UriInfo uriInfo, Msg message) {
		String uri=uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId()))
				.build()
				.toString();
		return uri;
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
