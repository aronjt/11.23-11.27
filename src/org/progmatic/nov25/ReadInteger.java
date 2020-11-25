package org.progmatic.nov25;

import java.util.Scanner;

public class ReadInteger {
    public static void main(String[] args) {
        ReadInteger ri = new ReadInteger();
        System.out.println(ri.readInt(new Scanner(System.in),null, null));
    }

    public int readInt(Scanner sc, String errorMessage, String requestMessage) {
        if (errorMessage == null) {
            errorMessage = "Számot írj be te gyökér";
        }
        if (requestMessage == null) {
            requestMessage = "Írj be egy számot";
        }
        int num = -1;
        boolean checker = false;
        System.out.println(requestMessage);
        do {
            boolean help = false;
            while (!help) {
                try {
                    num = sc.nextInt();
                    checker = true;
                    help = true;
                } catch (Exception e) {
                    System.out.println(errorMessage);
                    System.out.println(requestMessage);
                    sc = new Scanner(System.in);
                    // num = sc.nextInt();
                }
            }
        }
        while (!checker);
        sc.close();
        return num;
    }
}
