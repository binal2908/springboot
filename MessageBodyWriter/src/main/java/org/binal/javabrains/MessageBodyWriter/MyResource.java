package org.binal.javabrains.MessageBodyWriter;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("test")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getIt() {
		return Calendar.getInstance().getTime();
	}
	
	@GET
	//custom mediaType
	//open below url in chrome (in local browser it does not get opened properly)
	@Produces("text/shrotDate")
	@Path("/custom")
	public Date getIt2() {
		return Calendar.getInstance().getTime();
	}
}
