package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.VoucherType;

import java.util.Date;
import java.util.List;

/**
 * Created by jack on 23/03/17.
 */
public class Voucher {

    private VoucherType type;
    private List<Integer> availableDurations;
    private List<Date> availableStarts;
    private List<Feeding> availableFeeding;
    private List<Transport> availableDeliveryTransports;
    private boolean usingTransportWhileTour;
    private Transport transportWhileTour;

    public Voucher(VoucherType voucherType, List<Integer> availableDurations,
                   List<Date> availableStarts, List<Feeding> availableFeeding,
                   List<Transport> availableDeliveryTransports,
                   boolean usingTransportWhileTour,
                   Transport transportWhileTour) {
        setType(voucherType);
        setAvailableDurations(availableDurations);
        setAvailableStarts(availableStarts);
        setAvailableFeeding(availableFeeding);
        setAvailableDeliveryTransports(availableDeliveryTransports);
        setUsingTransportWhileTour(usingTransportWhileTour);
        setTransportWhileTour(transportWhileTour);
    }

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public List<Integer> getAvailableDurations() {
        return availableDurations;
    }

    public void setAvailableDurations(List<Integer> availableDurations) {
        this.availableDurations = availableDurations;
    }

    public List<Date> getAvailableStarts() {
        return availableStarts;
    }

    public void setAvailableStarts(List<Date> availableStarts) {
        this.availableStarts = availableStarts;
    }

    public List<Feeding> getAvailableFeeding() {
        return availableFeeding;
    }

    public void setAvailableFeeding(List<Feeding> availableFeeding) {
        this.availableFeeding = availableFeeding;
    }

    public List<Transport> getAvailableDeliveryTransports() {
        return availableDeliveryTransports;
    }

    public void setAvailableDeliveryTransports(
            List<Transport> availableDeliveryTransports) {
        this.availableDeliveryTransports = availableDeliveryTransports;
    }

    public boolean isUsingTransportWhileTour() {
        return usingTransportWhileTour;
    }

    public void setUsingTransportWhileTour(boolean usingTransportWhileTour) {
        this.usingTransportWhileTour = usingTransportWhileTour;
    }

    public Transport getTransportWhileTour() {
        return transportWhileTour;
    }

    public void setTransportWhileTour(Transport transportWhileTour) {
        this.transportWhileTour = transportWhileTour;
    }
}