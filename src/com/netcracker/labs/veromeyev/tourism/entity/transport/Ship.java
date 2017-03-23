package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;

/**
 * Created by jack on 23/03/17.
 */
public class Ship extends Transport {

    private int decksAmount;
    private boolean hasPool;

    public Ship(String description, double cost, double hoursOnWay) {
        super(description, cost, hoursOnWay);
    }

    public int getDecksAmount() {
        return decksAmount;
    }

    public void setDecksAmount(int decksAmount) {
        this.decksAmount = decksAmount;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ship)) {
            return false;
        }
        Ship ship = (Ship) o;
        return super.equals(o) && hasPool == ship.isHasPool()
                && decksAmount == ship.getDecksAmount();

    }

    public int hashCode() {
        return (super.hashCode() << 2) + (BooleanUtil.toInt(hasPool) << 1)
                + decksAmount;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ship: ").append(super.toString());
        builder.append("\nPool: ");
        builder.append(BooleanUtil.toYN(hasPool));
        builder.append(", ");
        builder.append(decksAmount);
        builder.append(" decks");
        return builder.toString();
    }
}
