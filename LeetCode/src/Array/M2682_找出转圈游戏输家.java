package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/08/16
 * @file M2682_找出转圈游戏输家.java
 * <p>
 * 思路
 * 模拟
 */
public class M2682_找出转圈游戏输家 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] f = new boolean[n];
        int base = 0, step = 0;
        while (!f[base]) {
            f[base] = true;
            step += k;
            base = (base + step) % n;
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!f[i]) {
                li.add(i + 1);
            }
        }

        return li.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] circularGameLosers2(int n, int k) {
        boolean[] f = new boolean[n];
        int base = 0, step = 0;
        while (!f[base]) {
            f[base] = true;
            step += k;
            base = (base + step) % n;
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!f[i]) {
                li.add(i + 1);
            }
        }
        int[] res = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }

        return res;
    }

    public int[] circularGameLosers3(int n, int k) {
        boolean[] f = new boolean[n];
        int base = 0, step = 0, len = n;
        while (!f[base]) {
            f[base] = true;
            len--;
            step += k;
            base = (base + step) % n;
        }
        int[] res = new int[len];
        for (int i = 0, j = 0; i < n; i++) {
            if (!f[i]) {
                res[j++] = i + 1;
            }
        }

        return res;
    }
}
