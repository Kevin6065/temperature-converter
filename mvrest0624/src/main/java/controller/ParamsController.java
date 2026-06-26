package controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.*;

import java.util.Map;
import java.util.UUID;

import jakarta.ws.rs.*;

@Path("/params")
@Produces(MediaType.APPLICATION_JSON)
public class ParamsController {
	@POST	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(
	        @FormParam("username") String username,
	        @FormParam("password") String password) {
		
		String message = String.format("{\"username\": %s, \"password\": %s}"
				                       , username,password);
		return Response.ok(message).build();
	}
	@GET @Path("/greeting")	
	public Response greeting(
	        @HeaderParam("Accept-Language") @DefaultValue("zh-TW") String lang) {
	    String msg = switch (lang) {
	        case "en" -> "Hello";
	        case "ja" -> "こんにちは";
	        default  -> "你好";
	    };
	    return Response.ok(Map.of("message", msg))
	            .header("Content-Language", lang)
	            .build();
	}
	@GET @Path("/orders/{id}")
	public Response getOrder(
	        @PathParam("id") int id,
	        @HeaderParam("X-Request-ID") String traceId) {
	    if (traceId == null) traceId = UUID.randomUUID().toString();
	    System.out.println("trace=" + traceId + " getOrder id=" + id);    
	    return Response.ok(Map.of("orderId", id))
	            .header("X-Request-ID", traceId)
	            .build();
	}
}
