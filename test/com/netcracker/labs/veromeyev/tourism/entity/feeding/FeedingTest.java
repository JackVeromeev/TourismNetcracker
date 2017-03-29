package com.netcracker.labs.veromeyev.tourism.entity.feeding;

import org.json.simple.JSONObject;
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
    void setUp() {
        feeding = new Feeding(true, 22.8, "mramor beef");
        JSONObject o = feeding.toJSONObject();
        newFeeding = new Feeding(o);
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