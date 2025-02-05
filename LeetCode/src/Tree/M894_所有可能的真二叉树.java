package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/04/02
 * @file M894_所有可能的真二叉树.java
 * <p>
 * 思路
 * DP
 * 由题干知树节点必为奇数，且左子树节 + 右子树 = n − 1
 * 集合：f[i]表示叶节点数目为i的真二叉树数目
 * 属性：cnt
 */
public class M894_所有可能的真二叉树 {
    final int N = 10;
    List<TreeNode>[] f = new ArrayList[N + 1];

    public List<TreeNode> allPossibleFBT(int n) {
        Arrays.setAll(f, i -> new ArrayList<>());
        f[1].add(new TreeNode());
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                for (TreeNode l : f[j]) {
                    for (TreeNode r : f[i - j]) {
                        f[i].add(new TreeNode(0, l, r));
                    }
                }
            }
        }

        return f[(n & 1) == 1 ? (n + 1) >> 1 : 0];
    }
}
