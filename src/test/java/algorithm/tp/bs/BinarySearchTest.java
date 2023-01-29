package algorithm.tp.bs;

import algorithm.optimise.deconquer.bs.BinarySearch;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BinarySearchTest {

    BinarySearch b = new BinarySearch();
    int[] a = {-2, 0, 1, 2, 2, 2, 3, 4, 4, 4, 6};
    int[] s = {1};

    @Test
    void searchFirst() {
        System.out.println(b.searchFirst(a, 2));
    }

    @Test
    void searchFirst2() {
        System.out.println(a.length);
        int last3 = b.searchFirst3(a, 5);
        System.out.println(last3);
        System.out.println(a[last3]);
        System.out.println("------");
        for (int i : a) {
            System.out.println(b.searchFirst(a, i));
        }
    }

    @Test
    void searchLast2() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(a.length);
        int last3 = b.searchLast3(a, -3);
        System.out.println(last3);
        System.out.println(a[last3]);
        System.out.println("------");
        for (int i : a) {
            System.out.println(b.searchLast2(a, i));
        }
        Map<Integer, Integer> a = new HashMap<>();
//        System.out.println(b.searchFirst(a, 2));
//        System.out.println(b.searchFirst(a, 0));
    }

    boolean hah (int i) {
        return false;
    }

    @Test
    void testSearchLast() {
        System.out.println(b.searchLastAnswer(a, (mid) -> a[mid] <= 2 ));
        b.searchLastAnswer(a, this::hah);
    }

    @Test
    void searchLast3() {
        System.out.println(s.length);
        System.out.println("------");
        for (int i : s) {
            System.out.println(b.searchLast2(s, i));
        }
    }

    @Test
    void testMySqrt() {
//        assertEquals(1, b.mySqrt(1));
        System.out.println(b.mySqrt(2147483647));
    }

    @Test
    void testSearch() {
//        assertEquals(1, b.mySqrt(1));
        System.out.println(b.search(new int[]{2,5,6,0,0,1,2}, 0));
    }

    @Test
    void testFindNumberIn2DArray() {
        // Setup
        final int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        // Run the test
        final boolean result = b.findNumberIn2DArray(matrix, 5);

        // Verify the results
        assertFalse(result);
    }

}