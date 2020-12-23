package de.dealexlp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //TODO: NOT FINISHED YET

    public static void main(String[] args) throws FileNotFoundException {
        final File inputFile = new File("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 07/src/input.txt");
        final Pattern parentPattern = Pattern.compile("^\\w+ \\w+");
        final Pattern childPattern = Pattern.compile("\\d+ \\w+ \\w+");
        final Map<String, List<String>> bagContainers = new HashMap<>();
        final Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNext()) {
            final String nextLine = scanner.nextLine();
            final Matcher parentMatch = parentPattern.matcher(nextLine);

            parentMatch.find();

            final String parent = parentMatch.group();
            final Matcher childMatch = childPattern.matcher(nextLine);
            final List<String> child = new LinkedList<>();

            while (childMatch.find())
                child.add(childMatch.group());

            bagContainers.put(parent, child);
        }

        System.out.println(totalBags(bagContainers));
    }

    public static int totalBags(Map<String, List<String>> myBags) {
        final Queue<String> searchQ = new LinkedList<>();
        final Pattern childNumberPattern = Pattern.compile("\\d");
        final Pattern childColorPattern = Pattern.compile("[a-zA-Z]+ [a-zA-Z]+");

        int totalBags = 0;

        for (String child : myBags.get("shiny gold")) {
            final Matcher childNumberMatcher = childNumberPattern.matcher(child);
            final Matcher childColorMatcher = childColorPattern.matcher(child);

            childNumberMatcher.find();
            childColorMatcher.find();

            final int childNumber = Integer.parseInt(childNumberMatcher.group());
            final String childColor = childColorMatcher.group();

            totalBags += childNumber;

            for (int i = 0; i < childNumber; i++)
                searchQ.add(childColor);
        }

        while (!searchQ.isEmpty()) {
            final String nextSearch = searchQ.poll();

            for (String child : myBags.get(nextSearch)) {
                final Matcher childNumberMatcher = childNumberPattern.matcher(child);
                final Matcher childColorMatcher = childColorPattern.matcher(child);

                childNumberMatcher.find();
                childColorMatcher.find();

                final int childNumber = Integer.parseInt(childNumberMatcher.group());
                final String childColor = childColorMatcher.group();

                totalBags += childNumber;

                for (int i = 0; i < childNumber; i++)
                    searchQ.add(childColor);
            }
        }
        return totalBags;
    }
}