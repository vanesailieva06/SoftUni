package StacksAndQueuesExersice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char currentBrackets = brackets.charAt(i);
            if (currentBrackets == '(' || currentBrackets == '{' || currentBrackets == '['){
                stack.push(currentBrackets);
                continue;
            }
            if (stack.isEmpty()){
                isBalanced = false;
                break;
            }
            char lastBracket = stack.peek();
            if (currentBrackets == ')' && lastBracket != '('){
                isBalanced = false;
                break;
            }else if (currentBrackets == '}' && lastBracket != '{'){
                isBalanced = false;
                break;
            }else if (currentBrackets == ']' && lastBracket != '['){
                isBalanced = false;
                break;
            }
            lastBracket = stack.pop();
        }
        if (isBalanced && stack.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
