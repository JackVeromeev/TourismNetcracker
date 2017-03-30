package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Recreation implements VoucherType {

    private Hotel hotel;

    public Recreation(Hotel hotel) {
        this.hotel = hotel;
    }

    public Recreation() {
        this(new Hotel());
    }

    public Recreation(JSONObject o) {
        EntityFactory factory = new EntityFactory();
        hotel = (Hotel) factory.newPlace((JSONObject) o.get("hotel"));
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (hotel == null) hotel = new Hotel();
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recreation)) {
            return false;
        }
        return hotel.equals(((Recreation)o).getHotel());
    }

    @Override
    public int hashCode() {
        return hotel.hashCode();
    }

    @Override
    public String toString() {
        return "Recreation at " + hotel.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Place> getPlaces() {
        List<Place> result =  new ArrayList<>();
        result.add(hotel);
        return result;
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject object = new JSONObject();
        object.put("hotel", hotel.toJSONObject());
        return new JsonWithType(object,
                Name.Entity.VoucherType.RECREATION).getObject();
    }
}
