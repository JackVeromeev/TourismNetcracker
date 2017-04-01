package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Place {

    private List<String> stock;

    public Shop(Address address, String shopName, String description,
                List<String> stock) {
        super( address, shopName, description);
        this.stock = stock;
    }

    public Shop(Place place, List<String> stock) {
        super(place);
        this.stock = stock;
    }

    public Shop(Shop shop) {
        this(shop.getAddress(), shop.getPlaceName(),
                shop.getDescription(), shop.getStock());
    }

    public Shop(JSONObject o) {
        super(o);
        JSONArray jsonStock = (JSONArray) o.get("stock");
        stock = new ArrayList<>( jsonStock.size());
        for (Object type : jsonStock) {
            stock.add((String) type);
        }
    }

    public Shop() {
        this(new Address(), "", "", new ArrayList<>());
    }

    public List<String> getStock() {
        return stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shop)) {
            return false;
        }
        Shop shop = (Shop) o;
        return super.equals(o) && stock.equals(shop.getStock());
    }

    @Override
    public int hashCode() {
        return (super.hashCode() << 1) + stock.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (placeName.length() > 0) {
            builder.append("Shop ");
        }
        builder.append(super.toString());
        if (stock.size() > 0) {
            builder.append(". Stock: ");
            boolean firstElement = true;
            for (String thingType : stock) {
                if (firstElement) {
                    firstElement = false;
                } else {
                    builder.append(", ");
                }
                builder.append(thingType);
            }
        }
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        JsonWithType objectWithType = new JsonWithType(super.toJSONObject());
        JSONArray stockArray = new JSONArray();
        for (String type : stock) {
            stockArray.add(type);
        }
        objectWithType.getInnerObject().put("stock", stockArray);
       /*
        * override type of superclass
        */
        objectWithType.setType(Name.Entity.Place.SHOP);
        return objectWithType.getObject();
    }
}
