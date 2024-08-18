package ru.zolov.stack;

import java.util.ArrayDeque;

/**
 * @author skaiur
 */
public class EvaluateReversePolishNotationSolution {
    public static int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();

        for (var t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b - a);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b / a);
                }
                default -> stack.push(Integer.valueOf(t));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        var tokens = new String[]{"1", "2", "+", "3", "*", "4", "-"};
        var res = evalRPN(tokens);
        System.out.println(res);
    }
}
