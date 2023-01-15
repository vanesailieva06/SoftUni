package MethodEx;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            printNxNMatrixRow(n);
            printMatrixColumn(n);
        }
    }

    public static void printNxNMatrixRow(int n){
        for (int i = 1; i <= n ; i++) {
                System.out.print(n + " ");
        }
    }
    public static void printMatrixColumn(int n){
        System.out.println();
    }

}
