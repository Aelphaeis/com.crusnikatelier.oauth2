package com.crusnikatelier.oauth2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/system")
public class SystemResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("diagnostic/connection")
	public Response status(){
		return Response.ok("success").build();
	}
}
