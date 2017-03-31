package com.netcracker.labs.veromeyev.tourism.voucherlist.comparator;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public interface VoucherComparator {
    boolean compare(CustomizableVoucher vLeft, CustomizableVoucher vRight);
    String getDescription();
}
