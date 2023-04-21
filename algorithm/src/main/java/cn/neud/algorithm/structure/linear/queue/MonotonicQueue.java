package cn.neud.algorithm.structure.linear.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/* 单调队列的实现，可以高效维护最大值和最小值 */
class MonotonicQueue<E extends Comparable<E>> {
    // 常规队列，存储所有元素
    Deque<E> queue = new ArrayDeque<>();
    // 元素降序排列的单调队列，头部是最大值
    Deque<E> maxQueue = new ArrayDeque<>();
    // 元素升序排列的单调队列，头部是最小值
    Deque<E> minQueue = new ArrayDeque<>();

    public void push(E e) {
        // 维护常规队列，直接在队尾插入元素
        queue.offer(e);

        // 维护 maxq，将小于 e 的元素全部删除
        while (!maxQueue.isEmpty() && maxQueue.getLast().compareTo(e) < 0) {
            maxQueue.pollLast();
        }
        maxQueue.offer(e);

        // 维护 minq，将大于 e 的元素全部删除
        while (!minQueue.isEmpty() && minQueue.getLast().compareTo(e) > 0) {
            minQueue.pollLast();
        }
        minQueue.offer(e);
    }

    public E max() {
        // maxq 的头部是最大元素
        return maxQueue.peek();
    }

    public E min() {
        // minq 的头部是最大元素
        return minQueue.peek();
    }

    public E pop() {
        // 从标准队列头部弹出需要删除的元素
        E deleteVal = queue.poll();
        assert deleteVal != null;

        // 由于 push 的时候会删除元素，deleteVal 可能已经被删掉了
        if (deleteVal.equals(maxQueue.peek())) {
            maxQueue.poll();
        }
        if (deleteVal.equals(minQueue.peek())) {
            minQueue.poll();
        }
        return deleteVal;
    }

    public int size() {
        // 标准队列的大小即是当前队列的大小
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
