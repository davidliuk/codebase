package algorithm.search.dfs.enumerate.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    List<List<Integer>> combine(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    void dfs(
            int[] nums,
            int startIndex,
            List<Integer> result,
            List<List<Integer>> results
    ) {
        // 前序位置，每个节点的值都是一个子集
        results.add(new ArrayList<>(result));

        for (int i = startIndex; i < nums.length; i++) {
            // 做选择
            result.add(nums[i]);
            // i + 1控制树枝的遍历，避免产生重复子集
            dfs(nums, i + 1, result, results);
            // 撤销选择
            result.remove(result.size() - 1);
        }
    }

    List<List<Integer>> combineUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);
        dfs2(nums, 0, new ArrayList<>(), results);
        return results;
    }

    void dfs2(
            int[] nums,
            int startIndex,
            List<Integer> result,
            List<List<Integer>> results
    ) {
        // 前序位置，每个节点的值都是一个子集
        results.add(new ArrayList<>(result));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            result.add(nums[i]);
            // i + 1控制树枝的遍历，避免产生重复子集
            dfs2(nums, i + 1, result, results);
            // 撤销选择
            result.remove(result.size() - 1);
        }
    }

}
