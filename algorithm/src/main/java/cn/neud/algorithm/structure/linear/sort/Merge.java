package cn.neud.algorithm.structure.linear.sort;

import java.util.*;

public class Merge {
    void merge(int[] nums, int start, int end, int[] temp) {
        int mid = (end - start) / 2 + start;
        int index = start;
        int left = start, right = mid + 1;

        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index] = nums[left];
                left++;
            } else {
                temp[index] = nums[right];
                right++;
            }
            index++;
        }

        // joint left numbers
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        // or System.arraycopy(temp, start, nums, start, end + 1 - start);
    }

    // lc88
    // On, On
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index = 0;
        int left = 0, right = 0;

        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                temp[index] = nums1[left];
                left++;
            } else {
                temp[index] = nums2[right];
                right++;
            }
            index++;
        }

        // joint left numbers
        while (left < m) {
            temp[index++] = nums1[left++];
        }
        while (right < n) {
            temp[index++] = nums2[right++];
        }
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    // On, O1
    // 倒着双指针
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int p1 = m - 1, p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[tail] = nums1[p1];
                p1--;
            } else {
                nums1[tail] = nums2[p2];
                p2--;
            }
            tail--;
        }

        // joint left numbers
        while (p1 >= 0) {
            nums1[tail--] = nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[tail--] = nums2[p2--];
        }
    }

    final int[] factors = {2, 3, 5};
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> uglys[a[0]] * a[1]));
        for (int factor : factors) {
            pq.offer(new int[]{0, factor});
        }
        for (int i = 1; i < n; i++) {
            int[] now = pq.poll();
            uglys[i] = uglys[now[0]] * now[1];
            if (i < n - 1) {
                pq.offer(new int[]{now[0] + 1, now[1]});
            }
        }

        return uglys[n - 1];
    }
}
