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
class ShipTest {

    Transport ship, newShip;

    @BeforeEach
    void setUp() throws ParseException {
        ship = new Ship("Olimphic", 20, 15, 3, true);
        newShip = new EntityFactory().newTransport(
                (JSONObject) new JSONParser().parse(
                        ship.toJSONObject().toString()
                )
        );
    }

    @Test
    void equals() {
        assertTrue(ship.equals(newShip));
    }

    @Test
    void testHashCode() {
        assertEquals(ship.hashCode(), newShip.hashCode());
    }

}