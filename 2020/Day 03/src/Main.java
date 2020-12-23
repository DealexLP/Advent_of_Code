import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String filepath = "C:/Users/David Dunkel/IdeaProjects/Advent of Code/2020/Day 03/src/input.txt";

    public static void main(String[] args) throws IOException {
        long rows = getRows();
        long columns = getColumns();

        char[][] map = popMap(rows, columns);

        System.out.println("The number of trees hit in pt.1: " + traverse(map, rows, columns, 3, 1));
        System.out.println("The solution to pt.2: " + partTwo(map, rows, columns));
    }

    private static long getRows() throws IOException {
        final FileReader fileReader = new FileReader(filepath);
        final BufferedReader bufferedReader = new BufferedReader(fileReader);

        long rows = 0;

        while (bufferedReader.readLine() != null)
            rows++;

        bufferedReader.close();

        return rows;
    }

    private static long getColumns() throws FileNotFoundException {
        final File file = new File(filepath);
        final Scanner scanner = new Scanner(file);

        long columns = scanner.next().length();

        scanner.close();

        return columns;
    }

    private static char[][] popMap(final long rows, final long cols) throws FileNotFoundException {
        final char[][] map = new char[Math.toIntExact(rows)][Math.toIntExact(cols)];
        final Scanner scanner = new Scanner(new File(filepath));

        int row_count = 0;
        String string;

        while (scanner.hasNextLine()) {
            string = scanner.nextLine();
            for (int i = 0; i < cols; i++)
                map[row_count][i] = string.charAt(i);

            row_count++;
        }

        scanner.close();

        return map;
    }

    private static long partTwo(char[][] map, long rows, long columns) {
        long sol = 0;
        sol = traverse(map, rows, columns, 1, 1)
                * traverse(map, rows, columns, 3, 1)
                * traverse(map, rows, columns, 5, 1)
                * traverse(map, rows, columns, 7, 1)
                * traverse(map, rows, columns, 1, 2);
        return sol;
    }

    private static long traverse(char[][] map, long rows, long columns, long right, long down) {
        int trees = 0;
        int cur_row = 0;
        int cur_col = 0;

        while (cur_row < rows) {

            if (map[cur_row][cur_col] == '#')
                trees++;

            cur_row += down;
            if ((cur_col + right) >= columns)
                cur_col = Math.toIntExact(((cur_col + right) % columns));
            else
                cur_col += right;
        }
        return trees;
    }

    // For validating input
    private static void printInput(char[][] map, long rows, long cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
