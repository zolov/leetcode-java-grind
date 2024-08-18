package ru.zolov.twopointers;


/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * @author skaiur
 */
public class ValidPalindromeSolution {

    static boolean isPalindrome2(String s) {
        if (s == null) return false;

        // создаем пустую строку или string builder как аккумулятор
        var ns = new StringBuilder();

        // для каждого символа в строке
        for (var c : s.toCharArray()) {
            // проверяем что это буква или цифра
            if (Character.isLetterOrDigit(c)) {
                // добавляем символ к строке аккумулятору
                ns.append(c);
            }

        }
        // проверяем что строка аккумулятор равна себе в перевернутом виде
        return ns.toString().contentEquals(ns.reverse());
    }

    static boolean isPalindrome(String s) {
        if (s == null) return false;

        // инициализируем левый и правый указатель
        int l = 0;
        int r = s.length() - 1;

        var chars = s.toCharArray();
        // пока левый указатель меньше правого
        while (l < r) {

            // пока левый указатель меньше правого и символ под левым указателем не является буквой или цифрой
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                // передвигаем левый указатель вправо (увеличиваем значение указателя)
                l++;
            }

            // пока правый указатель больше левого и символ под правым указателем не является буквой или цифрой
            while (r > l && !Character.isLetterOrDigit(chars[r])) {
                // передвигаем правый указатель влево (уменьшаем значение указателя)
                r--;
            }

            // если символ под левым указателем (в нижнем регистре) не равен символу под правым указателем
            // значит слово не является палиндромом, возвращаем false
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                return false;
            }

            // передвигаем указатели дальше вправо и влево соответственно пока не пройдем по всем символам
            l++;
            r--;
        }
        // Возвращаем true если мы прошли до середины слова и не вернули false
        return true;
    }


    public static void main(String[] args) {
        var str = "aba";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome2(str));
    }
}
