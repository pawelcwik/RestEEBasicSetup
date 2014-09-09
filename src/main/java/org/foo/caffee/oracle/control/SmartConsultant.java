package org.foo.caffee.oracle.control;

import org.foo.caffee.oracle.entity.Result;

public class SmartConsultant implements Consultant {

    @Override
    public Result predictFutureOfJava() {
        return Result.IT_DEPENDS;
    }

}
