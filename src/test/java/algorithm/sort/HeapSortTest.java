package algorithm.sort;

import algorithm.structure.linear.sort.HeapSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class HeapSortTest {

    HeapSort h = new HeapSort();

    @Test
    void sort() {
        int[] nums = new int[]{5, 2, 3, 1};
        h.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    @Test
    void sort2() {
        int[][] values = new int[][]{
                {1, 2},
                {2, 2},
                {3, 1},
                {4, 0}
        };

    }

    @Test
    void pq1() {
//        PriorityQueue<> pq
        int[][] m = new int[][]{
                {1, 2, 3},
                {1, 2}
        };
        System.out.println(11/10);
        System.out.println(15/10);
        System.out.println(19/10);
        System.out.println(-11 % 10);
//        m[0] = new int[2];
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
    }

    @Test
    void pq2() {
//        PriorityQueue<> pq
        int[][] m = new int[2][1];
        m[0][0] = 1;

        System.out.println(-(long) Integer.MIN_VALUE);
    }

    void tryInner(int m) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(m) {{
            for (int i = 0; i < m; i++)
                add(new ArrayList<>());
        }};
    }

}