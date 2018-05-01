/**
 * 
 */
package org.binal.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import org.binal.javabrains.messanger.model.Message;

/**
 * @author Binal
 *
 */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Message response = client
				.target("http://localhost:8080/messanger/webapi/messages/2")
				.queryParam("year", 2015).request()
				.get(new GenericType<Message>() {
				});
		System.out.println(response.toString());

	}

}
