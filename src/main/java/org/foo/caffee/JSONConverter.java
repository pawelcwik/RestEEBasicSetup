package org.foo.caffee;

import java.util.Collection;
import java.util.stream.Collector;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import org.foo.caffee.entity.Ship;

public class JSONConverter {

    static public JsonArray allAsJson(Collection<Ship> ships) {

        Collector<JsonObject, ?, JsonArrayBuilder> jsonCollector
                = Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add,
                        (left, right) -> {
                            left.add(right);
                            return left;
                        });
        return ships.stream().map(Ship::convert).
                collect(jsonCollector).build();

    }

}
