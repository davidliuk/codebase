package cn.neud.algorithm.structure.linear.sort;

import cn.neud.algorithm.structure.linear.sort.Heap;
import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    void insert() {
        Heap<Integer> heap = new Heap<>(10, (a, b) -> b - a);
//        PriorityQueue
        int[] list = new int[]{1, 2, 3, 4, 5};
        for (int i : list) {
            heap.offer(i);
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    @Test
    void sort() {
//        PriorityQueue
        Integer[] list = new Integer[]{1, 2, 3, 4, 5};
        new Heap<>(list, (a, b) -> b - a).reverseSort();
        for (int i : list) {
            System.out.println(i);
        }
    }
}