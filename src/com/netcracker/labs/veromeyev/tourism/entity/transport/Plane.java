package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public class Plane extends Transport {

    private boolean hasFirstClass;
    private boolean hasEconomyClass;
    private boolean hasWifi;

    public Plane(String description, double cost, double hoursOnWay,
                 boolean hasFirstClass, boolean hasEconomyClass,
                 boolean hasWifi) {
        super(description, cost, hoursOnWay);
        this.hasWifi = hasWifi;
        this.hasEconomyClass = hasEconomyClass;
        this.hasFirstClass = hasFirstClass;
    }

    public Plane(JSONObject o) {
        super(o);
        this.hasWifi = (Boolean) o.get("Wi-Fi");
        this.hasEconomyClass = (Boolean) o.get("has economy class");;
        this.hasFirstClass = (Boolean) o.get("has first class");;
    }

    public boolean isHasFirstClass() {
        return hasFirstClass;
    }

    public void setHasFirstClass(boolean hasFirstClass) {
        this.hasFirstClass = hasFirstClass;
    }

    public boolean isHasEconomyClass() {
        return hasEconomyClass;
    }

    public void setHasEconomyClass(boolean hasEconomyClass) {
        this.hasEconomyClass = hasEconomyClass;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Plane)) {
            return false;
        }
        Plane plane = (Plane) o;
        return super.equals(o) && hasEconomyClass == plane.isHasEconomyClass()
                && hasWifi == plane.isHasWifi()
                && hasFirstClass == plane.isHasFirstClass();

    }

    @Override
    public int hashCode() {
        return (super.hashCode() << 3) + (BooleanUtil.toInt(hasWifi) << 2)
                + (BooleanUtil.toInt(hasEconomyClass) << 1)
                + BooleanUtil.toInt(hasFirstClass);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Plane: ").append(super.toString());
        builder.append(". First class: ");
        builder.append(BooleanUtil.toYN(hasFirstClass));
        builder.append(", econom class: ");
        builder.append(BooleanUtil.toYN(hasEconomyClass));
        builder.append(", Wi-Fi: ").append(BooleanUtil.toYN(hasWifi));
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = super.toJSONObject();
        object.put("has first class", hasFirstClass);
        object.put("has economy class", hasEconomyClass);
        object.put("Wi-Fi", hasWifi);
        return new JsonWithType(object,
                Name.Entity.Transport.PLANE).getObject();
    }
}
