package com.netcracker.labs.veromeyev.tourism;

import com.netcracker.labs.veromeyev.tourism.menu.MainMenu;
import com.netcracker.labs.veromeyev.tourism.util.json.JSONFileHandler;
import com.netcracker.labs.veromeyev.tourism.voucherlist.VoucherList;
import com.netcracker.labs.veromeyev.tourism.voucherlist.comparator.VoucherComparator;
import com.netcracker.labs.veromeyev.tourism.voucherlist.filter.ComplexVoucherFilter;

public class Main {
    private static ComplexVoucherFilter filter;
    private static VoucherComparator comparator;
    private static VoucherList customizableVouchers;

    public static void main(String[] args) {
        filter = new ComplexVoucherFilter();
        comparator = null;
        customizableVouchers =
                new VoucherList(new JSONFileHandler().readFile());
        MainMenu mainMenu = new MainMenu();
        mainMenu.launch();

    }

    public static ComplexVoucherFilter getFilter() {
        return filter;
    }

    public static VoucherComparator getComparator() {
        return comparator;
    }

    public static void setComparator(VoucherComparator comparator) {
        Main.comparator = comparator;
    }

    public static VoucherList getCustomizableVouchers() {
        return customizableVouchers;
    }
}
