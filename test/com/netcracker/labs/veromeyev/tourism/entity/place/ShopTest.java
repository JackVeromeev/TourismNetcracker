package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class ShopTest {
    Place shop, newShop;

    @BeforeEach
    void setUp() {
        shop = new Shop(
                new Place("BY", "Minsk", "Minsk", "89, Dzyarzhinskaha ave",
                        "BSUIR hostel #4", "best hostel ever"),
                new ArrayList<String>() {{
                    add("cars");
                    add("stomachache");
                    add("coprophilia");
                }}
        );
        newShop =
                new EntityFactory().newPlace(shop.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(shop.equals(newShop));
    }

    @Test
    void testHashCode() {
        assertEquals(shop.hashCode(), newShop.hashCode());
    }

}