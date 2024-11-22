package cn.dlpenn.algorithm.structure.tree.bitree;

import cn.dlpenn.algorithm.structure.model.TreeNode;

import java.util.Arrays;

public class Codec {
    // lc297
    static class Identifier {
        // 代表分隔符的字符
        static String SEP = ",";
        // 代表 null 空指针的字符
        static String NULL = "null";
    }

    /* 主函数，将二叉树序列化为字符串 */
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(Identifier.NULL).append(Identifier.SEP);
            return;
        }

        sb.append(root.val).append(Identifier.SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int index;
    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        // 将字符串转化成列表
        String[] nodes = data.split(Identifier.SEP);

        index = 0;
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(String[] nodes) {
        if (index == nodes.length) {
            return null;
        }

        // 前序位置
        // 获取当前待构造节点的值
        String value = nodes[index];
        index++;
        if (value.equals(Identifier.NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        int[] s1 = Arrays.stream("Sss".split("s")).mapToInt(s -> Integer.valueOf(s)).toArray();
        return root;
    }

}
