package org.foo.caffee.oracle.control;

import javax.persistence.EntityManager;
import org.foo.caffee.oracle.control.PredictionAudit;
import org.foo.caffee.oracle.entity.Prediction;
import org.foo.caffee.oracle.entity.Result;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PredictionAuditTest {

    private PredictionAudit cut;

    @Before
    public void initializeDependencies() {
        cut = new PredictionAudit();
        cut.em = mock(EntityManager.class);
    }

    @Test
    public void savingSuccessfulPrediction() {
        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, true);
        this.cut.onSuccessfulPrediction(expectedResult);
        verify(cut.em, times(1)).persist(expected);
    }

    @Test
    public void savingRolledBackPrediction() {

        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, false);
        this.cut.onFailedPrediction(expectedResult);
        verify(cut.em, times(1)).persist(expected);
    }

}
