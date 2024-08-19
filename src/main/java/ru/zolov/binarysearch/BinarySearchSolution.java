package ru.zolov.binarysearch;

/**
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 * Your solution must run in O(logn) time.
 *
 * @author skaiur
 */
public class BinarySearchSolution {
    public static int search(int[] nums, int target) {
        // Создаем два указателя, l = начальному индексу массива, r = последнему индексу в массиве
        int l = 0;
        int r = nums.length - 1;

        // пока левый указатель меньше или равен правому
        while (l <= r) {
            // Вычисляем индекс середины массива
            // для защиты от переполнения используем не (l + r) / 2
            // Вычисляем разность r - l, далее делим на 2 и прибавляем значение l
            // m = 0 + (5 - 0) / 2 = 2
            int m = l + ((r - l) / 2);

            // если элемент в середине массива больше искомого
            if (nums[m] > target) {
                // сдвигаем правый указатель в центр, но так как мы уже проверил элемент в центре, то сдвигаем еще левее на 1
                r = m - 1;
                // если элемент в середине массива меньше искомого
            } else if (nums[m] < target) {
                // сдвигаем левый указатель в центр, но так как мы уже проверил элемент в центре, то сдвигаем еще правее на 1
                l = m + 1;
            } else {
                // Иначе возвращаем индекс элемента в середине т.к. он должен быть равен искомому
                return m;
            }
        }

        // Если не нашли искомое число, то возвращаем -1
        return -1;
    }

    public static void main(String[] args) {
        var nums = new int[]{-1,0,2,4,6,8};
        var target = 4;
        System.out.println(search(nums, target));
    }
}
