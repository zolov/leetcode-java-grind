package ru.zolov.slidingwindow;

/**
 * You are given a string s consisting of only uppercase english characters and an integer k.
 * You can choose up to k characters of the string and replace them with any other uppercase English character.
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 * @author skaiur
 */
public class LongestRepeatingCharacterReplacementSolution {

    public static int characterReplacement(String s, int k) {
        // Создаем массив для хранения частотности символов
        var arr = new int[26];

        // Создаем переменную для хранения финального ответа, длинны самой длинной подстроки которая содержит только один определенный символ
        int ans = 0;
        // Создаем переменную для хранения максимального числа повторений одно и того же символа
        int max = 0;
        // Создаем левый и правый указатель
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Увеличиваем счетчик частотности в массиве для каждого встречающегося символа
            var i = s.charAt(r) - 'A';
            arr[i] += 1;
            // Вычисляем максимум между текущим максимом и счетчиком частотности текущего символа под правым указателем R
            max = Math.max(max, arr[i]);

            // Если результат вычисления R - L + 1 - max больше искомого K
            if (r - l + 1 - max > k) {
                // То уменьшаем счетчик частотности для символа под левым указателем L
                arr[s.charAt(l) - 'A'] -= 1;
                // сдвигаем левый указатель L вправо
                l++;
            }
            // Вычисляем максимум между значением переменной для хранения финального ответа и выражением R - L + 1
            ans = Math.max(ans, r - l + 1);
        }

        // Возвращаем значение переменной для хранения финального ответа
        return ans;
    }

    public static void main(String[] args) {
        var input = "AAABABB";
        System.out.println(characterReplacement(input, 1));
    }
}
