package cn.neud.algorithm.search.dfs.enumerate.combination;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset {



    List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    void dfs(
            int[] nums,
            int startIndex,
            List<Integer> result,
            List<List<Integer>> results
    ) {
        if (startIndex == nums.length) {
            return;
        }

        // 前序选择
        result.add(nums[startIndex]);
        // catch2
        results.add(new ArrayList<>(result));

        // 递归拆解兼递归出口
        // for 循环不会执行，也就结束了递归。
        for (int i = startIndex; i < nums.length; i++) {
            // i + 1控制树枝的遍历，避免产生重复子集
            dfs(nums, i + 1, result, results);
        }
        result.remove(result.size() - 1);
    }


}
