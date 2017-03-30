package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public abstract class Transport implements JSONable {

    private double cost;
    private double hoursOnWay;
    private String description;

    public Transport(String description, double cost, double hoursOnWay) {
        this.description = description;
        this.hoursOnWay = hoursOnWay;
        this.cost = cost;
    }

    public Transport(JSONObject o) {
        this((String)o.get("description"), (Double) o.get("cost"),
                (Double)o.get("hours on way"));
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getHoursOnWay() {
        return hoursOnWay;
    }

    public void setHoursOnWay(double hoursOnWay) {
        this.hoursOnWay = hoursOnWay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) o;
        return description.equals(transport.getDescription())
                && cost == transport.getCost()
                && hoursOnWay == transport.getHoursOnWay();
    }

    @Override
    public int hashCode() {
        return (description.hashCode() << 2) + ((int)cost << 1)
        + (int) hoursOnWay;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(description);
        builder.append(", cost: ").append(getCost());
        builder.append("; time on the way: ").append(getHoursOnWay());
        builder.append(" hours;");
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("cost", cost);
        object.put("hours on way", hoursOnWay);
        object.put("description", description);
        return object;
    }
}
