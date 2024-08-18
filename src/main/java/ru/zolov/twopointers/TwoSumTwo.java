package ru.zolov.twopointers;

import java.util.Arrays;

/**
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 * There will always be exactly one valid solution.
 * Your solution must use O(1) additional space.
 *
 * @author skaiur
 */
public class TwoSumTwo {
    // актуально для отсортированного массива
    public static int[] twoSum(int[] numbers, int target) {
        // инициализируем два указателя
        int l = 0;
        int r = numbers.length - 1;

        // пока левый указатель меньше правого
        while (l < r) {
            // получаем сумму чисел под левым и правым указателем
            int curSum = numbers[l] + numbers[r];

            // если сумма больше искомого числа
            if (curSum > target) {
                // то сдвигаем правый указатель влево (уменьшаем)
                r--;
                // если сумма меньше искомого числа, то сдвигаем левый указатель вправо (увеличиваем)
            } else if (curSum < target) {
                l++;
            } else {
                // если сумма равна искомому числу, то возвращаем массив с индексами слагаемых (+1 конкретно в этой задаче)
                return new int[]{l + 1, r + 1};
            }
        }

        // если среди элементов массива не найдена подходящая сумма двух чисел, то возвращаем пустой массив
        return new int[]{};
    }

    public static void main(String[] args) {
        var target = 3;
        var numbers = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
