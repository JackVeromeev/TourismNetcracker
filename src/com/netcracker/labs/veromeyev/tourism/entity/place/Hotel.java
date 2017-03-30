package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.util.StringUtil;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

/**
 * Created by jack on 22/03/17.
 */
public class Hotel extends  Place implements JSONable {

    private String hotelType;
    private int rate;
    private double kmFromSea;
    private double kmFromCity;

    public Hotel(Address address, String placeName, String description,
                 String hotelType, int rate, double kmFromCity,
                 double kmFromSea) {
        super(new Place(address, placeName, description));
        this.hotelType = hotelType;
        this.rate = rate;
        this.kmFromCity = kmFromCity;
        this.kmFromSea = kmFromSea;
    }

    public Hotel(Place place, String hotelType, int rate,
          double kmFromCity, double kmFromSea) {
        super(place);
        this.hotelType = hotelType;
        this.rate = rate;
        this.kmFromCity = kmFromCity;
        this.kmFromSea = kmFromSea;
    }

    public Hotel(Hotel hotel) {
        this(hotel, hotel.getHotelType(), hotel.getRate(),
                hotel.getKmFromCity(), hotel.getKmFromSea());
    }

    public Hotel(JSONObject o) {
        this(new Place(o), (String)o.get("hotel type"),
                ((Long)o.get("rate")).intValue(),
                (Double)o.get("km from city"), (Double)o.get("km from sea")
        );
    }

    public Hotel() {
        this(new Place(), "", 0, 0, 0);
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getKmFromSea() {
        return kmFromSea;
    }

    public void setKmFromSea(double kmFromSea) {
        this.kmFromSea = kmFromSea;
    }

    public double getKmFromCity() {
        return kmFromCity;
    }

    public void setKmFromCity(double kmFromCity) {
        this.kmFromCity = kmFromCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return super.equals(o) && hotelType.equals(hotel.getHotelType())
                && (rate == hotel.getRate())
                && (kmFromSea == hotel.getKmFromSea())
                && (kmFromCity == hotel.getKmFromCity());
    }

    @Override
    public int hashCode() {
        return (super.hashCode() << 4) +
                (hotelType.hashCode() << 3) +
                (rate << 2) +
                (((int)kmFromCity) << 1 ) +
                ((int) kmFromSea);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(hotelType);
        StringUtil.appendIfNotEmpty(builder, " ");
        if (rate > 0) {
            builder.append("(").append(rate).append(" stars)");
            StringUtil.appendIfNotEmpty(builder, " ");
        }
        builder.append(super.toString());
        if (kmFromSea > .0 || kmFromCity > .0) {
            builder.append(" (");
            if (kmFromSea > .0) {
                builder.append(kmFromSea). append(" km from sea");
                if (kmFromCity > .0) {
                    builder.append(", ");
                }
            }
            if (kmFromCity > .0) {
                builder.append(kmFromCity). append(" km from city");
            }
            builder.append(")");
        }
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {

        // call Place.toJSONObject()
        JsonWithType objectWithType = new JsonWithType(super.toJSONObject());
        objectWithType.getInnerObject().put("hotel type", hotelType);
        objectWithType.getInnerObject().put("rate", rate);
        objectWithType.getInnerObject().put("km from sea", kmFromSea);
        objectWithType.getInnerObject().put("km from city", kmFromCity);

        // override type of superclass
        objectWithType.setType(Name.Entity.Place.HOTEL);
        return objectWithType.getObject();
    }
}
