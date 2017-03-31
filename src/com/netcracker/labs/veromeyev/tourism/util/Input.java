package com.netcracker.labs.veromeyev.tourism.util;

import java.util.Scanner;

/**
 * Created by jack on 30/03/17.
 *
 * @author Jack Veromeyev
 */
public class Input {

    public static final String ENTER = "> ";

    public int getInt(int minValue, int maxValue) {
        int i = Integer.MIN_VALUE;
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        while (!success) {
            System.out.print(ENTER);
            try{
                i = Integer.parseInt(scanner.nextLine());
                if (i > maxValue || i < minValue) {
                    throw new Exception("Out of accessable range");
                }
                success = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Please, try again (" +
                e.getMessage() + ")");
            }
        }
        return i;
    }

    public int getInt() {
        return getInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void delayScreen() {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
