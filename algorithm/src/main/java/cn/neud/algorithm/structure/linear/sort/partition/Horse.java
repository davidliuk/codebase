package cn.neud.algorithm.structure.linear.sort.partition;

import static cn.hutool.core.util.ArrayUtil.swap;

public class Horse {
    // quick sort horse partition
    public int partition(int[] nums, int l, int r) {
        int x = nums[l], i = l, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        return j;
    }
}
