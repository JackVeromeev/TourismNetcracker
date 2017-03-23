package com.netcracker.labs.veromeyev.tourism.entity.transport;

/**
 * Created by jack on 23/03/17.
 */
public abstract class Transport {

    private double cost;
    private double hoursOnWay;
    private String description;

    public Transport(String description, double cost, double hoursOnWay) {
        setDescription(description);
        setHoursOnWay(hoursOnWay);
        setCost(cost);
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

    public int hashCode() {
        return (description.hashCode() << 2) + ((int)cost << 1)
        + (int) hoursOnWay;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(description);
        builder.append("\ncost: ").append(getCost());
        builder.append("; time on the way: ").append(getHoursOnWay());
        builder.append(" hours;");
        return builder.toString();
    }
}
