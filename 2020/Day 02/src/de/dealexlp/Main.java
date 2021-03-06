package de.dealexlp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 02/src", "input.txt");
        final Scanner scanner = new Scanner(file);
        final List<Integer> integerList = new ArrayList<>();

        int partOneValid = 0;
        int partTwoValid = 0;

        while(scanner.hasNextLine()) {
            final String line = scanner.nextLine();

            // Extract variables from each line
            final Password newPassword = new Password(line);
            final int min = newPassword.getMin();
            final int max = newPassword.getMax();
            final char letter = newPassword.getLetter();

            final String password = newPassword.getPassword();

            // PART 1: Test with first password policy
            int numOfOccurrences = password.length() - password.replace(String.valueOf(letter), "").length();
            if(numOfOccurrences >= min && numOfOccurrences <= max) {
                partOneValid++;
            }

            // PART 2: Test with second password policy
            if(password.charAt(min - 1) == letter ^ password.charAt(max - 1) == letter) {
                partTwoValid++;
            }

        }

        scanner.close();

        System.out.println(partOneValid);
        System.out.println(partTwoValid);
    }
}