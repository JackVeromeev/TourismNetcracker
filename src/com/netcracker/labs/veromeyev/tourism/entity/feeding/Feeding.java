package com.netcracker.labs.veromeyev.tourism.entity.feeding;

import com.netcracker.labs.veromeyev.tourism.entity.JsonImpl;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public class Feeding implements JsonImpl{

    private boolean vegetarian;
    private double costPerDay;
    private String description;

    public Feeding(boolean vegetarian, double costPerDay, String description) {
        setVegetarian(vegetarian);
        setCostPerDay(costPerDay);
        setDescription(description);
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
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("description", description);
        object.put("cost per day", Double.toString(costPerDay));
        object.put("vegetarian", Boolean.toString(vegetarian));
        return object;
    }
}
