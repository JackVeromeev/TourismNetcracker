package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Shopping extends VoucherType {

    private List<Shop> shops;

    public Shopping(List<Shop> shops) {
        setShops(shops);
    }

    public Shopping() {
        this(null);
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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shopping)) {
            return false;
        }
        return shops.equals( ((Shopping) o).getShops() );
    }

    public int hashCode() {
        return shops.hashCode();
    }

    public String toString() {
        if (shops.size() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Shopping at");
        if (shops.size() == 1) {
            builder.append(" ").append(shops.get(0));
        } else {
            for (Shop shop : shops) {
                builder.append("\n").append(shop.toString());
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
        return getShops();
    }
}
