package algorithm.structure.linear.sort;

public class HeapSort {

    public void sort(int[] nums) {
        // 把这个最大元素换到最后
        heapify(nums);
        for (int size = nums.length - 1; size > 0; size--) {
            swap(nums, 0, size);
            // 让 heap[0] 下沉到正确位置
            sink(nums, 0, size);
        }
    }

    private void heapify(int[] nums) {
        int size = nums.length;
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            sink(nums, i, size);
    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int[] heap, int x, int size) {
        // 如果沉到堆底，就沉不下去了
        while (left(x) < size) {
            // 先假设左边节点较大
            int child = left(x);
            // 如果右边节点存在，比一下大小
            if (right(x) < size && !less(heap, child, right(x)))
                child = right(x);
            // 结点 x 比俩孩子都大，就不必下沉了
            if (!less(heap, child, x))
                break;
            // 否则，不符合最大堆的结构，下沉 x 结点
            swap(heap, x, child);
            x = child;
        }
    }

    /* 交换数组的两个元素 */
    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /* heap[i] 是否比 heap[j] 小？ */
    private boolean less(int[] heap, int i, int j) {
        return heap[i] - heap[j] > 0;
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

