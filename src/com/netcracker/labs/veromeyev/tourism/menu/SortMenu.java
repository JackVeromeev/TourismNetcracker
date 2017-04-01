package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.Main;
import com.netcracker.labs.veromeyev.tourism.constant.Output;
import com.netcracker.labs.veromeyev.tourism.util.Input;
import com.netcracker.labs.veromeyev.tourism.voucherlist.comparator.VoucherComparator;
import com.netcracker.labs.veromeyev.tourism.voucherlist.comparator.VoucherComparatorFactory;

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
            switch (in.getInt(0, 1)) {
                case 0:
                    exitFlag = true;
                    break;
                case 1:
                    setSort();
                    break;
            }
        }
    }

    private void setSort() {
        System.out.println(Output.SORT_MENU[2]);
        VoucherComparatorFactory factory = new VoucherComparatorFactory();
        switch (in.getInt(0, 3)) {
            case 1:
                Main.setComparator(factory.newCostIncreasingComparator(
                        chooseDirection()));
                break;
            case 2:
                Main.setComparator(factory.newMinimalDurationComparator(
                        chooseDirection()));
                break;
            case 3:
                Main.setComparator(factory.newMaximalDurationComparator(
                        chooseDirection()));
                break;
            case 0:
            default:
                return;
        }
    }

    /**
     * chooses a direction of sorting
     * @return true if in increasing order, false if in decreasing
     */
    private boolean chooseDirection() {
        System.out.println(Output.SORT_MENU[3]);
        VoucherComparatorFactory factory = new VoucherComparatorFactory();
        return (in.getInt(1, 2) == 1);

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
