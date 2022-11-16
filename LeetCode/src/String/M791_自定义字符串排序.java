package String;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hyperspace
 * @date 2022/11/13
 * @file M791_自定义字符串排序.java
 * <p>
 * 思路
 * 1. 计数模拟
 * 先按序输出规定的字符
 * 再输出剩余无规定字符
 * 2. 自定义排序
 * 为规定次序的字符从小到大依次指定权重
 * 再按此权重升序排列s
 */
public class M791_自定义字符串排序 {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        return sb.toString();
    }

    public String customSortString2(String order, String s) {
        int[] weight = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            weight[order.charAt(i) - 'a'] = i;
        }
        List<Character> cs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            cs.add(s.charAt(i));
        }
        cs.sort(Comparator.comparingInt(c -> weight[c - 'a']));

        return cs.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
