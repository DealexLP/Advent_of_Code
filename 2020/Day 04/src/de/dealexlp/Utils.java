package de.dealexlp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static String[] readInput() {
        try {
            return Files.readString(Paths.get("C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 04/src/input.txt")).split("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public static Map<String, String> extractKeyValuePairs(final String input) {
        return Arrays.stream(input.split("[ \n]"))
                .collect(Collectors.toMap(t -> t.split(":")[0], t -> t.split(":")[1]));
    }
}