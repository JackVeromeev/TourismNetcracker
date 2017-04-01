package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Shopping implements VoucherType {

    private List<Shop> shops;

    public Shopping(List<Shop> shops) {
        this.shops = shops;
    }

    public Shopping() {
        this(new ArrayList<>());
    }

    public Shopping(JSONObject o) {
        EntityFactory factory = new EntityFactory();
        JSONArray shopArray = (JSONArray) o.get("shops");
        shops = new ArrayList<>(shopArray.size());
        for (Object shop : shopArray) {
            shops.add((Shop)factory.newPlace((JSONObject)shop));
        }
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        if (shops == null) {
            shops = new ArrayList<>();
        }
        this.shops = shops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shopping)) {
            return false;
        }
        return shops.equals( ((Shopping) o).getShops() );
    }

    @Override
    public int hashCode() {
        return shops.hashCode();
    }

    @Override
    public String toString() {
        if (shops.size() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Shopping at");
        if (shops.size() == 1) {
            builder.append(" ").append(shops.get(0));
        } else {
            builder.append(":");
            for (Shop shop : shops) {
                builder.append("\n      ").append(shop.toString());
            }
        }
        return builder.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Shop> getPlaces() {
        return shops;
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        for (Shop shop : shops) {
            array.add(shop.toJSONObject());
        }
        object.put("shops", array);
        return new JsonWithType(object,
                Name.Entity.VoucherType.SHOPPING).getObject();
    }
}
