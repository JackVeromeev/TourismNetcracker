package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.VoucherType;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;

/**
 * Created by jack on 23/03/17.
 */
public class ConcreteVoucher implements JSONable{

    private VoucherType type;
    private int duration;
    private LocalDateTime start;
    private Feeding feeding;
    private Transport deliveryTransport;
    private double costPerDay;

    public ConcreteVoucher(VoucherType type, int duration, LocalDateTime start,
                           Feeding feeding, Transport deliveryTransport,
                           double costPerDay) {
        this.type = type;
        this.duration = duration;
        this.start = start;
        this.feeding = feeding;
        this.deliveryTransport = deliveryTransport;
        this.costPerDay = costPerDay;
    }

    public ConcreteVoucher(CustomizableVoucher voucher,
                           int durationNum, int startNum,
                           int feedingNum, int transportNum) {
        this.type = voucher.getType();
        this.duration = voucher.getAvailableDuration().get(durationNum);
        this.start = voucher.getAvailableStart().get(startNum);
        this.feeding = voucher.getAvailableFeeding().get(feedingNum);
        this.deliveryTransport =
                voucher.getAvailableDeliveryTransport().get(transportNum);
        this.costPerDay = voucher.getCostPerDay();
    }

    public ConcreteVoucher(JSONObject o) {
        EntityFactory factory = new EntityFactory();
        this.type = factory.newVoucherType((JSONObject) o.get("type"));
        this.duration = ((Long) o.get("duration")).intValue();
        this.start = LocalDateTime.parse((String) o.get("start"));
        this.feeding = new Feeding((JSONObject) o.get("feeding"));
        this.deliveryTransport =
                factory.newTransport((JSONObject) o.get("delivery transport"));
        this.costPerDay = (Double) o.get("cost per day");
    }

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Feeding getFeeding() {
        return feeding;
    }

    public void setFeeding(Feeding feeding) {
        this.feeding = feeding;
    }

    public Transport getDeliveryTransport() {
        return deliveryTransport;
    }

    public void setDeliveryTransport(Transport deliveryTransport) {
        this.deliveryTransport = deliveryTransport;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public double getTotalCost() {
        return duration * (costPerDay + feeding.getCostPerDay())
                + deliveryTransport.getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConcreteVoucher)) {
            return false;
        }
        ConcreteVoucher voucher = (ConcreteVoucher) o;
        return type.equals(voucher.getType())
                && deliveryTransport.equals(voucher.getDeliveryTransport())
                && duration == voucher.getDuration()
                && start.equals(voucher.getStart())
                && feeding.equals(voucher.getFeeding());
    }

    @Override
    public int hashCode() {
        return (type.hashCode() << 4)
                + (deliveryTransport.hashCode() << 3)
                + (duration << 2)
                + (start.hashCode() << 1)
                + feeding.hashCode();
    }


    @Override
    public JSONObject toJSONObject() {
        JSONObject o = new JSONObject();
        o.put("type", type.toJSONObject());

        o.put("duration", duration);

        o.put("start", start.toString());

        o.put("feeding", feeding.toJSONObject());

        o.put("delivery transport", deliveryTransport.toJSONObject());

        o.put("cost per day", costPerDay);
        return o;
    }

}