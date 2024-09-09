package ru.zolov.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author skaiur
 */
public class SlidingWindowMaximumSolution {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        var len = nums.length;
        var res = new int[len - k + 1];
        var q = new ArrayDeque<Integer>();

        int l = 0, r = 0;
        while (r < len) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offer(r);

            if (l > q.peekFirst()) {
                q.pollFirst();
            }

            if (r + 1 >= k) {
                res[l] = nums[q.peekFirst()];
                l++;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        var data = new int[]{1, 2, 1, 0, 4, 2, 6};
        var res = maxSlidingWindow(data, 3);
        System.out.println(Arrays.toString(res));
    }
}
