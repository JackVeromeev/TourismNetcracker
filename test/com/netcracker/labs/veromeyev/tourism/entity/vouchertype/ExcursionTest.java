package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class ExcursionTest {

    VoucherType excursion, newExcursion;

    @BeforeEach
    void setUp() {
        excursion = new Excursion(
                "Andorra to Washingtonexcursion",
                "Husein Barak ben Obamenladen",
                new ArrayList<Place>(){{
                    add(new Place("Andorra", "Andorra", "Andorra la veya",
                            "1, Torkvemada ave", "Torkvemada port", "beautiful port"));
                    add(new Hotel(new Place("USA", "Oklahoma", "Washington", "1, 5'ta ave",
                            "Hilton", ""),
                            "Hotel", 5, 0, 4));
                }}
        );
        newExcursion = new EntityFactory().newVoucherType(excursion.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(excursion.equals(newExcursion));
    }

    @Test
    void testHashCode() {
        assertEquals(excursion.hashCode(), newExcursion.hashCode());
    }

}