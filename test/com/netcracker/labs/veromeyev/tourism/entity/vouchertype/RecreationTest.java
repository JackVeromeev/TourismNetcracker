package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
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
class RecreationTest {

    VoucherType recreation, newRecreation;

    @BeforeEach
    void setUp() throws ParseException {
        recreation = new Recreation(
                new Hotel(new Place("USA", "Oklahoma", "Washington", "1, 5'ta ave",
                        "Hilton", ""),
                        "Hotel", 5, 0, 4)
        );
        newRecreation = new EntityFactory().newVoucherType(
                (JSONObject) new JSONParser().parse(
                        recreation.toJSONObject().toString()
                )
        );
    }

    @Test
    void equals() {
        assertTrue(recreation.equals(newRecreation));
    }

    @Test
    void testHashCode() {
        assertEquals(recreation.hashCode(), newRecreation.hashCode());
    }

}