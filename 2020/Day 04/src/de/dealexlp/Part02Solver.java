package de.dealexlp;

import java.util.Arrays;

public class Part02Solver {

    public static void solve(final String[] lines) {
        long validPassports = Arrays.stream(lines)
                .parallel()
                .map(Utils::extractKeyValuePairs)
                .filter(Validator::hasAllRequiredFields)
                .filter(Validator::allPairsAreValid)
                .count();

        System.out.println("Part 2: " + validPassports);
    }
}