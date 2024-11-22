package cn.dlpenn.algorithm.math;

import cn.dlpenn.algorithm.structure.model.TreeNode;
import org.junit.jupiter.api.Test;

class MathTest {

    Math m = new Math();

    @Test
    void myPow() {
        System.out.println("sss".substring(0, 0).length());
        System.out.println(m.myPow(2, 2));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        // override the above while loop
        while (root.val < p.val || root.val > q.val) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root;
    }


    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }


    public void partition(int[] nums, int start, int end, int pivot) {
        for (int i = 0; i <= end; i++) {
            while (i <= end && nums[i] > pivot) {
                swap(nums, i, end);
                --end;
            }
            if (nums[i] < pivot) {
                swap(nums, i, start);
                ++start;
            }
        }
    }

    void swap(int[]nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}