package algorithm.linked.sort;

import algorithm.structure.linear.linked.sort.QuickSort;
import algorithm.structure.model.ListNode;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

class QuickSortTest {

    QuickSort q = new QuickSort();

    public static class Pair<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
        public Pair(K key, V value) {
            super(key, value);
        }
    }

    @Test
    void sortList() {
        System.out.println(Double.MAX_VALUE);
        AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(1, 1);
        ListNode head = ListNode.form(new int[]{4, 2, 1, 3});
        ListNode node = q.sortList(head);
        System.out.println(node.toString());
    }
}