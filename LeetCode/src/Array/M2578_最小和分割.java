package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/10/09
 * @file M2578_最小和分割.java
 * <p>
 * 思路
 * 排序模拟
 */
public class M2578_最小和分割 {
    public int splitNum(int num) {
        List<Integer> li = new ArrayList<>();
        while (num > 0) {
            int n = num % 10;
            li.add(n);
            num /= 10;
        }
        Collections.sort(li);
        int a = 0, b = 0;
        while (li.size() > 1) {
            int n1 = li.get(0), n2 = li.get(1);
            li.remove(0);
            li.remove(0);
            a = a * 10 + n1;
            b = b * 10 + n2;
        }
        if (!li.isEmpty()) {
            if (a > b) {
                b = b * 10 + li.get(0);
            }
            a = a * 10 + li.get(0);
        }

        return a + b;
    }

    public int splitNum2(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        Arrays.sort(s);
        int[] a = new int[2];
        for (int i = 0; i < n; i++) {
            a[i % 2] = a[i % 2] * 10 + s[i] - '0';
        }

        return a[0] + a[1];
    }
}
