package com.netcracker.labs.veromeyev.tourism.util.json;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class JSONFileHandler {

    public static final String FILE_NAME = "customizable vouchers.json";

    public ArrayList<CustomizableVoucher> readFile() {
        ArrayList<CustomizableVoucher> list = new ArrayList<>();
        JSONArray array;
        try {
            JSONParser parser = new JSONParser();
            array = (JSONArray) parser.parse(new FileReader(FILE_NAME));
            for (Object o : array) {
                list.add(new CustomizableVoucher((JSONObject) o));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(ArrayList<CustomizableVoucher> list) {
        JSONArray array = new JSONArray();
        for (CustomizableVoucher voucher : list) {
            array.add(voucher.toJSONObject());
        }
        try (FileWriter file = new FileWriter(FILE_NAME)) {

            file.write(array.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
