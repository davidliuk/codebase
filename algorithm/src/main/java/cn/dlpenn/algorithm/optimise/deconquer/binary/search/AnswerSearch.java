package cn.dlpenn.algorithm.optimise.deconquer.binary.search;

import java.util.*;

public class AnswerSearch extends BinarySearch {

    public List<List<Integer>> kSmallestPairs4(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            ans.add(Arrays.asList(nums1[idxPair[0]], nums2[idxPair[1]]));
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    boolean flag = true;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n > m && !(flag = false)) {
            return kSmallestPairs(nums2, nums1, k);
        }
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        for (int i = 0; i < Math.min(n, k); i++) q.add(new int[]{i, 0});
        while (ans.size() < k && !q.isEmpty()) {
            int[] poll = q.poll();
            int a = poll[0], b = poll[1];
            ans.add(new ArrayList<Integer>() {{
                add(flag ? nums1[a] : nums2[b]);
                add(flag ? nums2[b] : nums1[a]);
            }});
            if (b + 1 < m) q.add(new int[]{a, b + 1});
        }

        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> results = new ArrayList<>();
        int x = searchFirst(nums1[0] + nums2[0], nums1[m - 1] + nums2[n - 1], (mid) -> {
            long cnt = 0;
            int start = 0, end = n - 1;
            while (start < m && end >= 0) {
                if (nums1[start] + nums2[end] > mid) {
                    end--;
                } else {
                    cnt += end + 1;
                    start++;
                }
            }
            return cnt >= k;
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] + nums2[j] >= x) {
                    break;
                }
                results.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }

        int l, r;
        for (int i = 0; i < n && results.size() < k; i++) {
            int a = nums1[i], b = x - a;
            int c = -1, d = -1;
            l = 0;
            r = m - 1;
            while (l < r) {
                int mid = (int) (0L + l + r >> 1);
                if (nums2[mid] >= b) r = mid;
                else l = mid + 1;
            }
            if (nums2[r] != b) continue;
            c = r;
            l = 0;
            r = m - 1;
            while (l < r) {
                int mid = (int) (0L + l + r + 1) >> 1;
                if (nums2[mid] <= b) l = mid;
                else r = mid - 1;
            }
            d = r;
            for (int p = c; p <= d && results.size() < k; p++) {
                results.add(Arrays.asList(a, b));
            }
        }

        return results;
    }

//    int ans = 0;
//        for (int i = 0; i < m && ans < k; i++) {
//        for (int j = 0; j < n && ans < k; j++) {
//            if (nums1[i] + nums2[j] > x) {
//                break;
//            }
//            ans++;
//        }
//    }
//
//        return ans >= k;

}
