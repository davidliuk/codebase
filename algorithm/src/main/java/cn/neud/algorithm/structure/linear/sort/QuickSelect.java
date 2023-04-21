package cn.neud.algorithm.structure.linear.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuickSelect {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // 一下所有均为[start, end]闭区间
    int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int p = partition(nums, start, end);
        if (start + k < p) {
            return quickSelect(nums, start, p - 1, k);
        }
        if (start + k > p) {
            return quickSelect(nums, p + 1, end, k - (p + 1 - start));
        }

        return nums[p];
    }

    public int partition(int[] nums, int start, int end) {
        int left = start, right = end;
        // 随机化
        swap(nums, start, new Random().nextInt(end - start + 1) + start);
        int pivot = nums[start];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
