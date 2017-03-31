package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.Main;
import com.netcracker.labs.veromeyev.tourism.constant.Output;
import com.netcracker.labs.veromeyev.tourism.entity.voucher.CustomizableVoucher;
import com.netcracker.labs.veromeyev.tourism.util.Input;
import com.netcracker.labs.veromeyev.tourism.voucherlist.VoucherComparator;
import com.netcracker.labs.veromeyev.tourism.voucherlist.VoucherList;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class MainMenu {

    private boolean filterUpdated;
    private boolean sortUpdated;
    private Input in;
    private boolean exitFlag;
    private VoucherList filteredList;

    public MainMenu() {
        filterUpdated = false;
        sortUpdated = false;
        exitFlag = false;
        in = new Input();
    }

    public void launch() {
        while (!exitFlag) {
            updateData();
            showData();
            switch (in.getInt(0, 3)) {
                case 0:
                    exitFlag = true;
                    break;
                case 1:
                    selectMenu();
                    break;
//                case 2:
//                    filterMenu();
//                    break;
//                case 3:
//                    sortMenu();
//                    break;
            }
        }
    }

    public void selectMenu() {
        System.out.println(Output.SELECT_MENU[0]);
        int number = in.getInt(1, filteredList.getList().size());
        CustomizableVoucher voucher = filteredList.getList().get(number - 1);
        SelectMenu selectMenu = new SelectMenu(voucher);
        selectMenu.launch();
        System.out.println(Output.PRESS_ANYKEY);
        in.delayScreen();
    }

    public void showData() {
        System.out.println(Output.MENU_HEADER);
        int i = 0;
        for (CustomizableVoucher voucher : filteredList.getList()) {
            i++;
            System.out.println(i + " - " + voucher.toString());
        }
        System.out.println();
        System.out.println(Output.MAIN_MENU);
    }

    /**
     * filters and sorts shown data if filter
     */
    public void updateData() {
        if (!filterUpdated) {
            filteredList =
                    Main.getCustomizableVouchers().filter(Main.getFilter());
            VoucherComparator currentComparator = Main.getComparator();
            if (currentComparator != null) {
                filteredList.sort(currentComparator);
            }
            filterUpdated = true;
            sortUpdated = true;
        } else if (sortUpdated) {
            if (Main.getComparator() != null) {
                filteredList.sort(Main.getComparator());
            }
            sortUpdated = true;
        }
    }

}
