package org.binal.javabrains.ResourceLifecycle;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Singleton
public class MyResource {
	private int count;
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
		count=count+1;
        return "The method is called "+count+" times.";
    }
}
