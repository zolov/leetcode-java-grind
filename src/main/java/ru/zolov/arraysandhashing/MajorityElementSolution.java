package ru.zolov.arraysandhashing;

/*
 * 169. Majority element Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the
 * majority element always exists in the array.
 */
public class MajorityElementSolution {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (var num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{3, 2, 3, 2, 3, 3}));
    }
}
