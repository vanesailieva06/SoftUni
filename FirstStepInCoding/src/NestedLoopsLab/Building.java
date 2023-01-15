package NestedLoopsLab;

import java.util.Scanner;
public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        for (int f = floors; f >= 1; f--){
            for (int r = 0; r < rooms; r++){
                String type = "";
                if (f == floors){
                    type = "L";
                }else if (f % 2 == 0){
                    type = "O";
                }else{
                    type = "A";
                }
                System.out.printf("%s%d%d ", type, f, r);
            }
            System.out.println();
        }

    }
}
