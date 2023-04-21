package cn.neud.algorithm.structure.linear.sort;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    Merge m = new Merge();

    @Test
    void nthUglyNumber() {
        new Random().nextInt();
        Objects.hash();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        List<String[]> lists = new ArrayList<>();
        lists.add(list.toArray(new String[0]));
        int length = list.toArray(new String[0]).length;
        System.out.println(length);
        System.out.println(lists.toArray(new String[0][]).length);
        System.out.println(m.nthUglyNumber(10));
    }

}