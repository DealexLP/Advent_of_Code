package de.dealexlp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 04/src/input.txt");
        final List<String> passports = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.length() != 0) {
                stringBuilder.append(nextLine);
                stringBuilder.append(' ');
            } else {
                passports.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }

        passports.add(stringBuilder.toString());

        scanner.close();

        long validPassports = 0;

        for (int i = 0; i < passports.size(); i++) {
            scanner = new Scanner(passports.get(i));

            int ids = 0;

            while (scanner.hasNext())
                if (checkSingleID(scanner.next().split(":")))
                    ids++;

            if (ids == 7)
                validPassports++;

            scanner.close();
        }

        System.out.println(validPassports + " valid passports");
    }

    private static boolean checkSingleID(final String[] id) {
        final String IDType = id[0];

        return switch (IDType) {
            case "byr" -> Pattern.matches("(19[2-9]\\d)|(200[012])", id[1]);
            case "iyr" -> Pattern.matches("20(1\\d)|(20)", id[1]);
            case "eyr" -> Pattern.matches("20(2\\d)|(30)", id[1]);
            case "hgt" -> Pattern.matches("(1([5-8]\\d|9[0-3])cm)|(59|6\\d|7[0-6]in)", id[1]);
            case "hcl" -> Pattern.matches("#\\p{XDigit}{6}", id[1]);
            case "ecl" -> Pattern.matches("amb|blu|brn|gry|grn|hzl|oth", id[1]);
            case "pid" -> Pattern.matches("\\d{9}", id[1]);
            default -> false;
        };
    }
}