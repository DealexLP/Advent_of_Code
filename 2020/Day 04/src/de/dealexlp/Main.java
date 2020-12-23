package de.dealexlp;

public class Main {

    public static void main(String[] args) {
        final String[] lines = Utils.readInput();
        Part01Solver.solve(lines);
        Part02Solver.solve(lines);
    }
}