package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 21/03/17.
 */
public class VoucherType {
    public String getFullDescription() {
        return toString();
    }
    public List<? extends Place> getPlaces() {
        return new ArrayList<>();
    }
}
