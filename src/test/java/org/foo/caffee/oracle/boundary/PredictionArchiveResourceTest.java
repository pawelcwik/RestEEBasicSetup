package org.foo.caffee.oracle.boundary;

import java.util.ArrayList;
import java.util.List;
import org.foo.caffee.oracle.control.PredictionAudit;
import org.foo.caffee.oracle.entity.Prediction;
import org.foo.caffee.oracle.entity.Result;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PredictionArchiveResourceTest {

    PredictionArchiveResource cut;

    @Before
    public void initialize() {
        this.cut = new PredictionArchiveResource();
        this.cut.audit = mock(PredictionAudit.class);
    }

    @Test
    public void allDecisionsWithMaxLesserReturn() throws Exception {
        int expectedSize = 2;
        List<Prediction> prediction = createDecisions(expectedSize);
        when(this.cut.audit.allPredictions()).thenReturn(prediction);
        List<Prediction> allDecisions = this.cut.allPredictions(3);
        assertThat(allDecisions.size(), is(expectedSize));
    }

    @Test
    public void allDecisionsWithMaxGreaterReturn() throws Exception {
        int max = 5;
        int expected = 3;
        List<Prediction> prediction = createDecisions(max);
        when(this.cut.audit.allPredictions()).thenReturn(prediction);
        List<Prediction> allDecisions = this.cut.allPredictions(expected);
        assertThat(allDecisions.size(), is(expected));

    }


    List<Prediction> createDecisions(final int nr) {
        return new ArrayList<Prediction>() {
            {
                for (int i = 0; i < nr; i++) {
                    add(new Prediction(Result.BRIGHT, true));
               }
            }
        };
    }
}
