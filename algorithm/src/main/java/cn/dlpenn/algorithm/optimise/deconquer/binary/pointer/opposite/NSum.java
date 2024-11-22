package cn.dlpenn.algorithm.optimise.deconquer.binary.pointer.opposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NSum {

    public List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left], high = nums[right];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(low, high)));
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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // base case 1，异常输入
        if (n < 2 || nums.length < n) {
            return result;
        }
        // base case 2. 2的时候两数之和处理
        if (n == 2) {
            return twoSumTarget(nums, start, target);
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
//            List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - num);
//            for (List<Integer> s : sub) {
//                s.add(num);
//                result.add(s);
//            }
            result.addAll(nSum(nums, n - 1, i + 1, target - num).stream()
                    .peek(list -> list.add(num))
                    .collect(Collectors.toList()));
            // 剪枝，把所有与i相同的都去掉，这个本质上是带重复数的组合类问题
            while (i < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result.addAll(twoSumTarget(nums, i + 1, target - num).stream()
                    .peek(list -> list.add(num))
                    .collect(Collectors.toList()));
            // 跳过所有与i重的元素（但留一个，因为for循环会往下走一个）
            // 这里写法类似快慢双指针去重，但不完全一样
            // i + 1 < nums.length 等价于链表的p.next != null
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int left = start, right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left], high = nums[right];
            if (sum == target) {
//                result.add(new ArrayList<>(Arrays.asList(low, high)));
                result.add(Stream.of(low, high).collect(Collectors.toList()));
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
