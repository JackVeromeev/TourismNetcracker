package com.netcracker.labs.veromeyev.tourism.voucherlist.filter;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.feeding.Feeding;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Bus;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Plane;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Ship;
import com.netcracker.labs.veromeyev.tourism.entity.transport.Transport;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import com.netcracker.labs.veromeyev.tourism.entity.vouchertype.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VoucherFilterFactory {

    public VoucherFilter newCostFilter(double lowestCost, double highestCost) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                return voucher.getCostPerDay() >= lowestCost
                        && voucher.getCostPerDay() <= highestCost;
            }

            @Override
            public String getDescription() {
                return "cost per day is between " + lowestCost
                        + " and " + highestCost;
            }
        };
    }

    public VoucherFilter newDeliveryTransportFilter(int transportNumber) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                boolean anyFound = false;
                for (Transport transport :
                        voucher.getAvailableDeliveryTransport()) {
                    switch (transportNumber) {
                        case 1:
                            anyFound = anyFound || (transport instanceof Bus);
                            break;
                        case 2:
                            anyFound = anyFound || (transport instanceof Ship);
                            break;
                        case 3:
                            anyFound = anyFound
                                    || (transport instanceof Plane);
                            break;
                    }
                }
                return anyFound;
            }

            @Override
            public String getDescription() {
                String transportString = "";
                switch (transportNumber) {
                    case 1:
                        transportString = Name.Entity.Transport.BUS;
                        break;
                    case 2:
                        transportString = Name.Entity.Transport.SHIP;
                        break;
                    case 3:
                        transportString = Name.Entity.Transport.PLANE;
                        break;
                }
                return "delivery transport is " + transportString;
            }
        };
    }

    public VoucherFilter newStartFilter(LocalDate nearest,
                                        LocalDate furthest) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                for (LocalDateTime dateTime : voucher.getAvailableStart()) {
                    LocalDate voucherDate = dateTime.toLocalDate();
                    if (voucherDate.isBefore(furthest)
                            && voucherDate.isAfter(nearest)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Start date is between " + nearest.toString()
                        + " and " + furthest.toString();
            }
        };
    }

    public VoucherFilter newDurationFilter(int minDuration,
                                           int maxDuration) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                for (int duration : voucher.getAvailableDuration()) {
                    if (duration >= minDuration && duration <= maxDuration) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "duration is between " + minDuration
                        + " and " + maxDuration;
            }
        };
    }

    public VoucherFilter newVoucherTypeFilter(int typeNumber) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                switch (typeNumber) {
                    case 1:
                        return voucher.getType() instanceof Cruise;
                    case 2:
                        return voucher.getType() instanceof Excursion;
                    case 3:
                        return voucher.getType() instanceof Recreation;
                    case 4:
                        return voucher.getType() instanceof Shopping;
                    case 5:
                        return voucher.getType() instanceof Treatment;
                }
                return false;
            }
            @Override
            public String getDescription() {
                String prompt = "type is ";
                switch (typeNumber) {
                    case 1:
                        return prompt + Name.Entity.VoucherType.CRUISE;
                    case 2:
                        return prompt + Name.Entity.VoucherType.EXCURSION;
                    case 3:
                        return prompt + Name.Entity.VoucherType.RECREATION;
                    case 4:
                        return prompt + Name.Entity.VoucherType.SHOPPING;
                    case 5:
                        return prompt + Name.Entity.VoucherType.TREATMENT;
                }
                return prompt + "unknown";
            }
        };
    }

    public VoucherFilter newVegetarianFilter(boolean isVegetarian) {
        return new VoucherFilter() {
            @Override
            public boolean fit(CustomizableVoucher voucher) {
                for (Feeding feeding : voucher.getAvailableFeeding()) {
                    if (feeding.isVegetarian() == isVegetarian) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return isVegetarian ? "vegetarian menu" :
                        "non-vegetarian menu";
            }
        };
    }
}
