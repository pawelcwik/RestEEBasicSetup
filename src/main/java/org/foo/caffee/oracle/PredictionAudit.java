package org.foo.caffee.oracle;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PredictionAudit {

    @PersistenceContext
    EntityManager em;
    
    public void onSuccessfulPrediction(@Observes(during=TransactionPhase.AFTER_SUCCESS) Result result) {
        persistDecision(result,true);
    }
    
    public void onFailedPrediction(@Observes(during=TransactionPhase.AFTER_FAILURE) Result result) {
        persistDecision(result,false);
    }
    
    void persistDecision(Result result, boolean success) {
        Prediction prediction = new Prediction(result,success);
        em.persist(prediction);
    }
    
    public List<Prediction> allDecisions() {
        return this.em.createNamedQuery(Prediction.findAll).getResultList();
    }
    
}
