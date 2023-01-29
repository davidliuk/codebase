package algorithm.math;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    Math m = new Math();

    @Test
    void myPow() {
        System.out.println(m.myPow(2, 2));
    }
}