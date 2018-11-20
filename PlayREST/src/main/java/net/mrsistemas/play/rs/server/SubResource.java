 
package net.mrsistemas.play.rs.server;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;


public class SubResource {
	@SuppressWarnings("unused")
	private String id;
	
    /** Creates a new instance of SubResource */
    private SubResource(String id) {
		this.id = id;
    }

    /** Get instance of the SubResource */
    public static SubResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of SubResource class.
        return new SubResource(id);
    }

    /**
     * Retrieves representation of an instance of SubResource
     * @return an instance of String
     */
	@GET
	@Produces("application/xml")
	public String resourceMethodGET() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
     * PUT method for updating or creating an instance of SubResource
     * @ content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@PUT
	@Consumes("application/xml")
	public void resourceMethodPUT() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
     * DELETE method for resource SubResource
     */
	@DELETE
	public void resourceMethodDELETE() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}