package com.netcracker.labs.veromeyev.tourism.entity.place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Shop extends Place {

    private List<String> stock;

    public Shop(Address address, String shopName, String description,
                List<String> stock) {
        setAddress(address);
        setPlaceName(shopName);
        setDescription(description);
        setStock(stock);
    }

    public Shop(Shop shop) {
        this(shop.getAddress(), shop.getPlaceName(),
                shop.getDescription(), shop.getStock());
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

    public int hashCode() {
        return (super.hashCode() << 1) + stock.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (placeName.length() > 0) {
            builder.append("Shop ");
        }
        builder.append(super.toString());
        if (stock.size() > 0) {
            builder.append(" Stock: ");
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
}
