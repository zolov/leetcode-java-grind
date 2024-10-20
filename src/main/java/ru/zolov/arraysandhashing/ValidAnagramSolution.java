package ru.zolov.arraysandhashing;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * @author skaiur
 */
public class ValidAnagramSolution {
    static boolean isAnagram2(String s, String t) {
        // проверяем что длинна строк совпадает, иначе это не анаграмма
        if (s.length() != t.length()) return false;

        // создаем два словаря в которых будем хранить счетчики частотности букв в строках
        var countS = new HashMap<Character, Integer>();
        var countT = new HashMap<Character, Integer>();

        for (var i = 0; i < s.length(); i++) {
            // увеличиваем счетчик каждый раз когда встречается буква
            countS.merge(s.charAt(i), 1, Integer::sum);
            countT.merge(t.charAt(i), 1, Integer::sum);
            // так же можно уменьшать счетчик в единственном словаре и потом проверять что все значения равны 0
        }

        // сравниваем словари с буквами
        return countS.equals(countT);
    }

    static boolean isAnagram(String s, String t) {
        // проверяем что длинна строк совпадает, иначе это не анаграмма
        if (s.length() != t.length()) return false;

        // инициализируем массив для алфавита
        var store = new int[26];
        for (var i = 0; i < s.length(); i++) {
            // у буквы первой буквы алфавита a 97й номер в ASKII таблице
            // b = 98 и так далее
            // вычитая из номера текущего символа 97 мы получаем его номер в алфавите
            // увеличиваем счетчик частотности символа в массиве с алфавитом
            store[s.charAt(i) - 'a']++;
            // уменьшаем счетчик
            store[t.charAt(i) - 'a']--;
        }

        // проверяем что все счетчики в массиве с алфавитов равны 0 иначе две сравниваемые строки не являются анаграммами
        for (var n : store) {
            if (n != 0) return false;
        }

        // возвращаем true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cba"));
        System.out.println(isAnagram("xx", "x"));
        System.out.println(isAnagram2("abc", "cba"));
        System.out.println(isAnagram2("xx", "x"));
    }
}
