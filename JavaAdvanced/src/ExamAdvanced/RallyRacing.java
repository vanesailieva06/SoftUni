package ExamAdvanced;

import java.util.Arrays;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        String[][] racingMatrix = new String[size][size];
        int rows = 0;
        int columns = 0;
        int km = 0;
        boolean won = false;
        for (int i = 0; i < size; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                racingMatrix[i] = row;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            if (racingMatrix[rows][columns].equals(".")) {
                km += 10;
            }
            racingMatrix[rows][columns] = ".";
            if (command.equals("right")){
                columns++;
            } else if (command.equals("left")) {
                columns--;
            } else if (command.equals("up")) {
                rows--;
            } else if (command.equals("down")) {
                rows++;
            }
            if (racingMatrix[rows][columns].equals("T")) {
                km += 30;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int currentRow = i;
                        int currentColumn = j;
                        if (racingMatrix[currentRow][currentColumn].equals("T") && (currentColumn != columns || currentRow != rows)){
                            racingMatrix[rows][columns] = ".";
                            rows = currentRow;
                            columns = currentColumn;
                            break;
                        }
                    }
                }
            }
            if (racingMatrix[rows][columns].equals("F")){
                won = true;
                System.out.printf("Racing car %s finished the stage!%n",racingNumber);
                break;
            }
            command = scanner.nextLine();
        }
        racingMatrix[rows][columns] = "C";
        if (!won){
            System.out.printf("Racing car %s DNF.%n",racingNumber);
        }
        System.out.printf("Distance covered %d km.%n",km);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(racingMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
