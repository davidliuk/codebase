package cn.dlpenn.algorithm.optimise.deconquer.delete;

import org.junit.jupiter.api.Test;


class MonotonicStackTest {

    int f = 0;

    @Test
    void push() {

        MonotonicStack<Integer> incrStack = new MonotonicStack<Integer>((a, b) -> a > b){{
            setPrev((a, b) -> System.out.println(f));
        }};
        MonotonicStack<Integer> decrStack = new MonotonicStack<Integer>((a, b) -> a < b){{
            setPrev((a, b) -> System.out.println(f));
        }};
    }
}