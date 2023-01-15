package WhaleLab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double sumGrades = 0;
        int classes = 1;
        int poorGrade = 0;
        boolean isExcluded = false;
        while (classes <= 12){
            if (poorGrade == 2){
                isExcluded = true;
                break;
            }
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade < 4){
                poorGrade ++;
                continue;
            }
            sumGrades = sumGrades + grade;
            classes++;
        }
        if (isExcluded){
            System.out.printf("%s has been excluded at %d grade", name, classes);
        }else{
            System.out.printf("%s graduated. Average grade: %.2f", name, sumGrades / 12);
        }


    }
}
