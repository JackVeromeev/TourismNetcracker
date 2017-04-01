package com.netcracker.labs.veromeyev.tourism.voucherlist.filter;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

public interface VoucherFilter {
    boolean fit(CustomizableVoucher voucher);
    String getDescription();
}
