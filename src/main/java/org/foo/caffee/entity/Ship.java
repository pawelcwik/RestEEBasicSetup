package org.foo.caffee.entity;

import javax.json.Json;
import javax.json.JsonObject;

public class Ship {
   
    private int speed;
    private String name;
    private Person captain;
    private boolean damaged;

    public Ship(String name, Person captain, int speed, boolean damaged) {
        this.name = name;
        this.captain = captain;
        this.speed = speed;
        this.damaged = damaged;
    }
    
    
    public JsonObject convert() {
        return Json.createObjectBuilder().
                add("damaged", this.damaged).
                add("speed", speed).add("name", name).
                add("captain", captain.convert()).build();
    }
    

}
