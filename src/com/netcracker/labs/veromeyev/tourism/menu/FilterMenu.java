package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.constant.Output;
import com.netcracker.labs.veromeyev.tourism.voucherlist.filter.ComplexVoucherFilter;
import com.netcracker.labs.veromeyev.tourism.voucherlist.filter.VoucherFilterFactory;

import java.time.LocalDate;

public class FilterMenu extends Menu{

    private ComplexVoucherFilter complexFilter;
    private VoucherFilterFactory factory;
    private boolean filterChanged;

    public FilterMenu(ComplexVoucherFilter complexFilter) {
        super();
        filterChanged = false;
        complexFilter = complexFilter;
        factory = new VoucherFilterFactory();
    }

    public boolean launch() {
        while (!exitFlag) {
            System.out.println(Output.FILTER_MENU[0]);
            System.out.println(complexFilter.getDescription());
            System.out.println(Output.FILTER_MENU[1]);
            switch (in.getInt(0, 2)) {
                case 0:
                    exitFlag = true;
                    break;
                case 1:
                    addFilter();
                    break;
                case 2:
                    complexFilter.reset();
                    filterChanged = true;
                    break;
            }
        }
        return filterChanged;
    }

    private void addFilter() {
        System.out.println(Output.FILTER_MENU[2]);

        switch (in.getInt(0, 6)) {
            case 1:
                voucherTypeFilter();
                break;
            case 2:
                durationFilter();
                break;
            case 3:
                startFilter();
                break;
            case 4:
                feedingFilter();
                break;
            case 5:
                transportFilter();
                break;
            case 6:
                costFilter();
                break;
            case 0:
            default:
                return;
        }
    }

    private void costFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[3]);
        double lowestCost = in.getDouble();
        System.out.println(Output.FILTER_MENU[4]);
        double highestCost = in.getDouble();
        complexFilter.add(factory.newCostFilter(lowestCost, highestCost));
    }

    private void transportFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[5]);
        complexFilter.add(factory.newDeliveryTransportFilter(in.getInt(1,3)));
    }

    private void startFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[6]);
        LocalDate nearest = in.getDate();
        System.out.println(Output.FILTER_MENU[7]);
        LocalDate furthest = in.getDate();
        complexFilter.add(factory.newStartFilter(nearest, furthest));
    }

    private void durationFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[8]);
        int minDuration = in.getInt();
        System.out.println(Output.FILTER_MENU[9]);
        int maxDuration = in.getInt();
        complexFilter.add(factory.newDurationFilter(minDuration, maxDuration));
    }

    private void voucherTypeFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[10]);
        complexFilter.add(factory.newVoucherTypeFilter(in.getInt(1, 5)));
    }

    private void feedingFilter() {
        filterChanged = true;
        System.out.println(Output.FILTER_MENU[11]);
        int answer = in.getInt();
        complexFilter.add(factory.newVegetarianFilter(answer == 1));
    }
}
