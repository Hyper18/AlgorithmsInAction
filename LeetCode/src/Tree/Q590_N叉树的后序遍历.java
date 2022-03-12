package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * <p>
 * 思路
 * 1. 递归
 * 和二叉树的区别在于每颗树的子节点可为大于两个
 * 2. 迭代
 * 主要需要考虑如何存放子结点的下标信息
 * 迭代写起来还是有难度
 */
public class Q590_N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Node cur = root;
        dfs(cur, res);
        return res;
    }

    private void dfs(Node cur, List<Integer> res) {
        if (cur == null) {
            return;
        }
        for (Node node : cur.children) {
            dfs(node, res);
        }
        res.add(cur.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stk = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        Node cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                List<Node> children = cur.children;
                if (children != null && children.size() > 0) {
                    map.put(cur, 0);
                    cur = children.get(0);
                } else {
                    cur = null;
                }
            }
            cur = stk.peek();
            int idx = map.getOrDefault(cur, -1) + 1;
            List<Node> children = cur.children;
            if (children != null && children.size() > idx) {
                map.put(cur, idx);
                cur = children.get(idx);
            } else {
                res.add(cur.val);
                stk.pop();
                map.remove(cur);
                cur = null;
            }
        }

        return res;
    }
}
