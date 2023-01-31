package algorithm.structure.tree.ntree;

import algorithm.structure.model.Node;
import algorithm.structure.tree.ntree.Codec;
import org.junit.jupiter.api.Test;

class CodecTest {

    Codec c = new Codec();

    @Test
    void serialize() {
    }

    @Test
    void deserialize() {
        Node node = c.deserialize("[1[2][3[5]][4]]");
        System.out.println(c.serialize(node));
        StringBuilder sb = new StringBuilder("0123456");
        sb.replace(1, 2, "a");
        sb.deleteCharAt(sb.length() - 1);
        int[] a = {1, 2, 3, 4};
        System.out.println(sb.toString());
    }
}
