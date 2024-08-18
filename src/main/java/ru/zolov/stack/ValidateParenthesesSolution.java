package ru.zolov.stack;

import java.util.ArrayDeque;
import java.util.Map;

import static java.util.Map.of;

/**
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 * The input string s is valid if and only if:
 * 1. Every open bracket is closed by the same type of close bracket.
 * 2. Open brackets are closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * @author skaiur
 */
public class ValidateParenthesesSolution {

    public static boolean isValid(String s) {
        // Создаем словарь для хранения пар закрывающих и открывающих скобочек
        var closedToOpenBrackets = of(
                '}', '{',
                ']', '[',
                ')', '('
        );

        // Создаем stack (LIFO) для хранения последовательности открывающих скобочек
        var bracketsStack = new ArrayDeque<Character>();

        // для каждого символа в строке
        for (var c : s.toCharArray()) {
            // 1. проверяем что перед нами открывающая скобка т.к. мы не нашли ничего в словаре по ключу если нет, то 2
            if (!closedToOpenBrackets.containsKey(c)) {
                // 1.1 если это так, то помещаем открывающую скобку в очередь и переходим к следующей итерации
                bracketsStack.push(c);
                continue;
            }
            // 2. проверяем что очередь пуста, а значит в очереди нет открывающей скобки
            if (bracketsStack.isEmpty()) {
                return false;
            }
            // или что открывающая скобка из очереди не равна открывающей скобке для текущего символа из словаря
            if (!bracketsStack.peek().equals(closedToOpenBrackets.get(c))) {
                return false;
            }
            // если прошли все негативные проверки, то лопаем первый элемент из очереди, то есть открывающую скобку
            bracketsStack.pop();
        }

        // проверяем что в очереди не осталось скобок и последовательность валидна
        return bracketsStack.isEmpty();
    }

    public static boolean isValid2(String s) {
        // Создаем stack (LIFO) для хранения последовательности открывающих скобочек
        var bracketsStack = new ArrayDeque<Character>();

        // Создаем словарь для хранения пар закрывающих и открывающих скобочек
        var closedToOpenBrackets = Map.of(
                '}', '{',
                ']', '[',
                ')', '('
        );

        // для каждого символа в строке
        for (var c : s.toCharArray()) {
            // 1. проверяем что текущий элемент это закрывающая скобка при помощи поиска в словаре по ключу. Если нет, то 1.2
            if (closedToOpenBrackets.containsKey(c)) {
                // 2. если очередь со скобками не пустой, то получаем из словаря открывающую скобку для текущего символа (закрывающей скобки)
                // и сравниваем что эта открывающая скобка равна первому элементу из очереди
                if (!bracketsStack.isEmpty() && closedToOpenBrackets.get(c).equals(bracketsStack.peek())) {
                    // удаляем элемент из очереди
                    bracketsStack.pop();
                } else {
                    // 2.2. иначе возвращаем false так это значит что мы не нашли парную скобку и последовательность не валидная
                    return false;
                }
                // 1.2. кладем символ в очередь т.к. это значит что перед нами открывающая скобка
            } else {
                bracketsStack.push(c);
            }
        }

        // проверяем что в очередье не осталось скобок и последовательность валидна
        return bracketsStack.isEmpty();
    }

    public static void main(String[] args) {
        var s = "([{}])";

        System.out.println(isValid(s));
        System.out.println(isValid2(s));
    }
}
