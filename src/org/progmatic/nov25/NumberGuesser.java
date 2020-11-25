package org.progmatic.nov25;

import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        int num = (int)(Math.random()*101);
        Scanner sc = new Scanner(System.in);
        System.out.println("Gondoltam egy számra 0 és 100 között, táláld ki te fasz");
        int guess;
        do {
            try {
                guess = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Számot írj be te gyökér");
                sc = new Scanner(System.in);
                guess = sc.nextInt();
            }
            if (guess < num) {
                System.out.println("Nagyobb számra gondoltam");
                System.out.print("Tipp: ");
            }
            if (guess > num){
                System.out.println("Kisebb számra gondoltam");
                System.out.print("Tipp: ");
            }

        } while (guess != num);
        System.out.println("Kitaláltad");
        sc.close();
    }
}
