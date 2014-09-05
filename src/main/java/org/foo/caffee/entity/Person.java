package org.foo.caffee.entity;

import javax.json.Json;
import javax.json.JsonObject;

public class Person {
    
    private String name;
    private int age;

    public Person(String name, int age) {
       this.name = name;
       this.age = age;
    }

    
    public JsonObject convert() {
        return Json.createObjectBuilder().
                add("name", this.name).
                add("age", this.age).build();
    }
}
