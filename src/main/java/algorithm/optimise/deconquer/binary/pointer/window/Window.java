package algorithm.optimise.deconquer.binary.pointer.window;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.IntConsumer;

public class Window {
    void windowPtr(
            int start, int end,
            BiPredicate<Integer, Integer> isValid,
            IntConsumer in, IntConsumer out,
            BiConsumer<Integer, Integer> prev,
            BiConsumer<Integer, Integer> next
    ) {
        int left = start, right = start;
        while (right < end) {
            in.accept(right);
            right++;
            while (left < right && !isValid.test(left, right)) {
                if (next != null) {
                    next.accept(left, right);
                }
                out.accept(left);
                left++;
            }
            if (prev != null) {
                prev.accept(left, right);
            }
        }
    }
}
