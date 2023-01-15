package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];
        int rows = 0;
        int column = 0;
        for (int row = 0; row < dimension; row++) {
            int[]arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        while(rows < matrix.length && column < matrix[rows].length){
            System.out.print(matrix[rows][column] + " ");
            rows++;
            column++;
        }
        System.out.println();
        rows = matrix.length - 1;
        column = 0;
        while (rows >= 0 && column < matrix[rows].length){
            System.out.print(matrix[rows][column] + " ");
            rows--;
            column++;
        }

    }
}
