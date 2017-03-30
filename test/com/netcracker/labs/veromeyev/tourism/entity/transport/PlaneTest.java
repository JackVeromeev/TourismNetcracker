package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class PlaneTest {

    Transport plane, newPlane;

    @BeforeEach
    void setUp() throws ParseException {
        plane = new Plane("Airbus A320", 20, 15, false, true, true);
        newPlane = new EntityFactory().newTransport(
                (JSONObject) new JSONParser().parse(
                        plane.toJSONObject().toString()
                )
        );
    }

    @Test
    void equals() {
        assertTrue(plane.equals(newPlane));
    }

    @Test
    void testHashCode() {
        assertEquals(plane.hashCode(), newPlane.hashCode());
    }

}