package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;

/**
 * Created by jack on 23/03/17.
 */
public class Plane extends Transport {

    private boolean hasFirstClass;
    private boolean hasEconomClass;
    private boolean hasWifi;

    public Plane(String description, double cost, double hoursOnWay,
                 boolean hasFirstClass, boolean hasEconomClass,
                 boolean hasWifi) {
        super(description, cost, hoursOnWay);
        setHasWifi(hasWifi);
        setHasEconomClass(hasEconomClass);
        setHasFirstClass(hasFirstClass);
    }


    public boolean isHasFirstClass() {
        return hasFirstClass;
    }

    public void setHasFirstClass(boolean hasFirstClass) {
        this.hasFirstClass = hasFirstClass;
    }

    public boolean isHasEconomClass() {
        return hasEconomClass;
    }

    public void setHasEconomClass(boolean hasEconomClass) {
        this.hasEconomClass = hasEconomClass;
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
        if (!(o instanceof Plane)) {
            return false;
        }
        Plane plane = (Plane) o;
        return super.equals(o) && hasEconomClass == plane.isHasEconomClass()
                && hasWifi == plane.isHasWifi()
                && hasFirstClass == plane.isHasFirstClass();

    }

    public int hashCode() {
        return (super.hashCode() << 3) + (BooleanUtil.toInt(hasWifi) << 2)
                + (BooleanUtil.toInt(hasEconomClass) << 1)
                + BooleanUtil.toInt(hasFirstClass);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Plane: ").append(super.toString());
        builder.append("\nFirst class: ");
        builder.append(BooleanUtil.toYN(hasFirstClass));
        builder.append(", econom class: ");
        builder.append(BooleanUtil.toYN(hasEconomClass));
        builder.append(", Wi-Fi: ").append(BooleanUtil.toYN(hasWifi));
        return builder.toString();
    }
}
