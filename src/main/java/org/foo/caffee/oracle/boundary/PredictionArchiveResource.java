package org.foo.caffee.oracle.boundary;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.foo.caffee.oracle.control.PredictionAudit;
import org.foo.caffee.oracle.entity.Prediction;

@Path("predictions")
@Stateless
public class PredictionArchiveResource {

    @EJB
    PredictionAudit audit;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prediction> allPredictions(@DefaultValue("5") @QueryParam("max") int max) {

        List<Prediction> allPredictions = audit.allPredictions();
        if (allPredictions.size() <= max) {
            return allPredictions;
        } else {
            return allPredictions.subList(0, max);
        }
    }
}
