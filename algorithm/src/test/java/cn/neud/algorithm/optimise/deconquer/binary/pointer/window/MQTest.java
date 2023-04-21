package cn.neud.algorithm.optimise.deconquer.binary.pointer.window;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

class MQTest {

    MQ mq = new MQ();

    @Test
    void maxSlidingWindow() {
        System.out.println(Arrays.toString(mq.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

}
