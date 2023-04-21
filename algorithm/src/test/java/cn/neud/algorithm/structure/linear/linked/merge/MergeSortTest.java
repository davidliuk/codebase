package cn.neud.algorithm.structure.linear.linked.merge;

import cn.neud.algorithm.structure.linear.linked.merge.MergeSort;
import cn.neud.algorithm.structure.model.ListNode;
import org.junit.jupiter.api.Test;


class MergeSortTest {

    @Test
    void sortList() {
//        ListNode head = new ListNode(4);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
        ListNode head = ListNode.form(new int[]{4, 2, 1, 3});
        MergeSort s = new MergeSort();
//        ListNode middle = s.findMiddle(null, null);
//        System.out.println(middle);
        ListNode node = s.sortList(head);
        System.out.println(node.toString());
    }
}