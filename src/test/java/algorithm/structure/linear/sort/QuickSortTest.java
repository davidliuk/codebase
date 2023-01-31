package algorithm.structure.linear.sort;

import algorithm.structure.linear.sort.QuickSort;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    QuickSort s = new QuickSort();

    @Test
    void sort() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        s.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    @Test
    void findKthLargest() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(s.findKthLargest(nums, 5));
        System.out.println("-------");
        for (int num : nums) {
            System.out.println(num);
        }
    }

    @Test
    void partition() {
        // mid = 0, 5
//        int[] nums = new int[]{5, 1};
        // 5,2,3,1; mid = 2, 2
//        int[] nums = new int[]{1, 5, 2, 3, 1};
        // mid = 2, 1 0
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int p = s.partition(nums);
        System.out.println(p);
        System.out.println("Sssssss");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}