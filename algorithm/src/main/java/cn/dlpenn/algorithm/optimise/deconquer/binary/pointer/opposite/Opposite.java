package cn.dlpenn.algorithm.optimise.deconquer.binary.pointer.opposite;

import java.util.Comparator;
import java.util.function.BiPredicate;

public class Opposite {
    public int[] oppositePtr(int left, int right, Comparator<Integer> comparator) {
        while (left < right) {
            // 根据 sum 和 target 的比较，移动左右指针
            switch (comparator.compare(left, right)) {
                case 0:
                    return new int[]{left, right};
                case 1:
                    left++;
                case -1:
                    right--;
            }
        }

        return new int[0];
    }

    public int[] oppositePtr(
            int left, int right,
            Comparator<Integer> comparator,
            BiPredicate<Integer, Integer> isValid
    ) {
        while (isValid.test(left, right)) {
            // 根据 sum 和 target 的比较，移动左右指针
            switch (comparator.compare(left, right)) {
                case 0:
                    return new int[]{left, right};
                case -1:
                    left++;
                case 1:
                    right--;
            }
        }

        return new int[0];
    }

}
