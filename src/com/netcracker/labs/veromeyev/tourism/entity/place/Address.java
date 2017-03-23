package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.util.StringUtil;

/**
 * Created by jack on 21/03/17.
 * @author jack veromeyev
 */
public class Address {

    private String state;
    private String region;
    private String city;
    private String localAddress;

    public Address(String state, String region,
                   String city, String localAddress) {
        setState(state);
        setRegion(region);
        setCity(city);
        setLocalAddress(localAddress);
    }

    public Address() {
        this("", "", "", "");
    }

    public Address(Address address) {
        this(address.getState(), address.getRegion(),
                address.getCity(), address.getLocalAddress());
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

    public int hashCode() {
        return (state.hashCode() << 3) + (region.hashCode() << 2)
                + (city.hashCode() << 1) + localAddress.hashCode();
    }

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

}
