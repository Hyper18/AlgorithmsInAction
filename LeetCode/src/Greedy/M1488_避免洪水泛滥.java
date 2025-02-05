package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Hyper
 * @date 2023/10/13
 * @file M1488_避免洪水泛滥.java
 * <p>
 * 思路
 * 题干很绕，还没有交代必须抽的时候输出什么
 * 一开始以为rains[i]对应的是湖泊的序号
 * 而rains = {69, 0, 0, 0, 69}给的样例输出又是{-1,69,1,1,-1}
 * 中间两个1实在不理解，看题解写的是必须抽不知道抽哪个湖就去抽1。。。
 */
public class M1488_避免洪水泛滥 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        TreeSet<Integer> pos = new TreeSet<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int r = rains[i];
            if (r == 0) {
                pos.add(i);
                res[i] = 1;
            } else {
                if (mp.containsKey(r)) {
                    Integer idx = pos.higher(mp.get(r));
                    if (idx == null) {
                        return new int[]{};
                    }
                    res[idx] = r;
                    pos.remove(idx);
                }
                mp.put(r, i);
            }
        }

        return res;
    }
}
