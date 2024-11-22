package cn.dlpenn.algorithm.optimise.deconquer.delete;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.function.BiPredicate;

public class MonotonicQueue<T> {

    Deque<T> queue;
    // 底部维护最小值
    MonotonicStack<T> incrStack;
    // 底部维护最大值
    MonotonicStack<T> decrStack;

    public MonotonicQueue(BiPredicate<T, T> isValid) {
        queue = new ArrayDeque<>();
        incrStack = new MonotonicStack<>(isValid);
        decrStack = new MonotonicStack<>(isValid);
    }

    public void offer(T n) {
        queue.offer(n);
        incrStack.push(n);
        decrStack.push(n);
    }

    public T max() {
        return decrStack.stack.peekLast();
    }

    public T min() {
        return incrStack.stack.peekLast();
    }

    public void poll() {
        T n = queue.poll();
        // 要移出队列的元素如果是最大值，则队列更新，否则无需改变
        if (Objects.equals(n, max())) {
            decrStack.stack.pollLast();
        }
        if (Objects.equals(n, min())) {
            decrStack.stack.pollLast();
        }
    }
}