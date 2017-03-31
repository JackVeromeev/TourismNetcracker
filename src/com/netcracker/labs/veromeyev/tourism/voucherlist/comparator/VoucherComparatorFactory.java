package com.netcracker.labs.veromeyev.tourism.voucherlist.comparator;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

/**
 * Created by jack on 31/03/17.
 *
 * @author Jack Veromeyev
 */
public class VoucherComparatorFactory {
    public VoucherComparator newCostIncreasingComparator() {
        return new VoucherComparator() {
            @Override
            public boolean compare(CustomizableVoucher vLeft,
                                   CustomizableVoucher vRight) {
                return vLeft.getCostPerDay() < vRight.getCostPerDay();
            }

            @Override
            public String getDescription() {
                return "at cost per day in increasing order";
            }
        };
    }

    public VoucherComparator newCostDecreasingComparator() {
        return new VoucherComparator() {
            @Override
            public boolean compare(CustomizableVoucher vLeft,
                                   CustomizableVoucher vRight) {
                return vLeft.getCostPerDay() > vRight.getCostPerDay();
            }

            @Override
            public String getDescription() {
                return "at cost per day in decreasing order";
            }
        };
    }
}
