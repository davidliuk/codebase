package cn.dlpenn.algorithm.optimise.deconquer.binary.pointer.window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MQ {
    /* 单调队列的实现 */
    class MonotonicQueue {
        LinkedList<Integer> maxq = new LinkedList<>();

        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!maxq.isEmpty() && maxq.getLast() < n) {
                maxq.pollLast();
            }
            // 然后将 n 加入尾部
            maxq.addLast(n);
        }

        public int max() {
            return maxq.getFirst();
        }

        public void pop(int n) {
            if (n == max()) {
                maxq.pollFirst();
            }
        }
    }

    /* 解题函数的实现 */
    int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}
