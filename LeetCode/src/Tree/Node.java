package Tree;

import java.util.List;

/**
 * @author Hyper
 * @date 2022/03/12
 * Definition for a Node.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
