package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.VoucherType;

import java.util.Date;

/**
 * Created by jack on 23/03/17.
 */
public class ConcreteVoucher {

    private VoucherType type;
    private int duration;
    private Date start;
    private Feeding feeding;
    private Transport deliveryTransport;

    public ConcreteVoucher(VoucherType type, int duration, Date start,
                           Feeding feeding, Transport deliveryTransport) {

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
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
}