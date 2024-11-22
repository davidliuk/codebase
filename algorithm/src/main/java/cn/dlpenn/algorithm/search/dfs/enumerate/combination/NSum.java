package cn.dlpenn.algorithm.search.dfs.enumerate.combination;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // 递归调用
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int startIndex, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 递归出口
        if (n < 2 || nums.length < n) {
            return result;
        }
        if (n == 2) {
            return twoSumTarget(nums, startIndex, target);
        }

        // 递归拆解
        for (int i = startIndex; i < nums.length; i++) {
            // 实际上是排列组合
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            // 局部变量，父传子int类型，故无序回溯了
            int num = nums[i];
            result.addAll(nSum(nums, n - 1, i + 1, target - num).stream()
                    .peek(list -> list.add(num))
                    .collect(Collectors.toList()));
        }

        return result;
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // nums 数组必须有序
        // Arrays.sort(nums);
        int left = start, right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left], high = nums[right];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(low, high)));
                // 排除重复选择
                while (left < right && nums[left] == low) left++;
                while (left < right && nums[right] == high) right--;
            }

            if (sum < target) {
                while (left < right && nums[left] == low) left++;
            } else {
                while (left < right && nums[right] == high) right--;
            }
        }

        return result;
    }

}
