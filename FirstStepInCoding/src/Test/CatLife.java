package Test;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cats = scanner.nextLine();
        String gender = scanner.nextLine();
        int humanYears = 0;
        int humanMonths = 0;
        int catMonths = 0;

        if (gender.equals("m")){
            switch (cats){
                case "British Shorthair":
                    humanYears = 13;
                    humanMonths = 13 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Siamese":
                    humanYears = 15;
                    humanMonths = 15 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Persian":
                    humanYears = 14;
                    humanMonths = 14 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Ragdoll":
                    humanYears = 16;
                    humanMonths = 16 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "American Shorthair":
                    humanYears = 12;
                    humanMonths = 12 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case"Siberian":
                    humanYears = 11;
                    humanMonths = 11 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                default:
                    System.out.printf("%s is invalid cat!", cats);
                    break;
            }
        }else if (gender.equals("f")){
            switch (cats){
                case "British Shorthair":
                    humanYears = 14;
                    humanMonths = 14 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Siamese":
                    humanYears = 16;
                    humanMonths = 16 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Persian":
                    humanYears = 15;
                    humanMonths = 15 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "Ragdoll":
                    humanYears = 17;
                    humanMonths = 17 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case "American Shorthair":
                    humanYears = 13;
                    humanMonths = 13 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                case"Siberian":
                    humanYears = 12;
                    humanMonths = 12 * 12;
                    catMonths = humanMonths / 6;
                    System.out.printf("%d cat months", catMonths);
                    break;
                default:
                    System.out.printf("%s is invalid cat!", cats);
                    break;
            }
        }



    }
}
