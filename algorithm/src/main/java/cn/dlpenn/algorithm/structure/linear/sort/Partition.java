package cn.dlpenn.algorithm.structure.linear.sort;

public class Partition {

    // 交换法，推荐写法
    public int partition(int[] nums, int start, int end) {
        int k = start;
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            swap(nums, start, end);
        }
        swap(nums, k, start);
        return start;
    }

    // 挖坑法，同教材
    public int partition1(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    // lc写法
    public int partition2(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    // 拉不拉东写法
    public int partition3(int[] nums, int start, int end) {
        int pivot = nums[start];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [start, i) <= pivot；(j, end] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = start + 1, j = end;
        // 当 i > j 时结束循环，以保证区间 [start, end] 都被覆盖
        while (i <= j) {
            // 此 while 结束时恰好 nums[i] > pivot
            while (i < end && nums[i] <= pivot) {
                i++;
            }
            // 此 while 结束时恰好 nums[j] <= pivot
            while (j > start && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }
            // 此时 [start, i) <= pivot && (j, end] > pivot
            // 交换 nums[j] 和 nums[i]
            swap(nums, i, j);
            // 此时 [start, i] <= pivot && [j, end] > pivot
        }
        // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
