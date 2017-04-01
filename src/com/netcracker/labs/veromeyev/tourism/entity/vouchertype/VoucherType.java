package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.JSONable;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import org.json.simple.JSONObject;

import java.util.List;

public interface VoucherType extends JSONable {

    String getFullDescription();

    List<? extends Place> getPlaces();

    @Override
    JSONObject toJSONObject();
}
