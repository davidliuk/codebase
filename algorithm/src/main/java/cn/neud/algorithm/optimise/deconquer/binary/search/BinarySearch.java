package cn.neud.algorithm.optimise.deconquer.binary.search;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class BinarySearch {

    public static int searchFirst(int start, int end, IntPredicate isValid) {
        while (start < end) {
            int mid = start + (end - start) / 2 + 1;
            if (isValid.test(mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static int searchLast(int start, int end, IntPredicate isValid) {
        while (start < end) {
            int mid = start + (end - start) / 2 + 1;
            if (isValid.test(mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static double search(double start, double end, double eps, DoublePredicate isValid) {
        while (start + eps < end) {
            double mid = start + (end - start) / 2;
            if (isValid.test(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return start;
    }

    int searchFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // + 1 的原因是，避免搜索区间只有两个数字时 mid 一直等于 left 导致死循环
        // + 1 的好处是，1. 不用再管start和end加一减一的问题了，也不用管mid想上向下取整的问题了；2. 求平方根问题可以把+1改为任何数，可以确定精度
        // + 1 的坏处是，1. 二分到最后区间里有两个元素，无法直接确定哪个是答案，有些题目下会比较麻烦；2. 写法与以前的相向双指针不统一
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    int searchFirst2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                // 这里 + 1 的原因是：
                // 避免搜索区间只有两个数字时 mid 一直等于 left 导致死循环
                start = mid + 1;
            }
        }

        return nums[start] == target ? start : -1;
    }

    int searchLast2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2 + 1;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                // 这里 - 1 的原因是：
                // 避免搜索区间只有两个数字时 mid 一直等于 right 导致死循环
                end = mid - 1;
            }
        }

        return nums[start] == target ? start : -1;
    }

    int searchLast3(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    int mySqrt(int target) {
        if (target == 0) {
            return 0;
        }
        int start = 1, end = target;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (mid <= target / mid) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public boolean judgeSquareSum(int c) {
        long left = 0, right = mySqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = n * m - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (get(matrix, mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return get(matrix, start) == target;
    }

    int get(int[][] matrix, int index) {
        int x = index / matrix[0].length;
        int y = index % matrix[0].length;
        return matrix[x][y];
    }

    <T> void swap(T[] nums, int i, int j) {
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int i = searchFirst(0, m, (mid) -> {
            int j = (m + n + 1) / 2 - mid;
            return mid == 0 || j == n || nums1[mid - 1] <= nums2[j];
        });
        int j = (m + n + 1) / 2 - i;
        // left1, right1, left2, right2
        // 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
        int left1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
        int left2 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
        int median1 = Math.max(left1, left2);
        int right1 = (i == m ? Integer.MAX_VALUE : nums1[i]);
        int right2 = (j == n ? Integer.MAX_VALUE : nums2[j]);
        // median1：前一部分的最大值, median2：后一部分的最小值
        int median2 = Math.min(right1, right2);

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                right -= 1;
            } else if (nums[left] <= nums[mid]) {
                // 处于反转过去的部分（数值更大的那部分）
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // 处于原数组的前面部分（数值更大的那部分）
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target;
    }
}
