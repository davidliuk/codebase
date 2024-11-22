package cn.dlpenn.algorithm.structure.tree.bitree.heap;

import java.util.*;

public class Heap {
    class Pair implements Comparable<Pair> {
        int num, count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return -this.count + o.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<Pair> values = new ArrayList<>();
        occurrences.forEach((num, count) -> {
            values.add(new Pair(num, count));
        });
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<Pair> queue = new PriorityQueue<>(values);
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll().num;
        }
        return result;
    }
}
