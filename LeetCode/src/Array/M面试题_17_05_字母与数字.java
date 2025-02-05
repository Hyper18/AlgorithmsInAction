package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/03/11
 * @file M面试题_17_05_字母与数字.java
 * <p>
 * 思路 和昨天题一个思路
 * hash
 */
public class M面试题_17_05_字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, start = -1, len = 0;
        for (int i = 0; i < n; i++) {
            char c = array[i].charAt(0);
            if (Character.isDigit(c)) {
                sum++;
            } else if (Character.isLetter(c)) {
                sum--;
            }
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                if (i - last > len) {
                    len = i - last;
                    start = last + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (len == 0) {
            return new String[0];
        }

        return Arrays.copyOfRange(array, start, start + len);
    }

    public String[] findLongestSubarray2(String[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0, l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            char c = array[i].charAt(0);
            sum = Character.isDigit(c) ? sum + 1 : sum - 1;
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                if (i + 1 - last > r - l) {
                    l = last;
                    r = i + 1;
                }
            } else {
                map.put(sum, i + 1);
            }
        }

        return Arrays.copyOfRange(array, l, r);
    }
}
