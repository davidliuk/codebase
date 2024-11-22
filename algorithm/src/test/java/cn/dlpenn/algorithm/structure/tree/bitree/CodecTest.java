package cn.dlpenn.algorithm.structure.tree.bitree;

import cn.dlpenn.algorithm.structure.model.TreeNode;
import org.junit.jupiter.api.Test;

class CodecTest {

    Codec c = new Codec();

    @Test
    void serialize() {
    }

    @Test
    void deserialize() {
        TreeNode node = c.deserialize("1,2,3,null,null,4,5");
        String serialize = c.serialize(node);
        System.out.println(serialize);
        System.out.println(c.serialize(c.deserialize(serialize)));
    }
}