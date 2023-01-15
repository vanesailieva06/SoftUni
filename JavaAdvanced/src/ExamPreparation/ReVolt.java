package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int rows = -1;
        int column = -1;
        boolean won = false;
        for (int i = 0; i < size; i++) {
            char[] row = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                matrix[i] = row;
                if (matrix[i][j] == 'f') {
                    rows = i;
                    column = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (countOfCommands > 0) {
            int currentRow = rows;
            int currentColumn = column;
            if (matrix[rows][column] == 'f') {
                matrix[rows][column] = '-';
            }
                if (command.equals("right")) {
                    column++;
                    if (isOutOfBounds(matrix,rows,column)){
                        column = 0;
                    }
                } else if (command.equals("left")) {
                    column--;
                    if (isOutOfBounds(matrix,rows,column)){
                        column = size - 1;
                    }
                } else if (command.equals("up")) {
                    rows--;
                    if (isOutOfBounds(matrix,rows,column)){
                        rows = size - 1;
                    }
                } else if (command.equals("down")) {
                    rows++;
                    if (isOutOfBounds(matrix,rows,column)){
                        rows = 0;
                    }
                }

                if (matrix[rows][column] == 'F') {
                    won = true;
                    matrix[rows][column] = 'f';
                    break;
                }
                if (matrix[rows][column] == 'B') {
                    continue;
                }
                if (matrix[rows][column] == 'T'){
                    rows = currentRow;
                    column = currentColumn;
                }
                    matrix[rows][column] = 'f';
                countOfCommands--;
                if (countOfCommands > 0){
                    command = scanner.nextLine();
                }
        }
        System.out.println(won ? "Player won!" : "Player lost!");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }




    private static boolean isOutOfBounds(char[][] matrix, int rows, int column) {
        return rows >= matrix.length || rows < 0 || column >= matrix.length || column < 0;
    }
}
