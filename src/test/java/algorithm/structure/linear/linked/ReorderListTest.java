package algorithm.structure.linear.linked;

import algorithm.structure.linear.linked.ReorderList;
import algorithm.structure.model.ListNode;
import org.junit.jupiter.api.Test;

class ReorderListTest {

    @Test
    void reorderList() {
        ListNode head = ListNode.form(new int[]{1, 2, 3, 4, 5});
        ReorderList r = new ReorderList();
        r.reorderList(head);
        System.out.println(head.toString());
    }
}