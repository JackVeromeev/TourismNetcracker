package com.netcracker.labs.veromeyev.tourism.entity.place;

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
class PlaceTest {

    Place place, newPlace;

    @BeforeEach
    void setUp() throws ParseException {
        place = new Place("BY", "Minsk", "Minsk", "89, Dzyarzhinskaha ave",
                "Netcracker", "best firm ever");
        newPlace = new EntityFactory().newPlace(
                (JSONObject) new JSONParser().parse(
                        place.toJSONObject().toString()
                )
        );
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