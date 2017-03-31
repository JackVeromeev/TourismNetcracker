package com.netcracker.labs.veromeyev.tourism.util;

import java.time.LocalDate;
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
        return getInt(0, Integer.MAX_VALUE);
    }

    public double getDouble(double minValue, double maxValue) {
        double i = Double.MIN_VALUE;
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        while (!success) {
            System.out.print(ENTER);
            try{
                i = Double.parseDouble(scanner.nextLine());
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

    public double getDouble() {
        return getDouble(0.0, Double.MAX_VALUE);
    }

    public LocalDate getDate() {
        int day = 0;
        int month = 0;
        int year = 0;
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.MIN;
        while (!success) {
            System.out.print(ENTER);
            try{
                year = scanner.nextInt();
                month = scanner.nextInt();
                day = scanner.nextInt();
                date = LocalDate.of(year, month, day);
                success = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Please, try again");
                scanner.nextLine();
            }
        }
        return date;
    }

    public void delayScreen() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
