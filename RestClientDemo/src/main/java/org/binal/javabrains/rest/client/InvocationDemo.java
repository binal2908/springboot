/**
 * 
 */
package org.binal.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

/**
 * @author Binal
 *
 */
public class InvocationDemo {

	public static void main(String args[]) {
		InvocationDemo invocationDemo = new InvocationDemo();
		Invocation invocation=invocationDemo.prepareRequestForMessagesByYear(2015);
		Response response=invocation.invoke();
		System.out.println(response.getStatus());
		System.out.println(" "+response.toString());
	}

	public Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();

		return client.target("http://localhost:8080/messanger/webapi/messages")
				.queryParam("year", year).request().buildGet();

	}
}
