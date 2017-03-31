package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.Main;
import com.netcracker.labs.veromeyev.tourism.constant.Output;
import com.netcracker.labs.veromeyev.tourism.util.Input;
import com.netcracker.labs.veromeyev.tourism.voucherlist.comparator.VoucherComparator;
import com.netcracker.labs.veromeyev.tourism.voucherlist.comparator.VoucherComparatorFactory;

/**
 * Created by jack on 31/03/17.
 *
 * @author Jack Veromeyev
 */
public class SortMenu {

    private boolean exitFlag;
    private Input in;

    public SortMenu() {
        exitFlag = false;
        in = new Input();
    }

    public void launch() {
        while (!exitFlag) {
            System.out.println(Output.SORT_MENU[0]);
            showSortDescription();
            System.out.println(Output.SORT_MENU[1]);
            switch (in.getInt(0, 2)) {
                case 0:
                    exitFlag = true;
                    break;
                case 1:
                    setSort();
                    break;
                case 2:
                    Main.setComparator(null);
                    break;
            }
        }
    }

    private void setSort() {
        System.out.println(Output.SORT_MENU[2]);
        VoucherComparatorFactory factory = new VoucherComparatorFactory();
        switch (in.getInt(0, 2)) {
            case 1:
                Main.setComparator(factory.newCostIncreasingComparator());
                break;
            case 2:
                Main.setComparator(factory.newCostDecreasingComparator());
                break;
            case 0:
            default:
                return;
        }
    }

    private void showSortDescription() {
        VoucherComparator comparator = Main.getComparator();
        if (comparator != null) {
            System.out.println(comparator.getDescription());
        } else {
            System.out.println("none");
        }
    }
}
