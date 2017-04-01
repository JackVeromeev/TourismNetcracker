package com.netcracker.labs.veromeyev.tourism.menu;

import com.netcracker.labs.veromeyev.tourism.util.Input;

public abstract class Menu {
    protected Input in;
    protected boolean exitFlag;

    protected Menu() {
        in = new Input();
        exitFlag = false;
    }
}
