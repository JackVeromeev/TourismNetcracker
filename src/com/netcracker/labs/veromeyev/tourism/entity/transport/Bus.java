package com.netcracker.labs.veromeyev.tourism.entity.transport;


import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public class Bus extends Transport {

    private boolean hasTV;
    private boolean hasToilet;
    private boolean hasWifi;

    public Bus(String description, double cost, double hoursOnWay,
               boolean hasToilet, boolean hasTV, boolean hasWifi) {
        super(description, cost, hoursOnWay);
        this.hasToilet = hasToilet;
        this.hasTV = hasTV;
        this.hasWifi = hasWifi;
    }

    public Bus(JSONObject o) {
        super(o);
        this.hasToilet = (Boolean) o.get("toilet");
        this.hasTV = (Boolean) o.get("TV");
        this.hasWifi = (Boolean) o.get("Wi-Fi");
    }

    public boolean isHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean isHasToilet() {
        return hasToilet;
    }

    public void setHasToilet(boolean hasToilet) {
        this.hasToilet = hasToilet;
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
        if (!(o instanceof Bus)) {
            return false;
        }
        Bus bus = (Bus) o;
        return super.equals(o) && hasToilet == bus.isHasToilet()
                && hasWifi == bus.isHasWifi() && hasTV == bus.isHasTV();
    }

    @Override
    public int hashCode() {
        return (super.hashCode() << 3) + (BooleanUtil.toInt(hasWifi) << 2)
        + (BooleanUtil.toInt(hasToilet) << 1) + BooleanUtil.toInt(hasTV);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bus: ").append(super.toString());
        builder.append("\nTV: ").append(BooleanUtil.toYN(hasTV));
        builder.append(", toilet: ").append(BooleanUtil.toYN(hasToilet));
        builder.append(", Wi-Fi: ").append(BooleanUtil.toYN(hasWifi));
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = super.toJSONObject();
        object.put("TV", hasTV);
        object.put("toilet", hasToilet);
        object.put("Wi-Fi", hasWifi);
        return new JsonWithType(object, Name.Entity.Transport.BUS).getObject();
    }
}
