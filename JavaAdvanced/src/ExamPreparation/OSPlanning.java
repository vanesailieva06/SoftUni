package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        //stack
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split(", ")).
                map(Integer :: parseInt).forEach(taskStack :: push);
        input = scanner.nextLine();
        Arrays.stream(input.split(" "))
                .map(Integer :: parseInt).forEach(threadsQueue :: offer);
        int value = Integer.parseInt(scanner.nextLine());
        while (taskStack.peek() != value){
            int threadValue = threadsQueue.peek();
            int taskValue = taskStack.peek();
            //•	If the thread value is greater than or equal to the task value, the task and thread get removed.
            //•	If the thread value is less than the task value, the thread gets removed, but the task remains.
            if (threadValue >= taskValue){
                taskStack.pop();
            }
            threadsQueue.poll();
        }
        System.out.printf("Thread with value %d killed task %d%n",threadsQueue.peek(), value);
        threadsQueue.forEach(e -> System.out.print(threadsQueue.poll() + " "));
    }
}
