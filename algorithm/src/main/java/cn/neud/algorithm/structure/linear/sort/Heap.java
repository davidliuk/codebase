package cn.neud.algorithm.structure.linear.sort;

import java.util.*;
import java.util.function.IntConsumer;

public class Heap<E> {
    // 存储元素的数组
    private E[] heap;

    // 当前 Priority Queue 中的元素个数
    private int size = 0;

    private Comparator<? super E> comparator;

    public Heap(int initialCapacity) {
        this(initialCapacity, null);
    }

    public Heap(int initialCapacity, Comparator<? super E> comparator) {
        // 索引 0 不用，所以多分配一个空间
        heap = (E[]) new Object[initialCapacity + 1];
        this.comparator = comparator;
    }

    public Heap(E[] heap) {
        this(heap, null);
    }

    public Heap(E[] heap, Comparator<E> comparator) {
        this.heap = heap;
        size = heap.length;
        this.comparator = comparator;
        heapify();
    }

    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            sink(i);
    }

    public void reverseSort() {
        // 返回的是倒叙排序的结果，如果需要正序的，需要传入一个comparator
        while (!isEmpty()) {
            // 把这个最大元素换到最后
            size--;
            swap(0, size);
            // 让 heap[0] 下沉到正确位置
            sink(0);
        }
    }

    /* 返回当前队列中最大元素 */
    public E peek() {
        return heap[0];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    /* 插入元素 e */
    public void offer(E e) {
        // 先把新元素加到最后
        heap[size] = e;
        // 然后让它上浮到正确的位置
        swim(size);
        size++;
    }

    /* 删除并返回当前队列中最大元素 */
    public E poll() {
        // 最大堆的堆顶就是最大元素
        E top = heap[0];
        // 把这个最大元素换到最后，删除之
        size--;
        swap(0, size);
        heap[size] = null;
        // 让 heap[0] 下沉到正确位置
        sink(0);
        return top;
    }

    /* 上浮第 x 个元素，以维护最大堆性质 */
    private void swim(int x) {
        // 如果浮到堆顶，就不能再上浮了
        while (x > 0 && !less(parent(x), x)) {
            // 如果第 x 个元素比上层大
            // 将 x 换上去
            swap(parent(x), x);
            x = parent(x);
        }
    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int x) {
        // 如果沉到堆底，就沉不下去了
        while (left(x) < size) {
            // 先假设左边节点较大
            int child = left(x);
            // 如果右边节点存在，比一下大小
            if (right(x) < size && !less(child, right(x)))
                child = right(x);
            // 结点 x 比俩孩子都大，就不必下沉了
            if (!less(child, x))
                break;
            // 否则，不符合最大堆的结构，下沉 x 结点
            swap(x, child);
            x = child;
        }
    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /* heap[i] 是否比 heap[j] 小？ */
    private boolean less(int i, int j) {
        if (comparator != null) {
            return comparator.compare(heap[i], heap[j]) < 0;
        }

        Comparable<? super E> key = (Comparable<? super E>) heap[i];
        return key.compareTo(heap[j]) < 0;
    }

    /* 还有 left, right, parent 三个方法 */
    // 父节点的索引
    int parent(int root) {
        // 防止root=0, root-1=-1这时候直接右移会出问题
        return (root - 1) >>> 1;
    }

    // 左孩子的索引
    int left(int root) {
        return root * 2 + 1;
    }

    // 右孩子的索引
    int right(int root) {
        return root * 2 + 2;
    }

}
