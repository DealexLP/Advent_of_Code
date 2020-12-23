package de.dealexlp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Part 1: " + getFirstResult());
        System.out.println("Part 2: " + getSecondResult());
    }

    private static int getFirstResult() throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 06/src/input.txt");
        final Scanner scanner = new Scanner(file);
        final TreeSet<Character> questions = new TreeSet<>();

        int sum = 0;

        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            if (chars.length == 0) {
                sum += questions.size();
                questions.clear();
            } else {
                for (char c : chars) {
                    questions.add(c);
                }
            }
        }
        sum += questions.size();
        return sum;
    }

    private static int getSecondResult() throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 06/src/input.txt");
        final Scanner scanner = new Scanner(file);
        final List<Character> questions = new ArrayList<>();

        boolean firstLine = true;
        int sum = 0;

        while (scanner.hasNextLine()) {
            final String nextLine = scanner.nextLine();

            if (nextLine.equals("")) {
                sum += questions.size();
                questions.clear();
                firstLine = true;
            } else {
                if (firstLine) {
                    for (char c : nextLine.toCharArray())
                        questions.add(c);
                    firstLine = false;
                } else
                    questions.removeIf(c -> !nextLine.contains(String.valueOf(c)));
            }
        }

        sum += questions.size();

        return sum;
    }
}