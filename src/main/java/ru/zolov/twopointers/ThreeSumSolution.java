package ru.zolov.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0,
 * and the indices i, j and k are all distinct.
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 *
 * @author skaiur
 */
public class ThreeSumSolution {

    public static List<List<Integer>> threeSum(int[] nums) {
        // Сортируем массив для того чтобы дубликаты были в естественном порядку
        Arrays.sort(nums);
        // создаем лист для листов триплетов
        var res = new ArrayList<List<Integer>>();

        // для каждого элемента в массиве
        for (int i = 0; i < nums.length; i++) {
            // проверяем что текущий элемент больше ноля, если это так, то завершаем алгоритм
            // так как если первый элемент в массиве больше нуля, то получить сумму равную 0 никак не получится
            if (nums[i] > 0) break;

            // проверяем если мы не на первой итерации и текущий элемент равен предыдущему, то мы пропускаем итерацию
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // создаем 2 дополнительных указателя
            // Первое слагаемое 'a', на него указывает i, то есть индекс текущего элемента массива
            // Второе слагаемое 'b', на него указывает левый указатель l = [i + 1], то есть следующий элементу массива после текущего
            // Третье слагаемое 'c', на него указывает r = то есть последний элемент в массиве
            int l = i + 1;
            int r = nums.length - 1;

            // пока левый указатель больше правого
            while (l < r) {
                // высчитаем сумму a + b + c
                int sum = nums[i] + nums[l] + nums[r];
                // если сумма больше нуля
                if (sum > 0) {
                    // сдвигаем правый указатель влево, то есть уменьшаем
                    r--;
                    // если сумма меньше нуля
                } else if (sum < 0) {
                    // сдвигаем левый указатель вправо, то есть увеличиваем
                    l++;
                } else {
                    // если сумма триплета равна нолю, то добавляем лист со слагаемыми в результирующий список
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // сдвигаем левый указатель вправо, а правый влево
                    l++;
                    r--;
                    // пока левый указатель больше правого и текущее значение b равно предыдущему (пропускаем дубли)
                    while (l < r && nums[l] == nums[l - 1]) {
                        // сдвигаем левый указатель
                        l++;
                    }
                }
            }
        }

        // возвращаем результирующий список
        return res;
    }

    public static void main(String[] args) {
        var nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }
}
