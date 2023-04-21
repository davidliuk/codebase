package cn.neud.algorithm.structure.tree.ntree;

import cn.neud.algorithm.structure.model.Node;

public class Serialize {

    public int pos = 1;

    public String dfs(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        ans.append(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            ans.append(dfs(root.children.get(i)));
        }
        ans.append("]");
        return ans.toString();
    }

    public Node solve(String data) {
        int num = 0;
        while (data.charAt(pos) >= '0' && data.charAt(pos) <= '9') {
            num *= 10;
            num += data.charAt(pos) - '0';
            pos++;
        }
        Node node = new Node(num);
        while (pos < data.length()) {
            if (data.charAt(pos) == '[') {
                ++pos;
                node.children.add(solve(data));
            } else if (data.charAt(pos) == ']') {
                pos++;
                return node;
            }
        }
        return null;
    }

    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        return dfs(root);
    }

    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        return solve(data);
    }
}
