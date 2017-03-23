package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.util.StringUtil;

/**
 * Created by jack on 21/03/17.
 */
public class Place {

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
        setAddress(address);
        setPlaceName(placeName);
        setDescription(description);
    }

    public Place(Place place) {
        this(place.getAddress(),
                place.getPlaceName(),
                place.getDescription()
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
        if (address == null) {
            address = new Address();
        }
        this.address = address;
    }


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

    public int hashCode() {
        return (address.hashCode() << 2) +
                (placeName.hashCode() << 1) +
                description.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(placeName);

        if (description.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, " (" + description + ")");
        }
        else builder.append(description);

        String fullAddress = address.toString();
        if (fullAddress.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, " ").append(fullAddress);
        }

        return  builder.toString();
    }
}
