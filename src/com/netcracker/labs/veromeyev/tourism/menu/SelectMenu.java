package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.constant.Output;
import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.ConcreteVoucher;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import com.netcracker.labs.veromeyev.tourism.util.Input;

import java.time.LocalDateTime;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class SelectMenu {

    private CustomizableVoucher voucher;
    private Input in;

    public SelectMenu(CustomizableVoucher voucher) {
        this.voucher = voucher;
        in = new Input();
    }

    public void launch() {
        System.out.println(voucher.toString());
        int durationNumber = selectDuration();
        int startNumber = selectStart();
        int feedingNumber = selectFeeding();
        int transportNumber = selectTransport();

        ConcreteVoucher concreteVoucher = new ConcreteVoucher(
                voucher, durationNumber, startNumber, feedingNumber,
                transportNumber);

        System.out.println("\nYour voucher information:\n");
        System.out.println(concreteVoucher.toString());
    }

    private int selectDuration() {
        int durationAmount = voucher.getAvailableDuration().size();
        if (durationAmount > 1) {
            System.out.println(Output.SELECT_MENU[1]);
            int i = 1;
            for (int duration : voucher.getAvailableDuration()) {
                System.out.println(i + " - " + duration + " day(s)");
                i++;
            }
            return in.getInt(1, durationAmount) - 1;
        }
        return 0;
    }

    private int selectStart() {
        int startAmount = voucher.getAvailableStart().size();
        if (startAmount> 1) {
            System.out.println(Output.SELECT_MENU[2]);
            int i = 1;
            for (LocalDateTime start : voucher.getAvailableStart()) {
                System.out.println(i + " - "
                        + start.toString().replace('T', ' '));
                i++;
            }
            return in.getInt(1, startAmount) - 1;
        }
        return 0;
    }

    private int selectFeeding() {
        int feedingAmount = voucher.getAvailableFeeding().size();
        if (feedingAmount > 1) {
            System.out.println(Output.SELECT_MENU[3]);
            int i = 1;
            for (Feeding feeding : voucher.getAvailableFeeding()) {
                System.out.println(i + " - " + feeding.toString());
                i++;
            }
            return in.getInt(1, feedingAmount) - 1;
        }
        return 0;
    }

    private int selectTransport() {
        int transportAmount = voucher.getAvailableDeliveryTransport().size();
        if (transportAmount> 1) {
            System.out.println(Output.SELECT_MENU[4]);
            int i = 1;
            for (Transport transport : voucher.getAvailableDeliveryTransport()) {
                System.out.println(i + " - " + transport.toString());
                i++;
            }
            return in.getInt(1, transportAmount) - 1;
        }
        return 0;
    }

}
