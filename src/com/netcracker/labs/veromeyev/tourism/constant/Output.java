package com.netcracker.labs.veromeyev.tourism.constant;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class Output {
    public static final String MENU_HEADER = "Wellcome to NetCrackerTour!\n" +
        "Heare are available vouchers for your order:\n";
    public static final String MAIN_MENU = "Please, choose the operation:\n" +
            "1 - Select voucher to make an order\n" +
            "2 - Filter watched vouchers\n3 - Sort watched vouchers\n0 - exit";
    public static final String[] SELECT_MENU = {
            "Enter the number of chosen voucher",
            "Enter the number of chosen duration",
            "Enter the number of chosen start",
            "Enter the number of chosen feeding",
            "Enter the number of chosen delivery transport"
    };
    public static final String PRESS_ANYKEY = "\nPress any key to continue";
}
