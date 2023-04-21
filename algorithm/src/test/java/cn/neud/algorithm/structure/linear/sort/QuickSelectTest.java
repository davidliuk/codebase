package cn.neud.algorithm.structure.linear.sort;

import cn.neud.algorithm.structure.linear.sort.QuickSelect;
import org.junit.jupiter.api.Test;

class QuickSelectTest {

    QuickSelect q = new QuickSelect();

    @Test
    void findKthLargest() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(q.findKthLargest(nums, 1));
        System.out.println("-------");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}