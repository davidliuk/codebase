package cn.neud.algorithm.structure.linear.sort.partition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    Horse h = new Horse();

    @Test
    void partition() {
        h.partition(new int[]{2, 3, 4, 1, 0}, 0, 4);
    }
}