/**
 * 
 */
package org.binal.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.binal.javabrains.messanger.model.Message;

/**
 * @author Binal
 *
 */
public class RestApiClient {

	// run this class as java application and not as run on server as this is a
	// client class with main method
	// run messanger project as run on server as it will act as server for this
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Response response = client
				.target("http://localhost:8080/messanger/webapi/messages/1")
				.request().get();
		Message message = response.readEntity(Message.class);

		// OR you can write as below.
		// the below code was giving 406 not acceptable exception when i wrote
		// .request(MediaType.Application_JSON), but after removing mediaType it
		// worked fine
		Message message4 = client
				.target("http://localhost:8080/messanger/webapi/messages/1")
				.request().get(Message.class);
		System.out.println(message4.getMessage());

		System.out.println(message.getMessage());

		// OR
		WebTarget webTarget = client
				.target("http://localhost:8080/messanger/webapi");
		WebTarget messageTarget = webTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		Response response2 = singleMessageTarget
				.resolveTemplate("messageId", "2").request().get();
		Message message2 = response2.readEntity(Message.class);
		System.out.println(message2.getMessage());

		// post request
		// TODO:the below method is not working

		/*
		 * Message newMessage = new Message(); newMessage.setAuthor("binal");
		 * //newMessage.setCreated(new Date());
		 * newMessage.setMessage("new message from jersey"); Response
		 * postResponse = messageTarget.request().post(
		 * Entity.json(newMessage));
		 * System.out.println(postResponse.readEntity(Message
		 * .class).getMessage());
		 */

	}

}
