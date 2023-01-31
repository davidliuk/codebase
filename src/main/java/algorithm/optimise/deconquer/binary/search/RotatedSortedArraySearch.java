package algorithm.optimise.deconquer.binary.search;

public class RotatedSortedArraySearch extends BinarySearch {

    // 严格增序的旋转排序数组上搜索
    public boolean searchMin1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int pos = searchFirst(left, right, (mid) -> nums[mid] <= nums[n - 1]);
        return nums[pos] == target;
    }

    // 严格增序的旋转排序数组上搜索
    public boolean searchMax1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int pos = searchLast(left, right, (mid) -> nums[mid] >= nums[0]);
        return nums[pos] == target;
    }

    // 严格增序的旋转排序数组上搜索
    public boolean search1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int pos = searchFirst(left, right, (mid) -> check(nums, mid, target));
        return nums[pos] == target;
    }

    // 严格增序的旋转排序数组上搜索，推荐写法
    public boolean searchTwice1(int[] nums, int target) {
        int n = nums.length;
        int max = searchLast(0, n - 1, (mid) -> nums[mid] >= nums[0]);
        int left = searchLast(0, max, (mid) -> nums[mid] <= target);
        if (nums[left] == target) {
            return true;
        }
        int right = searchLast(max, n - 1, (mid) -> nums[mid] <= target);
        return nums[right] == target;
    }

    // 不严格增序的旋转排序数组上搜索
    public boolean searchMin2(int[] nums, int target) {
        int n = nums.length;
        int end = n - 1;
        // 恢复两段性
        while (0 < end && nums[end] == nums[0]) end--;
        int finalEnd = end;
        int pos = searchFirst(0, end, (mid) -> nums[mid] <= nums[finalEnd]);
        return nums[pos] == target;
    }

    // 不严格增序的旋转排序数组上搜索
    public boolean searchMax2(int[] nums, int target) {
        int n = nums.length;
        int end = n - 1;
        // 恢复两段性
        while (0 < end && nums[end] == nums[0]) end--;
        int pos = searchLast(0, end, (mid) -> nums[mid] >= nums[0]);
        return nums[pos] == target;
    }

    // 不严格增序的旋转排序数组上搜索
    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        int end = n - 1;
        // 恢复两段性
        while (0 < end && nums[end] == nums[0]) end--;
        int pos = searchFirst(0, end, (mid) -> check(nums, mid, target));
        return nums[pos] == target;
    }

    public boolean searchTwice2(int[] nums, int target) {
        int n = nums.length;
        int end = n - 1;
        // 恢复两段性
        while (0 < end && nums[end] == nums[0]) end--;
        int max = searchLast(0, end, (mid) -> nums[mid] >= nums[0]);
        int left = searchLast(0, max, (mid) -> nums[mid] <= target);
        if (nums[left] == target) {
            return true;
        }
        int right = searchLast(max, end, (mid) -> nums[mid] <= target);
        return nums[right] == target;
    }

    boolean check(int[] nums, int mid, int target) {
        int n = nums.length;
        if (nums[mid] < nums[n - 1]) {
            // 在右半部分，居然也可能在左右两侧！！！
            if (nums[mid] >= target || target > nums[n - 1]) {
                // 若mid大于等于target，则在最低点和mid之间，往左找；
                // 若target > nums[n - 1]，则一定在左半侧，也需要往左找
                return true;
            }
        } else {
            // 在左半部分
            if (nums[0] <= target && target <= nums[mid]) {
                // target，在0和mid之间，则往mid左侧找
                return true;
            }
        }

        return false;
    }
}
