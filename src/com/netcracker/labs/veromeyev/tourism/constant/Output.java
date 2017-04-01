package com.netcracker.labs.veromeyev.tourism.constant;

public class Output {
    public static final String MENU_HEADER = "Welcome to NetCrackerTour!\n" +
        "Here are available vouchers for your order:\n";
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
    public static final String[] FILTER_MENU = {
            "Current filter settings: ",
            "\nPlease, choose the operation\n1 - add filter" +
                    "\n2 - reset filter\n0 - back",
            "\nPlease, select the filter type:" +
                    "\n1 - voucher type\n2 - duration" +
                    "\n3 - start date\n4 - feeding" +
                    "\n5 - delivery transport\n6 - cost per day\n0 - back",
            "Enter minimum cost per day",
            "Enter maximum cost per day",
            "Select preferred delivery transport:\n1 - bus\n2 - ship" +
                    "\n3 - plane",
            "Enter nearest start date (year month day through space)",
            "Enter furthest start date (year month day through space)",
            "Enter minimum duration",
            "Enter maximum duration",
            "Select preferred type of voucher:\n1 - cruise\n2 - excursion\n" +
                    "3 - recreation\n4 - shopping\n5 - treatment",
            "Select preferred type of feeding:\n1 - vegetarian" +
                    "\n2 - non-vegetarian"
    };
    public static final String[] SORT_MENU = {
            "Current sorting setting: ",
            "\nPlease, choose the operation\n1 - set sorting" +
                    "\n0 - back",
            "\nPlease, choose the sort" +
                    "\n1 - at cost per day" +
                    "\n2 - at minimal duration" +
                    "\n3 - at maximal duration\n0 - back",
            "\nPlease, choose the direction" +
                    "\n1 - in increasing order" +
                    "\n2 - at cost per day in decreasing order"
    };
    public static final String PRESS_ANY_KEY_TO_CONTINUE
            = "\nPress any key to continue";
}
