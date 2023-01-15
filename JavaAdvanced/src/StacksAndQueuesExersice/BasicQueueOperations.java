package StacksAndQueuesExersice;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] operations = scanner.nextLine().split(" ");
        int n = Integer.parseInt(operations[0]);//push
        int s = Integer.parseInt(operations[1]);//pop
        String x = operations[2];//is it in the stack
        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println("0");
        }else if (queue.contains(x)){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(queue));
        }

    }
}
