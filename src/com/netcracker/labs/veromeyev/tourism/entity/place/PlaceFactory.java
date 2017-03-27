package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

/**
 * Created by jack on 28/03/17.
 */
public class PlaceFactory {
    @Nullable
    public static Place from(JSONObject o) {
        JsonWithType parser = new JsonWithType(o);
        switch (parser.getType()) {
            case Name.Entity.Place.PLACE:
                return new Place(parser.getInnerObject());
            case Name.Entity.Place.HOTEL:
                return new Hotel(parser.getInnerObject());
            case Name.Entity.Place.MEDICAL_CENTER:
                return new MedicalCenter(parser.getInnerObject());
            case Name.Entity.Place.SHOP:
                return new Shop(parser.getInnerObject());
        }
        return null;
    }
}
