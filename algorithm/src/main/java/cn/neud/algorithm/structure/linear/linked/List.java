package cn.neud.algorithm.structure.linear.linked;

import cn.neud.algorithm.structure.model.ListNode;

public class List {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // lc25
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = size(head);
        int group = n / k;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i = 0; i < group; i++) {
            reverseList(prev, k);
            prev = get(prev, k);
        }
        return dummy.next;
    }

    // 反转链表长度
    public ListNode[] reverseList(ListNode prev, int size) {
        // curr一开始在原链表的头节点，最后在新链表的尾节点
        ListNode curr = prev.next;
        ListNode end = null;
        // 反转 size 长度
        for (int i = 0; curr.next != end && i < size - 1; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        // return new ListNode[]{tail, curr};
        return new ListNode[]{prev.next, curr};
    }

    int size(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }

        return ans;
    }

    ListNode get(ListNode head, int pos) {
        for (int i = 0; i < pos; i++) {
            head = head.next;
        }

        return head;
    }
}
