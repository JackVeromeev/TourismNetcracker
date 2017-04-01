package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.util.StringUtil;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

public class Place implements JSONable {

    protected Address address;
    protected String placeName;
    protected String description;

    public Place(String state, String region, String city,
                 String localAddress,String placeName, String description) {
         this(new Address(state, region, city, localAddress),
                 placeName, description
         );
    }

    public Place(Address address, String placeName, String description) {
        this.address = address;
        this.placeName = placeName;
        this.description = description;
    }

    public Place(Place place) {
        this(place.getAddress(),
                place.getPlaceName(),
                place.getDescription()
        );
    }

    public Place(JSONObject object) {
        this(new Address((JSONObject) object.get("address")),
                (String) object.get("place name"),
                (String) object.get("description")
        );
    }

    public Place() {
        this(new Address(), "", "");
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( !(o instanceof Place)) {
            return false;
        }
        Place place = (Place) o;
        return placeName.equals(place.getPlaceName()) &&
                description.equals(place.getDescription()) &&
                address.equals(place.getAddress());
    }

    @Override
    public int hashCode() {
        return (address.hashCode() << 2) +
                (placeName.hashCode() << 1) +
                description.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\"").append(placeName).append("\"");

        if (description.length() > 0) {
            StringUtil.appendIfNotEmpty(builder,
                    " (" + description + ")");
        }
        else builder.append(description);

        String fullAddress = address.toString();
        if (fullAddress.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, " ");
            builder.append(fullAddress);
        }
        return  builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject innerObject = new JSONObject();
        innerObject.put("address", address.toJSONObject());
        innerObject.put("place name", placeName);
        innerObject.put("description", description);
        return new JsonWithType(innerObject, Name.Entity.Place.PLACE)
                .getObject();
    }
}
