package org.foo.caffee.oracle.control;

import org.foo.caffee.oracle.entity.Result;

public class ResonableConsultant implements Consultant {

    @Override
    public Result predictFutureOfJava() {
       return Result.BRIGHT;
    }

}
