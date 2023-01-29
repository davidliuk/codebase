package algorithm.structure.linear.linked;

import algorithm.structure.model.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        mid = reverse(mid);
        merge(head, mid);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            // 将next移出
            curr.next = next.next;
            // 把next插入到prev后面
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (l1 != null && l2 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;

            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        // 因为两者要么等长，要么是l2多一个，所以不需要处理剩余的（因为l2多的那个就跟在后面，软管为了复用性也可以加处理冗余）

        return dummy.next;
    }

}