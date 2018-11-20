package net.mrsistemas.play.rs.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/service") 
@Consumes("application/json")
@Produces("application/json")
public class Resource {
    @Context
    private UriInfo context;
    
	/**
     * Default constructor. 
     */
    public Resource() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of Resource
     * @return an instance of java.lang.String
     */
	@GET
	@Produces("application/json")
	public String resourceMethodGET() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Path("{id}")
	public SubResource getSubResource(@PathParam("id") String id) { 
		return SubResource.getInstance(id);
	}
	
}