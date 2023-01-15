package DefiningClasses.Company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEmployees = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countEmployees; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String employeeDepartment = input[3];
            //name,salary,position,department -> always
            //email,age -> not always
            switch (input.length){
                case 4:
                    Employee employee = new Employee(name,salary,position,employeeDepartment);
                    break;
                case 5:
                    if (input[4].contains("@")){
                        String email = input[4];
                        Employee employee2 = new Employee(name,salary,position,employeeDepartment,email);
                    }else{
                        int age = Integer.parseInt(input[4]);
                        Employee employee3 = new Employee(name, salary, position, employeeDepartment, age);
                    }
                    break;
                case 6:
                    String email = input[4];
                    int age = Integer.parseInt(input[5]);
                    Employee employee1 = new Employee(name,salary,position,employeeDepartment,email,age);
                    break;
            }

        }
    }
}
