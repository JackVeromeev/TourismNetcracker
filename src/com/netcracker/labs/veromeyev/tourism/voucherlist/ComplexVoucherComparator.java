package com.netcracker.labs.veromeyev.tourism.voucherlist;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class ComplexVoucherComparator implements VoucherComparator {

    private List<VoucherComparator> comparators;

    public ComplexVoucherComparator() {
        comparators = new LinkedList<>();
    }

    public List<VoucherComparator> getComparators() {
        return comparators;
    }

    public void add(VoucherComparator comparator) {
        comparators.add(comparator);
    }

    public void reset() {
        comparators = new ArrayList<>();
    }

    /**
     * @return true if need to replace
     */
    @Override
    public boolean compare(CustomizableVoucher vLeft,
                           CustomizableVoucher vRight) {
        boolean result = false;
        for (VoucherComparator comparator : comparators) {
            result = result || comparator.compare(vLeft, vRight);
        }
        return result;
    }

    @Override
    public String getDescription() {
        StringBuilder builder = new StringBuilder();
        boolean firstElement = true;
        for (VoucherComparator comparator : comparators) {
            if (firstElement) {
                firstElement = false;
            } else {
                builder.append(", ");
            }
            builder.append(comparator.getDescription());
        }
        builder.append(".");
        return builder.toString();
    }
}
