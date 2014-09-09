package org.foo.caffee.oracle.control;

import org.foo.caffee.oracle.entity.Result;
import org.foo.caffee.oracle.control.Consultant;

public class Blogger implements Consultant {

    @Override
    public Result predictFutureOfJava() {
        return Result.JAVA_IS_DEAD;
    }
}
