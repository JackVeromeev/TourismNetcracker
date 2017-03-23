package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;

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
        setHasToilet(hasToilet);
        setHasTV(hasTV);
        setHasWifi(hasWifi);
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

    public int hashCode() {
        return (super.hashCode() << 3) + (BooleanUtil.toInt(hasWifi) << 2)
        + (BooleanUtil.toInt(hasToilet) << 1) + BooleanUtil.toInt(hasTV);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bus: ").append(super.toString());
        builder.append("\nTV: ").append(BooleanUtil.toYN(hasTV));
        builder.append(", toilet: ").append(BooleanUtil.toYN(hasToilet));
        builder.append(", Wi-Fi: ").append(BooleanUtil.toYN(hasWifi));
        return builder.toString();
    }

}
