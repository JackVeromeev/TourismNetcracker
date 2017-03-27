package com.netcracker.labs.veromeyev.tourism;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.place.Hotel;
import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.place.Shop;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Bus;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Plane;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.*;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


class Main {

    static void initVoucher() {
        CustomizableVoucher v = new CustomizableVoucher(
                new Cruise(
                        "Dniper",
                        new Place("Belarus", "Mogilev", "Mogilev",
                                "prichar", "prichal", ""),
                        new Place("Belarus", "Gomel", "Rogachev",
                                "plyazh", "kupala", "near tree"),
                        new ArrayList<String>() {{ add("Dniper river"); }},
                        new Ship("simple parom", 20, 40, 1, false)
                ),
                new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                }},
                new ArrayList<Date>() {{
                    add(new Date());
                }},
                new ArrayList<Feeding>() {{
                    add(new Feeding(false, 10, "meat and river fish"));
                }},
                new ArrayList<Transport>() {{
                    add(new Bus("simple bus", 10, 2,
                            false, false, true));
                }}
        );
    }

    static void testToJSON() {
        JSONObject o = new Hotel(new Place("Belarus", "Gomel", "Rogachev",
                "78, Stepanova st.", "Home",
                "sweet home"),
                "hostel", 5, 0, 200)
                .toJSONObject();
        System.out.println(o.toString());
        System.out.println(o.toJSONString());

        JSONObject shop = new MedicalCenter(new Place("Belarus", "Gomel", "Rogachev",
                "78, Stepanova st.", "Home",
                "sweet home"),
                new ArrayList<String>() {{
                    add("headache");
                    add("back");
                }}
        )
                .toJSONObject();
        System.out.println(shop.toJSONString() + "\n");
    }

    static void testTransport() {
        Transport[] tr = new Transport[] {
                new Bus("just bus", 20, 2, false, true, false),
                new Ship("shippp", 40, 48, 2, false),
                new Plane("Boeing 737", 80, 3, false, true, false)
        };
        for (Transport t : tr) {
            System.out.println(t.toJSONObject().toJSONString());
        }
    }

    static void testVoucherType() {
        VoucherType[] types = new VoucherType[] {
                new Cruise("Dniper", new Place("Belarus", "Gomel", "Orsha",
                        "near BMD1", "prichal", "warm water"),
                        new Place("Belarus", "Gomel", "Rogachev",
                                "plyazh", "kupala", "near tree"),
                        new ArrayList<String>() {{
                            add("Dniper");
                        }},
                        new Ship("simple ship", 50, 24*5, 2, false)
                ),

                new Excursion("Golden ring of Belarus", "Ales' Dzyatsenak",
                        new ArrayList<Place>() {{
                            add(new Place("Belarus", "Grodno", "Mir",
                                    "near Mir", "Mir castle", "Beautiful castle!"));
                            add(new Place("Belarus", "Gomel", "Rogachev",
                                    "plyazh", "kupala", "near tree"));
                        }}
                ),

                new Recreation(new Hotel(new Place("Belarus", "Gomel", "Rogachev",
                        "78, Stepanova st.", "Home",
                        "sweet home"),
                        "hostel", 5, 0, 200)
                ),

                new Shopping(new ArrayList<Shop>() {{
                    add(new Shop(new Place("Belarus", "Gomel", "Rogachev",
                            "5, Parish Commune st.", "Dzevyatki",
                            "a little one"),
                            new ArrayList<String>() {{
                                add("Socks");
                                add("Cups");
                            }}));
                    add(new Shop(new Place("Belarus", "Gomel", "Rogachev",
                            "20, Lenin st.", "Moscow's",
                            "a big one"),
                            new ArrayList<String>() {{
                                add("Honey");
                                add("sweets");
                            }}));
                }}),

                new Treatment(new MedicalCenter(
                        new Place("Belarus", "Gomel", "Rogachev",
                                "15 km from city", "Pridneprovsky",
                                "in beautiful sosna forest"),
                        new ArrayList<String>() {{
                            add("gorlo");
                            add("heart");
                        }}
                ))
        };

        System.out.println("\n\n");
        for (VoucherType type : types) {
            System.out.println(type.toJSONObject().toString());
        }

        LocalDateTime ld = LocalDateTime.of(2017, 12, 20, 12, 20);
        JSONObject dtJSON = new JSONObject();
        dtJSON.put("date and time", ld);
        System.out.println(dtJSON.toJSONString());
    }

    static void jsoningShop() {
        Place s = new Shop(new Place("Belarus", "Gomel", "Rogachev",
                "5, Parish Commune st.", "Dzevyatki",
                "a little one"),
                new ArrayList<String>() {{
                    add("Socks");
                    add("Cups");
                }});
        System.out.println(s.toJSONObject().toJSONString());


        JSONObject parsed = s.toJSONObject();


        System.out.println(parsed);
        JSONObject parsedShop = new JsonWithType(parsed).getInnerObject();
        System.out.println(parsedShop);
        JSONArray list = (JSONArray) parsedShop.get("stock");
        System.out.println(list.get(0));

        Shop ss = new Shop(parsedShop);
        System.out.println(ss);
    }



    public static void main(String[] args) {
        Place s = new MedicalCenter(new Place("Belarus", "Gomel", "Rogachev",
                "5, Parish Commune st.", "Dzevyatki",
                "a little one"),
                new ArrayList<String>() {{
                    add("head");
                    add("bones");
                }});
        System.out.println(s.toJSONObject().toJSONString());


        JSONObject parsed = s.toJSONObject();


        System.out.println(parsed);
        JSONObject parsedShop = new JsonWithType(parsed).getInnerObject();
        System.out.println(parsedShop);

        MedicalCenter ss = new MedicalCenter(parsedShop);
        System.out.println(ss);

    }

}
