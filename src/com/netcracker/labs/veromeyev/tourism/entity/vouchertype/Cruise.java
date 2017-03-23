package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 23/03/17.
 */
public class Cruise extends VoucherType {

    private String name;
    private Place departurePlace;
    private Place arrivalPlace;
    private List<String> waterBodies;

    public Cruise(String name, Place departurePlace, Place arrivalPlace,
                  List<String> waterBodies) {
        setName(name);
        setDeparturePlace(departurePlace);
        setArrivalPlace(arrivalPlace);
        setWaterBodies(waterBodies);
    }


    public Place getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(Place departurePlace) {
        this.departurePlace = departurePlace;
    }

    public Place getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(Place arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public List<String> getWaterBodies() {
        return waterBodies;
    }

    public void setWaterBodies(List<String> waterBodies) {
        this.waterBodies = waterBodies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( !(o instanceof Place)) {
            return false;
        }
        Cruise cruise = (Cruise) o;
        return name.equals(cruise.getName())
                && departurePlace.equals(cruise.getDeparturePlace())
                && arrivalPlace.equals(cruise.getArrivalPlace())
                && waterBodies.equals(cruise.getWaterBodies());
    }

    public int hashCode() {
        return (name.hashCode() << 3)
                + (departurePlace.hashCode() << 2)
                + (arrivalPlace.hashCode() << 1)
                + waterBodies.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (name.length() > 0) {
            builder.append("Cruise \"").append(name).append("\"");
        }
        builder.append("\"Depart from: ").append(departurePlace.toString());
        builder.append("\"Arrive at: ").append(arrivalPlace.toString());
        if (waterBodies.size() > 0) {
            builder.append("\nCruise at");
            if (waterBodies.size() > 1) {
                builder.append(":");
            }
            boolean firstElement = true;
            for (String waterBody : waterBodies) {
                if (firstElement) {
                    firstElement = false;
                } else {
                    builder.append(", ");
                }
                builder.append(waterBody);
            }
        }
        return builder.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Place> getPlaces() {
        return new ArrayList<Place>(){{
            add(departurePlace);
            add(arrivalPlace);
        }};
    }
}
