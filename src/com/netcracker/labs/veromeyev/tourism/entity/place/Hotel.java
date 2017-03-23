package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.util.StringUtil;

/**
 * Created by jack on 22/03/17.
 */
public class Hotel extends  Place {
    private String hotelType;
    private int rate;
    private double kmFromSea;
    private double kmFromCity;

    public Hotel(Place place, String hotelType, int rate,
          double kmFromCity, double kmFromSea) {
        super(place);
        setHotelType(hotelType);
        setRate(rate);
        setKmFromCity(kmFromCity);
        setKmFromSea(kmFromSea);
    }

    public Hotel(Hotel hotel) {
        this(hotel, hotel.getHotelType(), hotel.getRate(),
                hotel.getKmFromCity(), hotel.getKmFromSea());
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

    public int hashCode() {
        return (super.hashCode() << 4) +
                (hotelType.hashCode() << 3) +
                (rate << 2) +
                (((int)kmFromCity) << 1 ) +
                ((int) kmFromSea);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(hotelType);
        StringUtil.appendIfNotEmpty(builder, " ");
        if (rate > 0) {
            builder.append("( ").append(rate).append(" stars)");
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
}
