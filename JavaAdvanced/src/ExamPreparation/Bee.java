package ExamPreparation;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int beeRow = -1;
        int beeCols = -1;
        int flowers = 0;
        for (int row = 0; row < n; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int cols = 0; cols < n; cols++) {
                matrix[row] = arr;
                if (matrix[row][cols] == 'B'){
                    beeRow = row;
                    beeCols = cols;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            matrix[beeRow][beeCols] = '.';
            if (command.equals("right")){
                beeCols++;
            } else if (command.equals("left")) {
                beeCols--;
            } else if (command.equals("up")) {
                beeRow--;
            } else if (command.equals("down")) {
                beeRow++;
            }
            if (beeRow >= n || beeRow < 0 || beeCols >= n || beeCols < 0){
                System.out.println("The bee got lost!");
                break;
            }
            if (matrix[beeRow][beeCols] == 'f'){
                flowers++;
            } else if (matrix[beeRow][beeCols] == 'O') {
                continue;
            }
            matrix[beeRow][beeCols] = 'B';
            command = scanner.nextLine();
        }
        if (flowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }
        for (int row = 0; row < n; row++) {
            for (int cols = 0; cols < n; cols++) {
                System.out.print(matrix[row][cols]);
            }
            System.out.println();
        }
    }
}
