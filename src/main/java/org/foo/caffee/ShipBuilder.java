package org.foo.caffee;

import java.util.ArrayList;
import java.util.List;
import org.foo.caffee.entity.Person;
import org.foo.caffee.entity.Ship;

class ShipBuilder {

    
    public List<Ship> getMeSomeShips() {
        List<Ship> ships = new ArrayList<>(2);
        Person captainA = new Person("X Y",34);
        Person captainB = new Person("A B",44);
        
        ships.add(new Ship("Fearless",captainA,90,false));
        ships.add(new Ship("Nike",captainB,50,true));
        
        return ships;
    } 
}
