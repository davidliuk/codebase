package cn.dlpenn.algorithm.structure.linear.sort.partition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    // 平均On，最差On2
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        int[][] values = occurrences.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);
        int size = values.length;
        quickSelect(values, 0, size - 1, size - k);
        int[] result = new int[k];
        for (int i = size - k; i < size; i++) {
            result[i - size + k] = values[i][0];
        }

        return result;
    }

    // 一下所有均为[start, end]闭区间
    int quickSelect(int[][] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start][0];
        }

        int p = partition(nums, start, end);
        if (start + k < p) {
            return quickSelect(nums, start, p - 1, k);
        }
        if (start + k > p) {
            return quickSelect(nums, p + 1, end, k - (p + 1 - start));
        }

        return nums[p][0];
    }

    public int partition(int[][] nums, int start, int end) {
        int left = start, right = end;
        // 随机化
        swap(nums, start, new Random().nextInt(end - start + 1) + start);
        int pivot = nums[start][1];

        while (left < right) {
            while (left < right && nums[right][1] >= pivot) {
                right--;
            }
            while (left < right && nums[left][1] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }

    private void swap(int[][] nums, int i, int j) {
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
