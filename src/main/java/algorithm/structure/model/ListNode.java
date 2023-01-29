package algorithm.structure.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode form(int[] list) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }

        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.valueOf(val));
        ListNode p = next;
        while (p != null) {
            result.append(',');
            result.append(p.val);
            p = p.next;
        }
        return result.toString();
    }
}
