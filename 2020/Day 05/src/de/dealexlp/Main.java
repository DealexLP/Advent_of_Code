package de.dealexlp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final List<Integer> input = getIDs();

        System.out.println("Part 1: " + getHighestSeatID(input));
        System.out.println("Part 2: " + getSantasSeat(input));
    }

    public static int getHighestSeatID(final List<Integer> input) {
        int highest = 0;

        for (int i : input)
            if (i > highest)
                highest = i;

        return highest;
    }

    public static int getSantasSeat(List<Integer> input) {
        Collections.sort(input);

        for (int i = 0; i < input.size() - 1; i++)
            if (input.get(i + 1) - input.get(i) != 1)
                return input.get(i) + 1;

        return -1;
    }

    public static List<Integer> getIDs() throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 05/src/input.txt");
        final Scanner scanner = new Scanner(file);
        final List<Integer> seats = new ArrayList<>();

        while (scanner.hasNextLine()) {
            final char[] line = scanner.nextLine().toCharArray();
            int row = 127;
            int rangeRow = 127;
            int coulomb = 7;
            int rangeCoulomb = 7;

            for (char c : line) {
                switch (c) {
                    case 'F':
                        row -= rangeRow / 2 + 1;
                    case 'B':
                        rangeRow /= 2;
                        break;
                    case 'L':
                        coulomb -= rangeCoulomb / 2 + 1;
                    case 'R':
                        rangeCoulomb /= 2;
                        break;
                    default:
                        System.out.println("Error in reading the input!");
                }
            }
            seats.add(row * 8 + coulomb);
        }
        return seats;
    }
}