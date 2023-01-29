package algorithm.structure.tree.ntree;

import algorithm.structure.model.Node;

// lc428
class Codec {

    public int index = 1;

    public String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        dfs(root, ans);
        return ans.toString();
    }

    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        index = 1;
        return solve(data);
    }

    // 前序遍历生成的字符串
    public void dfs(Node root, StringBuilder ans) {
        if (root == null) {
            return;
        }

        ans.append("[");
        ans.append(root.val);
        for (Node child : root.children) {
            dfs(child, ans);
        }
        ans.append("]");
    }

    // 前序遍历
    public Node solve(String data) {
        int num = 0;
        while (Character.isDigit(data.charAt(index))) {
            num *= 10;
            num += data.charAt(index) - '0';
            index++;
        }
        Node node = new Node(num);
        while (index < data.length()) {
            char c = data.charAt(index);
            index++; // 跳过括号
            if (c == '[') {
                node.children.add(solve(data));
            } else if (c == ']') {
                // 这层的节点结束
                return node;
            }
        }

        // 出现异常输入有误或者确实是空节点
        return null;
    }
}