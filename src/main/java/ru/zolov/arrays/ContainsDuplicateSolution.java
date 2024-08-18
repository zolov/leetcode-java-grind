package ru.zolov.arrays;

import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * @author skaiur
 */
public class ContainsDuplicateSolution {

    public static boolean hasDuplicate(int[] nums) {
        // Создаем множество для хранения уникальных чисел
        var unique = new HashSet<Integer>(nums.length);

        for (var n : nums) {
            // Проверяем что число уже содержится в множестве, если да, то массив содержит дубликаты
            if (unique.contains(n)) {
                return true;
            } else {
                // Иначе добавляем число в массив
                unique.add(n);
            }
        }

        // Возвращаем false если дубликатов не найдено
        return false;
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 3, 4};

        System.out.println(hasDuplicate(arr));
    }
}
