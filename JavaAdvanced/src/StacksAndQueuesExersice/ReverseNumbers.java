package StacksAndQueuesExersice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String num : input){
            stack.push(num);
        }
        for (String n : stack){
            System.out.print(n + " ");
        }
    }
}
