package algorithm.structure.linear.sort;

import java.util.Random;

public class QuickSort {

    void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int start, int end) {
        // 递归出口
        if (start >= end) {
            return;
        }

        // 递归拆解
        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    int partition(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int p = partition(nums, start, end);
        int left = p + 1, right = p - 1;

        if (start + k < p) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k > p) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        return nums[p];
    }

    public int partition(int[] nums, int start, int end) {
        // 随机化
        swap(nums, start, new Random().nextInt(end - start + 1) + start);
        int pivot = nums[start];
        int left = start, right = end;

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

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
