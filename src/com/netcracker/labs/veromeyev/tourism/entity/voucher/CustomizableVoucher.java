package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.VoucherType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 23/03/17.
 */
public class CustomizableVoucher implements JSONable {

    private VoucherType type;
    private List<Integer> availableDuration;
    private List<LocalDateTime> availableStart;
    private List<Feeding> availableFeeding;
    private List<Transport> availableDeliveryTransport;

    public CustomizableVoucher(VoucherType voucherType,
                               List<Integer> availableDuration,
                               List<LocalDateTime> availableStart,
                               List<Feeding> availableFeeding,
                               List<Transport> availableDeliveryTransport) {
        this.type = voucherType;
        this.availableDuration = availableDuration;
        this.availableStart = availableStart;
        this.availableFeeding = availableFeeding;
        this.availableDeliveryTransport = availableDeliveryTransport;
    }

    public CustomizableVoucher(JSONObject o) {
        EntityFactory factory = new EntityFactory();

        type = factory.newVoucherType((JSONObject) o.get("type"));

        JSONArray durationArray = (JSONArray) o.get("available duration");
        availableDuration = new ArrayList<>(durationArray.size());
        for (Object duration : durationArray) {
            availableDuration.add((Integer) duration);
        }

        JSONArray startArray = (JSONArray) o.get("available start");
        availableStart = new ArrayList<>(startArray.size());
        for (Object start : startArray) {
            availableStart.add((LocalDateTime) start);
        }

        JSONArray feedingArray = (JSONArray) o.get("available feeding");
        availableFeeding = new ArrayList<>(feedingArray.size());
        for (Object feeding : feedingArray) {
            availableFeeding.add(new  Feeding((JSONObject) feeding));
        }

        JSONArray transportArray =
                (JSONArray) o.get("available delivery transport");
        availableDeliveryTransport = new ArrayList<>(transportArray.size());
        for (Object transport : transportArray) {
            availableDeliveryTransport.add(
                    factory.newTransport((JSONObject) transport)
            );
        }
    }

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public List<Integer> getAvailableDuration() {
        return availableDuration;
    }

    public void setAvailableDuration(List<Integer> availableDuration) {
        this.availableDuration = availableDuration;
    }

    public List<LocalDateTime> getAvailableStart() {
        return availableStart;
    }

    public void setAvailableStart(List<LocalDateTime> availableStart) {
        this.availableStart = availableStart;
    }

    public List<Feeding> getAvailableFeeding() {
        return availableFeeding;
    }

    public void setAvailableFeeding(List<Feeding> availableFeeding) {
        this.availableFeeding = availableFeeding;
    }

    public List<Transport> getAvailableDeliveryTransport() {
        return availableDeliveryTransport;
    }

    public void setAvailableDeliveryTransport(
            List<Transport> availableDeliveryTransport) {
        this.availableDeliveryTransport = availableDeliveryTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomizableVoucher)) {
            return false;
        }
        CustomizableVoucher voucher = (CustomizableVoucher) o;
        return type.equals(voucher.getType())
                && availableDeliveryTransport.equals(
                        voucher.getAvailableDeliveryTransport())
                && availableDuration.equals(voucher.getAvailableDuration())
                && availableStart.equals(voucher.getAvailableStart())
                && availableFeeding.equals(voucher.getAvailableFeeding());
    }

    @Override
    public int hashCode() {
        return (type.hashCode() << 4)
                + (availableDeliveryTransport.hashCode() << 3)
                + (availableDuration.hashCode() << 2)
                + (availableStart.hashCode() << 1)
                + availableFeeding.hashCode();
    }


    @Override
    public JSONObject toJSONObject() {
        JSONObject o = new JSONObject();
        o.put("type", type.toJSONObject());

        JSONArray durationArray = new JSONArray();
        for (int duration : availableDuration) {
            durationArray.add(duration);
        }
        o.put("available duration", durationArray);

        JSONArray startArray = new JSONArray();
        for (LocalDateTime start : availableStart) {
            startArray.add(start);
        }
        o.put("available start", startArray);

        JSONArray feedingArray = new JSONArray();
        for (Feeding feeding : availableFeeding) {
            feedingArray.add(feeding.toJSONObject());
        }
        o.put("available feeding", feedingArray);

        JSONArray transportArray = new JSONArray();
        for (Transport transport : availableDeliveryTransport) {
            transportArray.add(transport.toJSONObject());
        }
        o.put("available delivery transport", transportArray);

        return o;
    }
}
