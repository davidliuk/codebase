package cn.dlpenn.algorithm.optimise.deconquer.binary.search;

public class MountainArraySearch extends BinarySearch {

    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        // 第一个符合mid > mid+1的，即第一个开始往下走的，即上坡的顶端
        return searchFirst(0, n - 1,
                (mid) -> nums[mid] > nums[mid + 1]
        );
    }

    interface MountainArray {
        int get(int index);

        int length();
    }

    public int findInMountainArray(int target, MountainArray nums) {
        int n = nums.length();
        // 寻找峰值，第一个一个符合mid >= mid+1的，即上坡的末尾，下面就准备下坡或者平坡了
        int peak = searchFirst(0, n - 1,
                (mid) -> nums.get(mid) > nums.get(mid + 1)
        );
        // 搜索上坡
        int left = searchFirst(0, peak, (mid) -> nums.get(mid) >= target);
        if (nums.get(left) == target) {
            return left;
        }
        // 搜索下坡
        int right = searchFirst(peak, n - 1, (mid) -> nums.get(mid) <= target);
        if (nums.get(right) == target) {
            return right;
        }

        // 两边都没找到，则不存在
        return -1;
    }

}
