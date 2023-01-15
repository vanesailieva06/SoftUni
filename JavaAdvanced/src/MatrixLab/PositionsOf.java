package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        int searchNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder equalNum = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < columns; cols++) {
                    if (matrix[row][cols] == searchNumber){
                        equalNum.append(row)
                                .append(" ")
                                .append(cols)
                                .append(System.lineSeparator());
                    }
            }
        }
        System.out.println(equalNum.isEmpty() ? "not found" : equalNum.toString());
    }
}
