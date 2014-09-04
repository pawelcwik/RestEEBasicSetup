package org.foo.caffee;

import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class CrazyComplex {

    @Inject
    Wizzard w;
    
    public String getTime() {
        return new Date().toString() + " " + w.noMagic();
    }
}
