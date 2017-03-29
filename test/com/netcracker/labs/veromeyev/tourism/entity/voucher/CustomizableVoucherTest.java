package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Bus;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.Cruise;
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
class CustomizableVoucherTest {

    CustomizableVoucher customizableVoucher, newCustomizableVoucher;

    @BeforeEach
    void setUp() {
        customizableVoucher = new CustomizableVoucher(
                new Cruise(
                        "Dniper",
                        new Place("Belarus", "Mogilev", "Mogilev",
                                "prichar", "prichal", ""),
                        new Place("Belarus", "Gomel", "Rogachev",
                                "plyazh", "kupala", "near tree"),
                        new ArrayList<String>() {{ add("Dniper river"); }},
                        new Ship("simple parom", 20, 40, 1, false)
                ),
                new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                }},
                new ArrayList<LocalDateTime>() {{
                    add(LocalDateTime.of(2017, Month.MAY, 15, 18,0));
                }},
                new ArrayList<Feeding>() {{
                    add(new Feeding(false, 10, "meat and river fish"));
                }},
                new ArrayList<Transport>() {{
                    add(new Bus("simple bus", 10, 2,
                            false, false, true));
                }}
        );
        JSONObject o = customizableVoucher.toJSONObject();
        newCustomizableVoucher = new CustomizableVoucher(o);
    }

    @Test
    void equals() {
        assertTrue(customizableVoucher.equals(newCustomizableVoucher));
    }

    @Test
    void testHashCode() {
        assertEquals(customizableVoucher.hashCode(),
                newCustomizableVoucher.hashCode());
    }

}