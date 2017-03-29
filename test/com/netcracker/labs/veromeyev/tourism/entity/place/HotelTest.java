package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jack on 30/03/17.
 */
class HotelTest {

    Place hotel, newHotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel(
                new Place("BY", "Minsk", "Minsk", "89, Dzyarzhinskaha ave",
                "BSUIR hostel #4", "best hostel ever"),
                "hostel", 5, 0, 300);
        newHotel = new EntityFactory().newPlace(hotel.toJSONObject());
    }

    @Test
    void equals() {
        assertTrue(hotel.equals(newHotel));
    }

    @Test
    void testHashCode() {
        assertEquals(hotel.hashCode(), newHotel.hashCode());
    }

}