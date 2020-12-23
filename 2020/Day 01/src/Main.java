import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final File file = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 01/src", "input.txt");
        final Scanner scanner = new Scanner(file);
        final List<Integer> integerList = new ArrayList<>();

        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                integerList.add(scanner.nextInt());
                continue;
            }
            scanner.next();
        }

        scanner.close();

        // Part 1
        System.out.println(partOne(integerList));

        // Part 2
        System.out.println(partTwo(integerList));
    }

    // Part 1: Find the two entries that sum to 2020 and then multiply those two numbers together
    public static int partOne(List<Integer> inputs) {
        for (Integer entry1 : inputs) {
            for (Integer entry2 : inputs) {
                if (entry1 + entry2 == 2020) {
                    return entry1 * entry2;
                }
            }
        }
        return 0;
    }

    // Part 2: Find the product of the three entries that sum to 2020
    public static int partTwo(List<Integer> inputs) {
        for (Integer entry1 : inputs) {
            for (Integer entry2 : inputs) {
                for (Integer entry3 : inputs) {
                    if (entry1 + entry2 + entry3 == 2020) {
                        return entry1 * entry2 * entry3;
                    }
                }
            }
        }
        return 0;
    }
}