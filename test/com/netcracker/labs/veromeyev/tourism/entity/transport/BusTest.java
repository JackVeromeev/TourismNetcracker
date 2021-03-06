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
class BusTest {

    Transport bus, newBus;

    @BeforeEach
    void setUp() throws ParseException {
        bus = new Bus("EchoLines superbus", 20, 15, true, true, true);
        newBus = new EntityFactory().newTransport(
                (JSONObject) new JSONParser().parse(
                        bus.toJSONObject().toString()
                )
        );
    }

    @Test
    void equals() {
        assertTrue(bus.equals(newBus));
    }

    @Test
    void testHashCode() {
        assertEquals(bus.hashCode(), newBus.hashCode());
    }

}