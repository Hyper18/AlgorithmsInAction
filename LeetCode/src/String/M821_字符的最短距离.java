package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/04/19
 * 思路
 * 1. 模拟，两次循环
 * 第一次记录所有的字符c的下标
 * 第二次为每一位不是字符c的字符求到最近的字符c的距离
 * <p>
 * 2. 双指针
 * 首先为数组赋初值，这里全部赋值为数组的最大长度即可（因为不可能超过这个值）
 * 其次通过last指示每次遇到的上一个字符c的位置
 * 通过遍历两次字符c之间的字符，来动态更新数组的最小值
 * 遍历后，将当前字符c的值赋给last，从而作为上一次的位置，依次循环
 */
public class M821_字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                pos.add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                continue;
            }
            int min = len;
            for (int idx : pos) {
                int cur = Math.abs(idx - i);
                if (cur < min) {
                    min = cur;
                }
            }
            ans[i] = min;
        }

        return ans;
    }

    public int[] shortestToChar2(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        Arrays.fill(ans, len);
        int last = -len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                // 这里需避免数组越界的情况
                for (int j = i; j >= Math.max(0, (i + last - 1) / 2); j--) {
                    // 这里已经保证了abs（i- j）总为正数
                    ans[j] = Math.min(ans[j], i - j);
                }
                last = i;
            } else {
                ans[i] = Math.min(ans[i], i - last);
            }
        }

        return ans;
    }
}
