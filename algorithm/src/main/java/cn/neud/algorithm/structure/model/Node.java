package cn.neud.algorithm.structure.model;

import java.util.ArrayList;

public class Node {
    public int val;
    public ArrayList<Node> children;

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
