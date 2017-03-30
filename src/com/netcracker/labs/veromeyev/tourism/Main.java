package com.netcracker.labs.veromeyev.tourism;


import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import com.netcracker.labs.veromeyev.tourism.util.json.JSONFileHandler;

import java.util.List;

class Main {


    public static void main(String[] args) {
        //VoucherList all = new VoucherList(new JSONFileHandler().readFile());


        List<CustomizableVoucher> l = new JSONFileHandler().readFile();
        for (CustomizableVoucher v : l) {
            System.out.println(v.toString() + "\n\n");
        }
    }

}
