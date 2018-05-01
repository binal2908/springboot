/**
 * 
 */
package org.binal.javabrains.Filterdemo;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

/**
 * @author Binal
 *
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secure ";

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {

		// here we want that only method of securedResource pass through this
		// filter.For others this filter should not get executed.
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeaders = requestContext.getHeaders().get(
					AUTH_HEADER_KEY);
			if (authHeaders != null && authHeaders.size() > 0) {
				String authHeader = authHeaders.get(0);
				authHeader = authHeader.replaceFirst(AUTH_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authHeader);
				StringTokenizer tokenizer = new StringTokenizer(decodedString,
						":");
				String userName = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if ("user".equals(userName) && "password".equals(password)) {
					// here if the condition gets satisfied it will return from
					// here
					// and normal flow will be executed
					return;
				}
			}
			Response response = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User can not access the resource").build();
			requestContext.abortWith(response);
		}

	}

}
