package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class ShoppingTest {
    VoucherType shopping, newShoping;

    @BeforeEach
    void setUp() throws ParseException {
        shopping = new Shopping(
                new ArrayList<Shop>() {{
                    add(new Shop(
                            new Place("Italy", "Toskana", "Milan", "3, Pizza st.",
                                    "D&G boutique",
                                    "most famous gay shop"),
                            new ArrayList<String>() {{
                                add("pants");
                                add("bags");
                                add("socks");
                            }}
                    ));
                }}
        );
        newShoping =
                new EntityFactory().newVoucherType(
                        (JSONObject) new JSONParser().parse(
                                shopping.toJSONObject().toString()
                        )
                );
    }

    @Test
    void equals() {
        assertTrue(shopping.equals(newShoping));
    }

    @Test
    void testHashCode() {
        assertEquals(shopping.hashCode(), newShoping.hashCode());
    }

}