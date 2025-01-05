package org.jahan.apitest.messenger.resources;

import java.util.List;

import org.jahan.apitest.messenger.model.Message;
import org.jahan.apitest.messenger.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService massageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return massageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message messgae) {
		return massageService.addMessage(messgae);
	}
	

	
	@GET
	@Path("/{messagesId}")
	public Message getMessage(@PathParam("messagesId") long id) {
		 return massageService.getMessage(id);
	}
	
	
	@PUT
	@Path("/{messagesId}")
	public Message updateMessage(@PathParam("messagesId") long id, Message messgae) {
		messgae.setId(id);
		return massageService.updateMessage(messgae);
	}
	
	@DELETE
	@Path("/{messagesId}")
	public void deleteMessage(@PathParam("messagesId") long id) {
		massageService.removeMessage(id);
	}

}
