package ru.zolov.arrays;

import java.util.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * @author skaiur
 */
public class GroupAnagramSolution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Создаем словарь для хранения
        // key: массив со счетчиками частотности букв алфавита (превращенную в строку для использования в качестве ключа в словаре)
        // value: список строк являющихся анаграммами
        var ans = new HashMap<String, List<String>>();

        // для каждой строки во входящем массиве
        for (var s : strs) {
            // создаем массив со счетчиками частотности букв алфавита
            var count = new int[26];
            // для каждого символа в строке
            for (var c : s.toCharArray()) {
                // Вычисляем порядковый номер буквы алфавита
                // используя askii код
                // askii код 'a' = 97
                // 'b' = 98 ... и так далее
                // вычитаем из askii кода текущего символа 97 для определения порядкового номера буквы в алфавите
                count[c - 'a']++;
            }

            // для слова "act", "cat", "tac" получается массив вида [1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
            // получившийся массив превращаем в строку для использования в качестве ключа
            var key = Arrays.toString(count);
            // проверяем что в словаре еще нет такого ключа
            if (!ans.containsKey(key)) {
                // создаем список с текущей строкой и добавляем его в словарь
                var list = new ArrayList<String>();
                list.add(s);
                ans.put(key, list);
            } else {
                // если ключ уже есть в словаре, то
                // извлекаем список по ключу и добавляем в него анаграмму (слово с тем же набором букв)
                ans.get(key).add(s);
            }
        }

        // возвращаем все списки с анаграммами из словаря
        // например [[act, cat], [pots, tops, stop], [hat]]
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        var strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(groupAnagrams(strs));
    }
}
