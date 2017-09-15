package com.crusnikatelier.oauth2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/system")
public class SystemResource {

	@GET
	@Path("diagnostic/connection")
	public Response status(){
		return Response.ok("success").build();
	}
}
