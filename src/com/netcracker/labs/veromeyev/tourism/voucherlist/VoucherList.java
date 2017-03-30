package com.netcracker.labs.veromeyev.tourism.voucherlist;

import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;

import java.util.ArrayList;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class VoucherList {

    private ArrayList<CustomizableVoucher> list;

    public VoucherList(ArrayList<CustomizableVoucher> list) {
        this.list = list;
    }

    public ArrayList<CustomizableVoucher> getList() {
        return list;
    }

    public ArrayList<CustomizableVoucher> filter(VoucherFilter filter) {
        ArrayList<CustomizableVoucher> filtered = new ArrayList<>();
        for (CustomizableVoucher voucher : list) {
            if (filter.fit(voucher)) {
                filtered.add(voucher);
            }
        }
        return filtered;
    }

    public void sort(VoucherComparator comparator) {
        int i,j,k;
        int n = list.size();
        CustomizableVoucher t;
        for(k = n/2; k > 0; k /=2)
            for(i = k; i < n; i++)
            {
                t = list.get(i);
                for(j = i; j>=k; j-=k)
                {
                    if( comparator.compare(t, list.get(j-k)) ) {
                        list.set(j, list.get(j - k));
                    }
                    else {
                        break;
                    }

                }
                list.set(j, t);
            }
    }
}
