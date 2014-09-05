package org.foo.caffee;

import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;


@Stateless
public class CrazyComplex {

    @Inject
    Wizzard w;
    
    @Inject
    ShipBuilder sb;
    
    public String getTime() {
        return new Date().toString() + " " + w.noMagic();
    }
    
    public String getShips() {
       JsonArray arr = JSONConverter.allAsJson(sb.getMeSomeShips());
       return arr.toString();
    }
}
