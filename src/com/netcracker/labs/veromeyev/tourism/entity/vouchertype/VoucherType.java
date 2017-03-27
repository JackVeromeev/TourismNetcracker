package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.JsonImpl;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by jack on 21/03/17.
 */
public interface VoucherType extends JsonImpl{

    String getFullDescription();

    List<? extends Place> getPlaces();

    @Override
    JSONObject toJSONObject();
}
