package com.netcracker.labs.veromeyev.tourism.voucherlist;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public interface VoucherFilter {
    boolean fit(CustomizableVoucher voucher);
    String getDescription();
}
