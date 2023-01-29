package algorithm.structure.linear.linked.merge;

import algorithm.structure.model.ListNode;

public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        return mergeSort(head, null);
    }

    public ListNode findMiddle(ListNode head, ListNode tail) {
        ListNode slow =  head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode mid = findMiddle(head, tail);
        // 左边不包括mid，右边包括
        ListNode left = mergeSort(head, mid);
        ListNode right = mergeSort(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}