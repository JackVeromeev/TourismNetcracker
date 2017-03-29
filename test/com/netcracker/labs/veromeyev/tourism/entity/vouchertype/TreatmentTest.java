package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class TreatmentTest {
    VoucherType recreation, newRecreation;

    @BeforeEach
    void setUp() {
        recreation = new Treatment(
                new MedicalCenter(
                        new Place("China", "Himalai", "Shambala", "biggest tower",
                        "nirvana", "you don't die, just rest"),
                        new ArrayList<String>() {{
                            add("all");
                        }}
                )
        );
        newRecreation = new EntityFactory().newVoucherType(recreation.toJSONObject());
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