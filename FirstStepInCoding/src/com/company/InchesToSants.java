package com.company;

import java.util.Scanner;

public class InchesToSants {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double inches = Double.parseDouble(scanner.nextLine());
        double centimetres = inches * 2.54;
        System.out.println(centimetres);
    }
}
