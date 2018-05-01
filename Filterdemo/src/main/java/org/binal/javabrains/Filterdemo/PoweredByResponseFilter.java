/**
 * 
 */
package org.binal.javabrains.Filterdemo;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author Binal
 *
 */
@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		//run this project as run on server and hit http://localhost:8080/Filterdemo/webapi/myresource
		//and check response header
		responseContext.getHeaders().add("X-powered by", "Java brains");
	}

}
