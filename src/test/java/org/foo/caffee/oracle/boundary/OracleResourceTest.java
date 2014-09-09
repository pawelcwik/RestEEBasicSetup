package org.foo.caffee.oracle.boundary;

import java.util.Iterator;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import org.foo.caffee.oracle.control.Blogger;
import org.foo.caffee.oracle.control.Consultant;
import org.foo.caffee.oracle.entity.Result;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class OracleResourceTest {

    private OracleResource cut;

    @Before
    public void initializeDependencies() {
        this.cut = new OracleResource();
        this.cut.company = mock(Instance.class);
        this.cut.eventListener = mock(Event.class);
    }

    @Test(expected = IllegalStateException.class)
    public void checkConsultantAvailabilityWithoutConsultant() {
        when(this.cut.company.isUnsatisfied()).thenReturn(true);
        this.cut.checkConsultantAvailability();
    }

    @Test(expected = IllegalStateException.class)
    public void unreasonablePrediction() {
        Consultant consultant = new Blogger();
        Iterator iterator = mockIterator(consultant);
        when(this.cut.company.iterator()).thenReturn(iterator);
        this.cut.predictFutureOfJava();

    }

    Iterator mockIterator(Consultant consultant) {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn(consultant);
        when(iterator.hasNext()).thenReturn(true);
        return iterator;
    }

    @Test
    public void unreasonablePredictionFiresEvent() {
        Consultant consultant = new Blogger();
        Result expectedResultToFire = consultant.predictFutureOfJava();
        Iterator iterator = mockIterator(consultant);
        when(this.cut.company.iterator()).thenReturn(iterator);

        try {
            this.cut.predictFutureOfJava();
        } catch (IllegalStateException e) {
        }

        verify(this.cut.eventListener, times(1)).fire(expectedResultToFire);
    }

}
