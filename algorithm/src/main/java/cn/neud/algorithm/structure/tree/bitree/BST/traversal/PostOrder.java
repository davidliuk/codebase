package cn.neud.algorithm.structure.tree.bitree.BST.traversal;

import java.util.ArrayList;
import java.util.Arrays;

public class PostOrder {
    public boolean verifyPostorder(int[] postorder) {
        return traverse(postorder, 0, postorder.length - 1);
    }

    boolean traverse(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int rightStart = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }
        return p == right
                && traverse(postorder, left, rightStart - 1)
                && traverse(postorder, rightStart, right - 1);
    }

}
