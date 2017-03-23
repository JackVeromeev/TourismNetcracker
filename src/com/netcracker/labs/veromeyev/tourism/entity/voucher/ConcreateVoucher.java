package com.netcracker.labs.veromeyev.tourism.entity.voucher;

import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.VoucherType;

import java.util.Date;

/**
 * Created by jack on 23/03/17.
 */
public class ConcreateVoucher {

    private VoucherType type;
    private int duration;
    private Date start;
    private Feeding feeding;
    private Transport deliveryTransport;

}