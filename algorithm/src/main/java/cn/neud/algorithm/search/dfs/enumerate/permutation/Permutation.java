package cn.neud.algorithm.search.dfs.enumerate.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        dfs1(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    // 搜索函数
    public void dfs1(
            int[] nums,
            boolean[] visited,
            List<Integer> result,
            List<List<Integer>> results
    ) {
        if (result.size() == nums.length) {
            // 打印函数
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 判断函数
            if (visited[i]) {
                continue;
            }
            // 做选择
            result.add(nums[i]);
            visited[i] = true;
            dfs1(nums, visited, result, results);
            // 取消选择
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        dfs2(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    // 搜索函数
    public void dfs2(
            int[] nums,
            boolean[] visited,
            List<Integer> result,
            List<List<Integer>> results
    ) {
        if (result.size() == nums.length) {
            // 打印函数
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 判断函数
            if (visited[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，相同只遍历第一条分支
            // 前一个元素这里不选的时候就都不选
            // 保证后面的一定在前面的后面选
            // 以固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 做选择
            result.add(nums[i]);
            visited[i] = true;
            dfs2(nums, visited, result, results);
            // 取消选择
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }

}
