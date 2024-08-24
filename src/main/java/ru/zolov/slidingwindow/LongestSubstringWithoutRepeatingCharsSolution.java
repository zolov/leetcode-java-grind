package ru.zolov.slidingwindow;

import java.util.HashSet;

/**
 * @author skaiur
 */
public class LongestSubstringWithoutRepeatingCharsSolution {
    public static int lengthOfLongestSubstring(String s) {
        // Создаем множество для хранения уникальных символов
        var set = new HashSet<Character>();
        // Создаем левый и правый указатель который начинают первой позиции списка
        var l = 0;
        var max = 0;
        // Пока правый указатель меньше длины списка
        // Каждую итерацию сдвигаем правый указатель вправо
        for (int r = 0; r < s.length(); r++) {
            // Если символ под правым указателем уже ранее встречался и был добавлен в множество
            while (set.contains(s.charAt(r))) {
                // Удаляем символ под левым указателем из множества
                set.remove(s.charAt(l));
                // сдвигаем левый указатель вправо
                l++;
            }
            // Добавляем символ под правым указателем в множество
            set.add(s.charAt(r));
            // Вычисляем максимум из текущего максимума и разности левого и правого указателя + 1 (потому что для итерации по массиву начинаем с нуля)
            max = Math.max(max, r - l + 1);
        }
        // Возвращаем максимум
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("zxyzxyz"));
    }
}
