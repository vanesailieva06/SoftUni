package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.function.Predicate.isEqual;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int columns = Integer.parseInt(rowsAndCols[1]);
        int[][] firstMatrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[]arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[row] = arr;
        }
        rowsAndCols = scanner.nextLine().split(" ");
        rows = Integer.parseInt(rowsAndCols[0]);
        columns = Integer.parseInt(rowsAndCols[1]);
        int[][] secondMatrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[]arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[row] = arr;
        }
        if (isItEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean isItEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            if (firstMatrix[rows].length != secondMatrix[rows].length){
                return false;
            }
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols] != secondMatrix[rows][cols]){
                    return false;
                }
            }
        }
        return true;
    }
}
