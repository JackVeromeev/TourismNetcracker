package com.netcracker.labs.veromeyev.tourism.voucherlist.comparator;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

/**
 * Created by jack on 31/03/17.
 *
 * @author Jack Veromeyev
 */
public class VoucherComparatorFactory {
    public VoucherComparator newCostIncreasingComparator(boolean increase) {
        return new VoucherComparator() {
            @Override
            public boolean compare(CustomizableVoucher vLeft,
                                   CustomizableVoucher vRight) {
                return (vLeft.getCostPerDay() < vRight.getCostPerDay())
                        ^ increase;
            }

            @Override
            public String getDescription() {
                return "at cost per day in "
                        + (increase ? "increasing" : "decreasing")
                        + " order";
            }
        };
    }

    public VoucherComparator newMinimalDurationComparator(boolean increase) {
        return new VoucherComparator() {
            @Override
            public boolean compare(CustomizableVoucher vLeft,
                                   CustomizableVoucher vRight) {
                return (minimalDuration(vLeft) > minimalDuration(vRight))
                        ^ increase;
            }

            @Override
            public String getDescription() {
                return "at minimal duration in "
                        + (increase ? "increasing" : "decreasing")
                        + " order";
            }
        };
    }

    public VoucherComparator newMaximalDurationComparator(boolean increase) {
        return new VoucherComparator() {
            @Override
            public boolean compare(CustomizableVoucher vLeft,
                                   CustomizableVoucher vRight) {
                return (maximalDuration(vLeft) > maximalDuration(vRight))
                        ^ increase;
            }

            @Override
            public String getDescription() {
                return "at maximal duration in "
                        + (increase ? "increasing" : "decreasing")
                        + " order";
            }
        };
    }

    private int minimalDuration(CustomizableVoucher voucher) {
        int result = voucher.getAvailableDuration().get(0);
        for (int duration : voucher.getAvailableDuration()) {
            if (result > duration) {
                result = duration;
            }
        }
        return result;
    }

    private int maximalDuration(CustomizableVoucher voucher) {
        int result = voucher.getAvailableDuration().get(0);
        for (int duration : voucher.getAvailableDuration()) {
            if (result < duration) {
                result = duration;
            }
        }
        return result;
    }
}
