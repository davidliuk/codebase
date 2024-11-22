package cn.dlpenn.algorithm.structure.linear.sort.partition;

import cn.dlpenn.algorithm.structure.model.ListNode;

public class ThreeWay {

    // lc912
    public int[] sortArray(int[] nums) {
        // 或者这里提前shuffle，然后后面pivot无序随机化
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    // [start, end]
    void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        // 递归拆解
        int p[] = partition(A, start, end);
        // 这种一个-1，一个+1的写法，需要p就是pivot
        // 必须把p本身分出来，如果不把p分出来，如果是全相等的序列，就不会缩小问题规模
        quickSort(A, start, p[0] - 1);
        quickSort(A, p[1] + 1, end);
    }

    // 三路快排，可以省去随机化，且快了六倍
    public int[] partition(int[] nums, int start, int end) {
        int pivot = nums[(start + end) / 2];
        for (int i = start; i <= end; i++) {
            while (i <= end && nums[i] > pivot) {
                swap(nums, i, end);
                end--;
            }
            if (nums[i] < pivot) {
                swap(nums, i, start);
                start++;
            }
        }
        return new int[]{start, end};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        quickSort(dummy, null);
        return dummy.next;
    }

    public void quickSort(ListNode prev, ListNode tail) {
        if (prev == tail || prev.next == tail || prev.next.next == tail) {
            return;
        }

        ListNode[] p = partition(prev, tail);

        // < 的链表和 > 的链表分别快排
        quickSort(prev, p[0]);
        quickSort(p[1], tail);
    }

    public ListNode[] partition(ListNode prev, ListNode tail) {
        ListNode dummy1 = prev;
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy3 = new ListNode(-1);
        ListNode head = prev.next;

        ListNode p1 = dummy1, p2 = dummy2, p3 = dummy3;
        ListNode p = head;
        int pivot = getMid(prev.next, tail).val;
        // 用中间节点的原因是，如果每次用最左边的结点，对于纯递增和纯递减的case就退化为O(n)
        // 三路pivot
        while (p != tail) {
            if (p.val < pivot) {
                p1.next = p;
                p1 = p1.next;
            } else if (p.val == pivot) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p3.next = p;
                p3 = p3.next;
            }
            p = p.next;
        }
        // 这句去掉会成环
        p3.next = tail;
        p2.next = dummy3.next;
        p1.next = dummy2.next;

        // 等于这一段的首尾
        return new ListNode[]{dummy2.next, p2};
    }

    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
