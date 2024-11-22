package cn.dlpenn.algorithm.optimise.deconquer.delete;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class MonotonicStack<T> {

    Deque<T> stack = new ArrayDeque<>();
    BiPredicate<T, T> isValid;
    BiConsumer<T, T> prev;
    BiConsumer<T, T> next;

    public MonotonicStack(BiPredicate<T, T> isValid) {
        this.isValid = isValid;
    }

    public void push(T n) {
        // 将队尾小于 n 的元素全部删除
        while (!stack.isEmpty() && !isValid.test(stack.peek(), n)) {
            if (next != null) {
                next.accept(stack.peek(), n);
            }
            stack.pop();
        }
        if (!stack.isEmpty() && prev != null) {
            prev.accept(stack.peek(), n);
        }
        // 然后将 n 加入尾部
        stack.push(n);
    }

    public void setPrev(BiConsumer<T, T> prev) {
        this.prev = prev;
    }

    public void setNext(BiConsumer<T, T> next) {
        this.next = next;
    }


}
