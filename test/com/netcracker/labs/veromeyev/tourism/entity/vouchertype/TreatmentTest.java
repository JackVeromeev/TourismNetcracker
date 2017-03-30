package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
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
class TreatmentTest {
    VoucherType treatment, newTreatment;

    @BeforeEach
    void setUp() throws ParseException {
        treatment = new Treatment(
                new MedicalCenter(
                        new Place("China", "Himalai", "Shambala", "biggest tower",
                        "nirvana", "you don't die, just rest"),
                        new ArrayList<String>() {{
                            add("all");
                        }}
                )
        );
        newTreatment = new EntityFactory().newVoucherType(
                (JSONObject) new JSONParser().parse(
                        treatment.toJSONObject().toString()
                )
        );
    }

    @Test
    void equals() {
        assertTrue(treatment.equals(newTreatment));
    }

    @Test
    void testHashCode() {
        assertEquals(treatment.hashCode(), newTreatment.hashCode());
    }

}