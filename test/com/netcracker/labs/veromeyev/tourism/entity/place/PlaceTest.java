package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class PlaceTest {

    Place place, newPlace;

    @BeforeEach
    void setUp() {
        place = new Place("BY", "Minsk", "Minsk", "89, Dzyarzhinskaha ave",
                "Netcracker", "best firm ever");
        newPlace = new EntityFactory().newPlace(place.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(place.equals(newPlace));
    }

    @Test
    void testHashCode() {
        assertEquals(place.hashCode(), newPlace.hashCode());
    }

}