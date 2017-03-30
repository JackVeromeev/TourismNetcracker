package com.netcracker.labs.veromeyev.tourism.entity.feeding;

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
class FeedingTest {

    Feeding feeding, newFeeding;

    @BeforeEach
    void setUp() throws ParseException {
        feeding = new Feeding(true, 22.8, "mramor beef");
        String o = feeding.toJSONObject().toJSONString();
        newFeeding = new Feeding((JSONObject) new JSONParser().parse(
                feeding.toJSONObject().toString()));
    }

    @Test
    void equals() {
        assertTrue(feeding.equals(newFeeding));
    }

    @Test
    void testHashCode() {
        assertEquals(feeding.hashCode(), newFeeding.hashCode());
    }

}