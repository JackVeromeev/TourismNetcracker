package com.netcracker.labs.veromeyev.tourism.entity.feeding;

import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public class Feeding implements JSONable {

    private boolean vegetarian;
    private double costPerDay;
    private String description;

    public Feeding(boolean vegetarian, double costPerDay, String description) {
        this.vegetarian = vegetarian;
        this.costPerDay = costPerDay;
        this.description = description;
    }

    public Feeding(JSONObject o) {
        this.vegetarian = (Boolean) o.get("vegetarian");
        this.costPerDay = (Double) o.get("cost per day");
        this.description = (String) o.get("description");
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
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
        if (!(o instanceof Feeding)) {
            return false;
        }
        Feeding feeding = (Feeding) o;
        return description.equals(feeding.getDescription())
                && costPerDay == feeding.getCostPerDay()
                && vegetarian == feeding.isVegetarian();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("description", description);
        object.put("cost per day", costPerDay);
        object.put("vegetarian", vegetarian);
        return object;
    }

    @Override
    public String toString() {
        return description + ", vegetarian: " + BooleanUtil.toYN(vegetarian)
                +", cost per day: " + costPerDay;
    }

    @Override
    public int hashCode() {
        return (description.hashCode() << 2)
                + (((int) costPerDay) << 1)
                + BooleanUtil.toInt(vegetarian);
    }
}
