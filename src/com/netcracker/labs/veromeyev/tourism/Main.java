package com.netcracker.labs.veromeyev.tourism;

import com.google.gson.Gson;
import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Bus;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.Voucher;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.Cruise;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Gson gsonKEK = new Gson();
        Voucher v = new Voucher(
                new Cruise(
                        "Dniper",
                        new Place("Belarus", "Mogilev", "Mogilev",
                                "prichar", "prichal", ""),
                        new Place("Belarus", "Gomel", "Rogachev",
                                "plyazh", "kupala", "near tree"),
                        new ArrayList<String>() {{ add("Dniper river"); }}
                        ),
                new ArrayList<Integer>() {{
                    add(new Integer(1));
                    add(new Integer(2));
                }},
                new ArrayList<Date>() {{
                    add(new Date(2017, 10, 28));
                }},
                new ArrayList<Feeding>() {{
                    add(new Feeding(false, 10, "meat and river fish"));
                }},
                new ArrayList<Transport>() {{
                    add(new Bus("simple bus", 10, 2,
                            false, false, true));
                }},
                true,
                new Ship("simple parom", 20, 40)
        );

        String jsonString = gsonKEK.toJson(v);

        File outFile = new File("LOL.json");
        try {
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(outFile.getAbsoluteFile());
            try {
                out.println(jsonString);
            } finally {
                out.close();
            }
        } catch (IOException ioe) {
            System.err.println("FUUCK");
            ioe.printStackTrace();
        }

        if (outFile.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(outFile.getAbsoluteFile()));
                try {
                    jsonString = in.readLine();
                } finally {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(jsonString);
        v = gsonKEK.fromJson(jsonString, v.getClass());
        System.out.println(v.getType().getFullDescription());
    }

}
