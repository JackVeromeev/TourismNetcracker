package com.netcracker.labs.veromeyev.tourism.voucherlist.comparator;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

public interface VoucherComparator {
    boolean compare(CustomizableVoucher vLeft, CustomizableVoucher vRight);
    String getDescription();
}
