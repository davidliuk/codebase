package algorithm.structure.tree.ntree;

import algorithm.structure.model.Node;
import algorithm.structure.tree.ntree.Serialize;
import org.junit.jupiter.api.Test;

class SerializeTest {

    Serialize s = new Serialize();
    @Test
    void serialize() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        c.children.add(e);
        System.out.println(s.serialize(a));
    }

    @Test
    void deserialize() {
    }
}