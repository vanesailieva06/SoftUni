package TestPreperation;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldGames = Integer.parseInt(scanner.nextLine());
        String game = scanner.nextLine();
        double hearthstone = 0;
        double fornite = 0;
        double overwatch = 0;
        boolean others = false;
        double othersPercent = 0;

        for (int n = 1; n <= soldGames;n ++){
            if (game.equals("Hearthstone")){
                hearthstone = 100 / soldGames;
                others = true;
            }

            if (game.equals("Fornite")){
                fornite = 100 / soldGames;
                others = true;
            }

            if (game.equals("Overwatch")){
                overwatch = 100 / soldGames;
                others =  true;
            }

            if(others){
                othersPercent = 100 - (fornite + hearthstone + overwatch);
            }
            game = scanner.nextLine();
            if (n == soldGames){
                break;
            }
        }
            System.out.printf("Hearthstone - %.2f%n", hearthstone);
            System.out.printf("Fornite - %.2f%n", fornite);
            System.out.printf("Overwatch - %.2f%n", overwatch);
            System.out.printf("Others - %.2f%n", othersPercent);

        }
    }

