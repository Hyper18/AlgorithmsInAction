package TwoPointer;

/**
 * @author Hyperspace
 * @date 2023/08/21
 * @file M2337_移动片段得到字符串.java
 * <p>
 * 思路
 * 双指针
 * 一开始容易去考虑怎么移动的问题
 * 可以发现L/R均只能经过'_'移动
 * 无论如何移动，L/R之间的相对位置是不会发生变化的
 * 从而转化为匹配两串中L/R出现的顺序是否相同
 * 结合附加条件加以排除：
 * 1) 'L'只有左侧直接存在一个空位时才能向左移动
 * 2) 'R'只有右侧直接存在一个空位时才能向右移动
 */
public class M2337_移动片段得到字符串 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j) || (i < j && start.charAt(i) == 'L') || (i > j && target.charAt(j) == 'R')) {
                    return false;
                }
                i++;
                j++;
            } else if (i < n) {
                while (i < n) {
                    if (start.charAt(i) != '_') {
                        return false;
                    }
                    i++;
                }
            } else {
                while (j < n) {
                    if (target.charAt(j) != '_') {
                        return false;
                    }
                    j++;
                }
            }
        }

        return true;
    }
}
