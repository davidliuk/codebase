package cn.dlpenn.algorithm.structure.linear.sort.partition;

import cn.dlpenn.algorithm.structure.model.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ThreeWayTest {

    ThreeWay t = new ThreeWay();
    int[] a = new int[]{1, 2, 3, 4, 5};
    int[] b = new int[]{2, 3, 1, 4, 5};
    int[] c = new int[]{5, 4, 3, 2, 1};

    @Test
    void sortArray() {
        System.out.println(Arrays.toString(t.sortArray(a)));
    }

    @Test
    void sotList() {
//        ListNode list = ListNode.form(new int[]{4, 2, 1, 3});
        ListNode list = ListNode.form(new int[]{-1, 5, 3, 4, 0});
//        ListNode list = ListNode.form(new int[]{});
        System.out.println(t.sortList(list));
    }
}