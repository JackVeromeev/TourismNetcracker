package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.BooleanUtil;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

/**
 * Created by jack on 23/03/17.
 */
public class Ship extends Transport {

    private int decksAmount;
    private boolean hasPool;

    public Ship(String description, double cost, double hoursOnWay,
                int decksAmount, boolean hasPool) {
        super(description, cost, hoursOnWay);
        this.decksAmount = decksAmount;
        this.hasPool = hasPool;
    }

    public Ship(JSONObject o) {
        super(o);
        this.decksAmount = ((Long) o.get("amount of decks")).intValue();
        this.hasPool = (Boolean) o.get("has pool");
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

    @Override
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

    @Override
    public int hashCode() {
        return (super.hashCode() << 2) + (BooleanUtil.toInt(hasPool) << 1)
                + decksAmount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ship: ").append(super.toString());
        builder.append(" Pool: ");
        builder.append(BooleanUtil.toYN(hasPool));
        builder.append("; ");
        builder.append(decksAmount);
        builder.append(" deck(s)");
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject object = super.toJSONObject();
        object.put("has pool", hasPool);
        object.put("amount of decks", decksAmount);
        return new JsonWithType(object,
                Name.Entity.Transport.SHIP).getObject();
    }
}
