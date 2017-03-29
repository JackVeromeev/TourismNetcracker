package com.netcracker.labs.veromeyev.tourism.entity;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Bus;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Plane;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.*;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

/**
 * Created by jack on 28/03/17.
 */
public class EntityFactory {
    @Nullable
    public Place newPlace(JSONObject o) {
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

    @Nullable
    public Transport newTransport(JSONObject o) {
        JsonWithType parser = new JsonWithType(o);
        switch (parser.getType()) {
            case Name.Entity.Transport.SHIP:
                return new Ship(parser.getInnerObject());
            case Name.Entity.Transport.PLANE:
                return new Plane(parser.getInnerObject());
            case Name.Entity.Transport.BUS:
                return new Bus(parser.getInnerObject());
        }
        return null;
    }

    @Nullable
    public VoucherType newVoucherType(JSONObject o) {
        JsonWithType parser = new JsonWithType(o);
        switch (parser.getType()) {
            case Name.Entity.VoucherType.CRUISE:
                return new Cruise(parser.getInnerObject());
            case Name.Entity.VoucherType.EXCURSION:
                return new Excursion(parser.getInnerObject());
            case Name.Entity.VoucherType.RECREATION:
                return new Recreation(parser.getInnerObject());
            case Name.Entity.VoucherType.SHOPPING:
                return new Shopping(parser.getInnerObject());
            case Name.Entity.VoucherType.TREATMENT:
                return new Treatment(parser.getInnerObject());
        }
        return null;
    }
}
