package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.Place;

import java.util.List;

/**
 * Created by jack on 23/03/17.
 */
public class Excursion implements VoucherType {

    private String name;
    private List<Place> places;
    private String guideName;

    public Excursion(String name, String guideName, List<Place> places) {
        setName(name);
        setGuideName(guideName);
        setPlaces(places);
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
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
        if ( !(o instanceof Excursion)) {
            return false;
        }
        Excursion excursion = (Excursion) o;
        return name.equals(excursion.getName())
                && guideName.equals(excursion.getGuideName())
                && places.equals(excursion.getPlaces());
    }

    public int hashCode() {
        return (name.hashCode() << 2)
                + (guideName.hashCode() << 1)
                + places.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Excursion \"").append(name).append("\"");
        if (guideName.length() > 0) {
            builder.append("\nGuide name: ").append(guideName);
        }
        if (places.size() > 0) {
            builder.append("Place(s):");
            if (places.size() == 1) {
                builder.append(" ").append(places.get(0).toString());
            } else {
                for (Place place : places) {
                    builder.append("\n").append(place.toString());
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

}
