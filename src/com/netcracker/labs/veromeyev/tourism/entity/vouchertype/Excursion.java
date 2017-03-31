package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 23/03/17.
 */
public class Excursion implements VoucherType {

    private String name;
    private List<Place> places;
    private String guideName;

    public Excursion(String name, String guideName, List<Place> places) {
        this.name = name;
        this.guideName = guideName;
        this.places = places;
    }

    public Excursion(JSONObject o) {
        this.name = (String) o.get("name");
        this.guideName = (String) o.get("guide name");

        EntityFactory factory = new EntityFactory();
        JSONArray placeArray = (JSONArray) o.get("places");
        places = new LinkedList<>();
        for (Object jsonPlace : placeArray) {
            places.add(factory.newPlace((JSONObject)jsonPlace));
        }
    }

    @Override
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

    @Override
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

    @Override
    public int hashCode() {
        return (name.hashCode() << 2)
                + (guideName.hashCode() << 1)
                + places.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Excursion \"").append(name).append("\"");
        if (guideName.length() > 0) {
            builder.append("\n    Guide name: ").append(guideName);
        }
        if (places.size() > 0) {
            builder.append(".\n    Place(s):");
            if (places.size() == 1) {
                builder.append(" ").append(places.get(0).toString());
            } else {
                for (Place place : places) {
                    builder.append("\n        ").append(place.toString());
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject object = new JSONObject();
        object.put("name", name);

        JSONArray array = new JSONArray();
        for (Place place : places) {
            array.add(place.toJSONObject());
        }
        object.put("places", array);

        object.put("guide name", guideName);
        return new JsonWithType(object,
                Name.Entity.VoucherType.EXCURSION).getObject();
    }
}
