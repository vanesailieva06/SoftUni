package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int rows = -1;
        int column = -1;
        int paidCoins = 0;
        for (int i = 0; i < size; i++) {
            char[] row = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                matrix[i] = row;
                if (matrix[i][j] == 'A'){
                    rows = i;
                    column = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (paidCoins < 65){
            matrix[rows][column] = '-';
            if (command.equals("right")){
                column++;
            }else if (command.equals("left")){
                column--;
            }else if (command.equals("up")){
                rows--;
            }else if (command.equals("down")){
                rows++;
            }
            if (isOutOfBounds(matrix,rows,column)){
                System.out.println("I do not need more swords!");
                break;
            }
            if (Character.isDigit(matrix[rows][column])){
                String string = matrix[rows][column] + "";
                int coins = Integer.parseInt(string);
                paidCoins += coins;
            }
            if (matrix[rows][column] == 'M'){
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int currentRow = i;
                        int currentColumn = j;
                        if (matrix[currentRow][currentColumn] == 'M' && (currentColumn != column || currentRow != rows)){
                            matrix[rows][column] = '-';
                            rows = currentRow;
                            column = currentColumn;
                            break;
                        }
                    }
                }
            }
            matrix[rows][column] = 'A';
            if (paidCoins < 65) {
                command = scanner.next();
            }
        }
        if (paidCoins >= 65){
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",paidCoins);
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
