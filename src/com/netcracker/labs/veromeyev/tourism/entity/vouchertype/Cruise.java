package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cruise implements VoucherType {

    private String name;
    private Place departurePlace;
    private Place arrivalPlace;
    private List<String> waterBodies;
    private Transport transport;

    public Cruise(String name, Place departurePlace, Place arrivalPlace,
                  List<String> waterBodies, Transport transport) {
        this.name = name;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.waterBodies = waterBodies;
        this.transport = transport;
    }

    public Cruise(JSONObject o) {
        EntityFactory factory = new EntityFactory();
        this.name = (String) o.get("name");

        JSONArray jsonWaterBodies = (JSONArray) o.get("water bodies");
        this.waterBodies = new ArrayList<>(jsonWaterBodies.size());
        for (Object waterBody : jsonWaterBodies) {
            waterBodies.add((String) waterBody);
        }

        this.departurePlace = factory.newPlace(
                (JSONObject) o.get("departure place"));
        this.arrivalPlace = factory.newPlace(
                (JSONObject) o.get("arrival place"));
        this.transport = factory.newTransport(
                (JSONObject) o.get("transport"));
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


    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( !(o instanceof Cruise)) {
            return false;
        }
        Cruise cruise = (Cruise) o;
        return name.equals(cruise.getName())
                && departurePlace.equals(cruise.getDeparturePlace())
                && arrivalPlace.equals(cruise.getArrivalPlace())
                && waterBodies.equals(cruise.getWaterBodies())
                && transport.equals(cruise.getTransport());
    }

    @Override
    public int hashCode() {
        return (name.hashCode() << 4)
                + (departurePlace.hashCode() << 3)
                + (arrivalPlace.hashCode() << 2)
                + (transport.hashCode() << 1)
                + waterBodies.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (name.length() > 0) {
            builder.append("Cruise \"").append(name).append("\"");
        }
        builder.append(".\n    Depart from: ").append(departurePlace.toString());
        builder.append(".\n    Arrive at: ").append(arrivalPlace.toString());
        if (waterBodies.size() > 0) {
            builder.append("\n    Cruise at");
            if (waterBodies.size() > 1) {
                builder.append(":");
            } else builder.append(" ");
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
        builder.append(".\n    Transport: ").append(transport.toString());
        return builder.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Place> getPlaces() {
        List<Place> places = new ArrayList<>();
        places.add(departurePlace);
        places.add(arrivalPlace);
        return places;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("departure place", departurePlace.toJSONObject());
        object.put("arrival place", arrivalPlace.toJSONObject());
        JSONArray waterBodyArray = new JSONArray();
        for (String waterBody : waterBodies) {
            waterBodyArray.add(waterBody);
        }
        object.put("water bodies", waterBodyArray);
        object.put("transport", transport.toJSONObject());
        return new JsonWithType(object,
                Name.Entity.VoucherType.CRUISE).getObject();
    }


}
