package algorithm.structure.linear.linked.sort;

import algorithm.structure.model.ListNode;

import java.util.HashMap;

public class QuickSort {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        quickSort(dummy, null);
        return dummy.next;
    }

    // 左开右开(prev, tail)
    public void quickSort(ListNode prev, ListNode tail) {
        // 这种情况下至多只有一个元素，则返回
        if (prev == tail || prev.next == tail || prev.next.next == tail) {
            return;
        }
        ListNode mid = findMiddle(prev.next, tail);
        int temp = prev.next.val;
        prev.next.val = mid.val;
        mid.val = temp;

        // 或者替换成水塘抽样
        ListNode p = partition(prev, tail, prev.next.val);
        quickSort(prev, p);
        quickSort(p, tail);
        new HashMap<>();
    }

    public ListNode findMiddle(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 左开右开(prev, tail)
    // prev的好处：可以在原地partition，不会断开原链表
    public ListNode partition(ListNode prev, ListNode tail, int x) {
        ListNode dummy1 = prev;
        ListNode dummy2 = new ListNode(-1);
        ListNode head = prev.next;

        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != tail) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = tail;
        p1.next = dummy2.next;

        return dummy2.next;
    }

}