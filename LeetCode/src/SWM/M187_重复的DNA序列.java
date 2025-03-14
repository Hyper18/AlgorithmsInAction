package SWM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/11/06
 * @file M187_重复的DNA序列.java
 * <p>
 * 思路
 * SWM
 * 给定一个宽度为10的窗口
 * 向res加入所有出现超过1次的结果
 */
public class M187_重复的DNA序列 {
    private final int len = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n - len + 1; i++) {
            String ss = s.substring(i, i + len);
            int cnt = mp.getOrDefault(ss, 0);
            if (cnt == 1) {
                res.add(ss);
            }
            mp.put(ss, cnt + 1);
        }

        return res;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n - len + 1; i++) {
            String ss = s.substring(i, i + len);
            if (mp.getOrDefault(ss, 0) == 1) {
                res.add(ss);
            }
            mp.merge(ss, 1, Integer::sum);
        }

        return res;
    }
}
