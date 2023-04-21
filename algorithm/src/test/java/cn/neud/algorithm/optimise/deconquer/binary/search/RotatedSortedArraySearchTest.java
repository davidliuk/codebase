package cn.neud.algorithm.optimise.deconquer.binary.search;

import org.junit.jupiter.api.Test;


class RotatedSortedArraySearchTest {

    RotatedSortedArraySearch r = new RotatedSortedArraySearch();

    @Test
    void search() {
        System.out.println(r.search(new int[]{1, 0, 1, 1, 1}, 0));
    }
    
}