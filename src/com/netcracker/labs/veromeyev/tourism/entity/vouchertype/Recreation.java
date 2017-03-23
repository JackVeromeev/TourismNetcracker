package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Recreation implements VoucherType {

    private Hotel hotel;

    public Recreation(Hotel hotel) {
        setHotel(hotel);
    }

    public Recreation() {
        this(new Hotel());
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (hotel == null) hotel = new Hotel();
        this.hotel = hotel;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recreation)) {
            return false;
        }
        return hotel.equals(((Recreation)o).getHotel());
    }

    public int hashCode() {
        return hotel.hashCode();
    }

    public String toString() {
        return "Recreation at" + hotel.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Place> getPlaces() {
        return new ArrayList<Place>(){{
            add(hotel);
        }};
    }
}
