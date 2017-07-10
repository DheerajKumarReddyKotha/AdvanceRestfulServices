/**
 * 
 */
package com.asura.services.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author dheeraj.kotha<dheerajkumarreddykotha@gmail.com>
 *
 */
@Path("{pathParam}/test")
public class Resource {
	
	@PathParam(value = "pathParam") private String pathParam;
	@QueryParam(value = "query") private String queryParam;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMethod(){
		return "It works with pathParam: "+pathParam+" and query param: "+queryParam;
	}
}
