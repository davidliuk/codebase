package cn.dlpenn.algorithm.structure.linear.string;

import org.junit.jupiter.api.Test;

class ConvertTest {

    Convert c = new Convert();

    @Test
    void numberToWords() {
        System.out.println(c.numberToWords(101_0100));
    }
}