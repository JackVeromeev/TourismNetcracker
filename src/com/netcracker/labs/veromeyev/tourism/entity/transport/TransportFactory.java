package com.netcracker.labs.veromeyev.tourism.entity.transport;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

/**
 * Created by jack on 28/03/17.
 */
public class TransportFactory {
    @Nullable
    public static Transport from(JSONObject o) {
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
}
