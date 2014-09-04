package org.foo.caffee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("sessions")
public class SessionsResource {
    
    @Inject
    CrazyComplex cc;
    
    @GET
    public String sessions() {
        return cc.getTime();
    }

}
