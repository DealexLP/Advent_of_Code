package de.dealexlp;

import java.util.Arrays;

public class Part01Solver {

    public static void solve(final String[] lines) {
        long validPassports = Arrays.stream(lines)
                .parallel()
                .map(Utils::extractKeyValuePairs)
                .filter(Validator::hasAllRequiredFields)
                .count();

        System.out.println("Part 1: " + validPassports);
    }
}
