package ru.zolov.stack;

import java.util.ArrayDeque;

/**
 * @author skaiur
 */
public class EvaluateReversePolishNotationSolution {
    public static int evalRPN(String[] tokens) {
        // создаем очередь в которую будем складывать операнды
        var stack = new ArrayDeque<Integer>();

        // для каждого токена из массива
        for (var t : tokens) {
            switch (t) {
                // если это плюс, то лопаем два числа из очереди и складываем (от перемены мест слагаемых сумма не меняется) и кладем в очередь результат
                case "+" -> stack.push(stack.pop() + stack.pop());
                // если это минус, то извлекаем два числа и вычитаем их в обратном порядке извлечения, так как исполнять последовательность нужно справа налево, а добавляли в очередь мы слева на право
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();

                    // и кладем в очередь результат
                    stack.push(b - a);
                }
                // если это умножение, то лопаем два числа из очереди и умножаем (От перемены мест множителей произведение не меняется) и кладем в очередь результат
                case "*" -> stack.push(stack.pop() * stack.pop());
                // если это деление, то извлекаем два числа и делим их в обратном порядке извлечения, так как исполнять последовательность нужно справа налево, а добавляли в очередь мы слева на право
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();

                    // и кладем в очередь результат
                    stack.push(b / a);
                }
                // Если это не знаки, то это числа. Добавляем их в очередь предварительно превратив из строк в числа
                default -> stack.push(Integer.valueOf(t));
            }
        }

        // После завершения цикла в очереди должно быть одно число. Возвращаем его как результат
        return stack.pop();
    }

    public static void main(String[] args) {
        var tokens = new String[]{"1", "2", "+", "3", "*", "4", "-"};
        var res = evalRPN(tokens);
        System.out.println(res);
    }
}
