package ru.zolov.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 * Return the answer with the smaller index first.
 *
 * @author skaiur
 */
public class TwoSumSolution {

    static int[] twoSum(int[] nums, int target) {
        // создаем словарь для хранения
        // key: число
        // value: индекс числа
        var prevMap = new HashMap<Integer, Integer>();

        // для всех значений в массиве
        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            // вычитаем текущее число из искомого числа для получения разности
            var diff = target - num;

            // проверяем что такое число (разность) представлена в словаре
            if (prevMap.containsKey(diff)) {
                // если это так, то возвращаем массив с индексом разности и индексом текущего числа
                // чисел которые вместе дают искомую сумму
                return new int[]{prevMap.get(diff), i};
            }
            // добавляем в словарь текущее число (вычитаемое) как ключ и его индекс как значение
            prevMap.put(num, i);
        }

        // если не нашли числа которые вместе будут равны искомому числу возвращаем пустой массив
        return new int[] {};
    }

    public static void main(String[] args) {
        var target = 9;
        var numbers = new int[]{2, 7, 5, 8, 11};
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
