package org.progmatic.nov25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nicelySpeak {

    private static final Set<String> badWords = new HashSet<>();

    public static void main(String[] args) throws BadLanguageException {
        badWords.add("dick");
        badWords.add("faggot");
        badWords.add("shit");

        nicelySpeak np = new nicelySpeak();
        System.out.println("Bad word checker");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        np.speakNicely(word);

    }
    public void speakNicely(String s) throws BadLanguageException {
        if (badWords.contains(s)) {
            throw new BadLanguageException();
        } else {
            System.out.println("Szép szó");
        }
    }
}
