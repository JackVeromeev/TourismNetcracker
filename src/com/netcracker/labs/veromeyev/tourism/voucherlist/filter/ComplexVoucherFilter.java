package com.netcracker.labs.veromeyev.tourism.voucherlist.filter;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class ComplexVoucherFilter implements VoucherFilter {

    private List<VoucherFilter> filters;

    public ComplexVoucherFilter() {
        filters = new LinkedList<>();
    }

    public List<VoucherFilter> getFilters() {
        return filters;
    }

    public void add(VoucherFilter filter) {
        filters.add(filter);
    }

    public void reset() {
        filters = new LinkedList<>();
    }

    @Override
    public boolean fit(CustomizableVoucher voucher) {
        boolean result = true;
        for (VoucherFilter filter : getFilters()) {
            result = filter.fit(voucher) && result;
        }
        return result;
    }

    @Override
    public String getDescription() {
        if (getFilters().size() == 0) {
            return "none";
        }
        boolean firstElement = true;
        StringBuilder builder = new StringBuilder();
        for (VoucherFilter filter : filters) {
            if (firstElement) {
                firstElement = false;
            } else {
                builder.append(", ");
            }
            builder.append(filter.getDescription());
        }
        builder.append(".");
        return builder.toString();
    }

}
