package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.util.StringUtil;
import org.json.simple.JSONObject;

public class Address implements JSONable {

    private String state;
    private String region;
    private String city;
    private String localAddress;

    public Address(String state, String region,
                   String city, String localAddress) {
        this.state = state;
        this.region = region;
        this.city = city;
        this.localAddress = localAddress;
    }

    public Address() {
        this("", "", "", "");
    }

    public Address(Address address) {
        this(address.getState(), address.getRegion(),
                address.getCity(), address.getLocalAddress());
    }

    public Address(JSONObject object) {
        this.state = (String) object.get("state");
        this.region = (String) object.get("region");
        this.city = (String) object.get("city");
        this.localAddress = (String) object.get("local address");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return state.equals(address.getState()) &&
                region.equals(address.getRegion()) &&
                city.equals(address.getCity()) &&
                localAddress.equals(address.getLocalAddress());
    }

    @Override
    public int hashCode() {
        return (state.hashCode() << 3) + (region.hashCode() << 2)
                + (city.hashCode() << 1) + localAddress.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(localAddress);
        if(city.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, ", ").append(city);
        }
        if(region.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, ", ").append(region);
        }
        if(state.length() > 0) {
            StringUtil.appendIfNotEmpty(builder, ", ").append(state);
        }
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("state", state);
        object.put("region", region);
        object.put("city", city);
        object.put("local address", localAddress);
        return object;
    }
}
