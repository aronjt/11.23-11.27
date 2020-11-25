package org.progmatic.nov25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NicelySpeak {

    private static final Set<String> badWords = new HashSet<>();

    public static void main(String[] args) throws BadLanguageException {
        badWords.add("dick");
        badWords.add("faggot");
        badWords.add("shit");

        NicelySpeak np = new NicelySpeak();
        System.out.println("Bad word checker");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        np.speakNicely(word);

    }
    public void speakNicely(String s) throws BadLanguageException {
        for (String badWord : badWords) {
            if (s.contains(badWord)) {
                throw new BadLanguageException();
            }
        }
        System.out.println("nincs csúnya");
    }
}
