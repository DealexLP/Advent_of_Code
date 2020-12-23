import java.io.*;
import java.util.Scanner;

public class Main {

    public static String filepath = "C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 03/src/input.txt";

    public static void main(String[] args) throws IOException {
        int rows = getRows();
        int columns = getCols();

        char[][] map = popMap(rows, columns);

        System.out.println("\n The number of trees hit in pt.1: " + traverse(map, rows, columns, 3, 1));
        System.out.println("\n The solution to pt.2: " + partTwo(map, rows, columns));
    }

    private static int getRows() throws IOException {
        BufferedReader br_size = new BufferedReader(new FileReader(filepath));
        int rows = 0;
        while (br_size.readLine() != null) rows++;
        br_size.close();
        return rows;
    }

    private static int getCols() throws FileNotFoundException {
        Scanner s = new Scanner(new File(filepath));
        int columns = 0;
        columns = s.next().length();
        s.close();
        return columns;
    }

    private static char[][] popMap(int rows, int cols) throws FileNotFoundException {
        char[][] map = new char[rows][cols];
        Scanner s = new Scanner(new File(filepath));

        int row_count = 0;
        String str = "";
        while (s.hasNextLine()) {
            str = s.nextLine();
            for (int i = 0; i < cols; i++) {
                map[row_count][i] = str.charAt(i);
            }
            row_count++;
        }
        s.close();
        return map;
    }

    private static int partTwo(char[][] map, int rows, int cols) {
        int sol = 0;
        sol = traverse(map, rows, cols, 1, 1) * traverse(map, rows, cols, 3, 1) * traverse(map, rows, cols, 5, 1) * traverse(map, rows, cols, 7, 1) * traverse(map, rows, cols, 1, 2);
        return sol;
    }

    private static int traverse(char[][] map, int rows, int cols, int right, int down) {
        int trees = 0;
        int cur_row = 0;
        int cur_col = 0;

        while (cur_row < rows) {

            if (map[cur_row][cur_col] == '#')
                trees++;

            cur_row += down;
            if ((cur_col + right) >= cols)
                cur_col = ((cur_col + right) % cols);
            else
                cur_col += right;
        }
        return trees;
    }

    // For validating input
    private static void printInput(char[][] map, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
