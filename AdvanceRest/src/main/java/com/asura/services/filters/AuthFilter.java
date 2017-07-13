package com.asura.services.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.internal.util.Base64;

public class AuthFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";
	

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if(authHeader.size() > 0){
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedstring = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedstring, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			System.out.println(username+"");
			//check calling to database whether this auth exists.
		}
		}
		requestContext.abortWith(Response.status(Status.UNAUTHORIZED)
				.entity("user cannot use")
				.build());

	}

}
