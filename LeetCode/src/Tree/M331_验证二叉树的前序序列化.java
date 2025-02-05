package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/03/31
 * @file M331_验证二叉树的前序序列化.java
 * <p>
 * 思路
 * 把有效的叶子节点使用 "#" 代替
 */
public class M331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        List<String> stk = new ArrayList<>();
        for (String s : preorder.split(",")) {
            stk.add(s);
            while (stk.size() >= 3 && stk.get(stk.size() - 1).equals("#")
                    && stk.get(stk.size() - 2).equals("#") && !stk.get(stk.size() - 3).equals("#")) {
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.add("#");
            }
        }

        return stk.size() == 1 && stk.get(0).equals("#");
    }
}
