package Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            box.add(value);
        }
        String[] string = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(string[0]);
        int secondIndex = Integer.parseInt(string[1]);
        box.swap(firstIndex,secondIndex);
        System.out.println(box);
    }
}
