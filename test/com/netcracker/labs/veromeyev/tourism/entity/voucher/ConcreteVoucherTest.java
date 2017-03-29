package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Plane;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.Shopping;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 29/03/17.
 */
class ConcreteVoucherTest {

    ConcreteVoucher concreteVoucher, newConcreateVoucher;

    @BeforeEach
    void setUp() {
        concreteVoucher = new ConcreteVoucher(
                new Shopping(
                        new ArrayList<Shop>() {{
                            add(new Shop(
                                    new Place(
                                            "BY", "Vitebsk", "Glubokoe",
                                            "12, Lenina st", "EuroOpt",
                                            "big supermarket"
                                    ),
                                    new ArrayList<String>() {{
                                        add("milk");
                                        add("milk");
                                        add("condenced milk");
                                    }}
                            ));
                        }}
                ),
                3,
                LocalDateTime.of(2017, Month.AUGUST, 20, 12, 30),
                new Feeding(false, 12, "soboika"),
                new Plane("airbus A380", 120, 2, true, true, true)
        );

        JSONObject o = concreteVoucher.toJSONObject();

        newConcreateVoucher = new ConcreteVoucher(o);
    }

    @Test
    void watch() {
        System.out.println(concreteVoucher.toJSONObject().toJSONString());
        System.out.println(newConcreateVoucher.toJSONObject().toJSONString());
    }

    @Test
    void equals() {
        assertTrue(concreteVoucher.equals(newConcreateVoucher));
    }

    @Test
    void testHashCode() {
        assertEquals(concreteVoucher.hashCode(),
                newConcreateVoucher.hashCode());
    }

}