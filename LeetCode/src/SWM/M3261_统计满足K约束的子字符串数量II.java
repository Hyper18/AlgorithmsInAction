package SWM;

/**
 * @author Hyper
 * @date 2024/11/12
 * @file M3261_统计满足K约束的子字符串数量II.java
 * <p>
 * 思路
 * 1. SWM TLE
 * 2. SWM+前缀和+二分
 * 两种二分的写法都是可行的
 * <p>
 * 注意前缀和计算不要爆int
 */
public class M3261_统计满足K约束的子字符串数量II {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int m = queries.length;
        long[] res = new long[m];
        char[] cs = s.toCharArray();
        for (int i = 0; i < m; i++) {
            int[] cnt = new int[2];
            for (int l = queries[i][0], r = queries[i][0]; r <= queries[i][1]; r++) {
                cnt[cs[r] - '0']++;
                while (cnt[0] > k && cnt[1] > k) {
                    cnt[cs[l++] - '0']--;
                }
                res[i] += r - l + 1;
            }
        }

        return res;
    }

    public long[] countKConstraintSubstrings2(String s, int k, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] cnt = new int[2], pos = new int[n];
        long[] pre = new long[n + 1];
        for (int l = 0, r = 0; r < n; r++) {
            cnt[s.charAt(r) - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            pos[r] = l;
            pre[r + 1] = pre[r] + r - l + 1;
        }
        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            int ql = queries[i][0], qr = queries[i][1], mid = binarySearch(pos, ql, qr + 1, ql), len = mid - ql;
            res[i] = pre[qr + 1] - pre[mid] + (long) (1 + len) * len / 2;
        }

        return res;
    }

    private int binarySearch(int[] pos, int low, int high, int target) {
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (pos[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int binarySearch2(int[] pos, int low, int high, int target) {
        while (low + 1 < high) {
            int mid = low + ((high - low) >> 1);
            if (pos[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }
}
