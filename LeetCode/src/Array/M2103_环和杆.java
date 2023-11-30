package Array;

/**
 * @author Hyperspace
 * @date 2023/11/02
 * @file M2103_环和杆.java
 * <p>
 * 思路
 * 模拟
 */
public class M2103_环和杆 {
    final int N = 10;

    public int countPoints(String rings) {
        int n = rings.length();
        boolean[] r = new boolean[N], g = new boolean[N], b = new boolean[N];
        for (int i = 1; i < n; i++) {
            char c = rings.charAt(i - 1);
            int j = rings.charAt(i) - '0';
            switch (c) {
                case 'R':
                    r[j] = true;
                    break;
                case 'G':
                    g[j] = true;
                    break;
                case 'B':
                    b[j] = true;
                    break;
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (r[i] && g[i] && b[i]) {
                ans++;
            }
        }

        return ans;
    }
}
