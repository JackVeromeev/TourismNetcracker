package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class CruiseTest {

    VoucherType cruise, newCruise;

    @BeforeEach
    void setUp() {
        cruise = new Cruise(
                "Andorra to Washington",
                new Place("Andorra", "Andorra", "Andorra la veya",
                        "1, Torkvemada ave", "Torkvemada port", "beautiful port"),
                new Place("USA", "Oklahoma", "Washington", "5'ta ave",
                        "Main Washington port", ""),
                new ArrayList<String>() {{
                    add("Atlantic ocean");
                }},
                new Ship(
                        "liner Black Dimond", 911, 100, 4, true)
        );
        newCruise = new EntityFactory().newVoucherType(cruise.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(cruise.equals(newCruise));
    }

    @Test
    void testHashCode() {
        assertEquals(cruise.hashCode(), newCruise.hashCode());
    }

}