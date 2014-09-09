package org.foo.caffee.oracle.boundary;

import org.foo.caffee.oracle.entity.Result;
import org.foo.caffee.oracle.control.Consultant;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static org.foo.caffee.oracle.entity.Result.JAVA_IS_DEAD;


@Path("javafuture")
@Stateless
public class OracleResource {
    
    @Inject
    Instance<Consultant> company;
    
    @Inject
    Event<Result> eventListener;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String predictFutureOfJava() {
        checkConsultantAvailability();
        Consultant consultant = getConsultant();
        Result prediction = consultant.predictFutureOfJava();
        eventListener.fire(prediction);
        if(JAVA_IS_DEAD.equals(prediction)) {
            throw new IllegalStateException("Please perform a sanity/reality check");
        }
        
        return prediction.name();
    }
    
    void checkConsultantAvailability() {
        if(company.isUnsatisfied()) {
            throw new IllegalStateException("No cnsultant to ask!");
        }
    }
    
    Consultant getConsultant() {
        for(Consultant consultant : company) {
            return consultant;
        }
        return null;
    }
    
    
}
