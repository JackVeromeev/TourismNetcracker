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
class MedicalCenterTest {
    Place medicalCenter, newMedicalCenter;

    @BeforeEach
    void setUp() {
        medicalCenter = new MedicalCenter(
                new Place("BY", "Minsk", "Minsk", "89, Dzyarzhinskaha ave",
                        "BSUIR hostel #4", "best hostel ever"),
                new ArrayList<String>() {{
                    add("headache");
                    add("stomachache");
                    add("coprophilia");
                }}
        );
        newMedicalCenter =
                new EntityFactory().newPlace(medicalCenter.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(medicalCenter.equals(newMedicalCenter));
    }

    @Test
    void testHashCode() {
        assertEquals(medicalCenter.hashCode(), newMedicalCenter.hashCode());
    }
}