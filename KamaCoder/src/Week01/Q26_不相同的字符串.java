package Week01;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/26
 * @file Q26_不相同的字符串.java
 * <p>
 * 思路
 * 贪心
 * 待优化
 */
public class Q26_不相同的字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while (k-- > 0) {
            char[] s = sc.next().toCharArray();
            int[] cnt = new int[26];
            for (char c : s) {
                cnt[c - 'a']++;
            }
            int ans = 0, last = 0;
            boolean flag = false;
            for (int i = 0; i < 25; i++) {
                int cur = cnt[i] / 2;
                if (cur < 1) {
                    continue;
                }
                if (last >= 26 && cnt[i] == 2) {
                    ans++;
                    continue;
                }
                ans += cur;
                cnt[i] -= cur * 2;
                int j;
                for (j = last; cur > 0 && j < 26; j++) {
                    if (cnt[j] == 0) {
                        cnt[j]++;
                        cur--;
                    }
                }
                if (last < j) {
                    last = j;
                }
                if (cur > 0) {
                    for (j = i + 1; j < 25; j++) {
                        if (cur % 2 == 0) {
                            if (cnt[j] % 2 == 1) {
                                cnt[j] += cur;
                                break;
                            } else {
                                cnt[j] += cur - 1;
                                cur = 1;
                                if (flag) {
                                    break;
                                }
                            }
                        } else {
                            if (cnt[j] % 2 == 0) {
                                cnt[j] += cur;
                                break;
                            } else if (cur > 1) {
                                cnt[j] += cur - 1;
                                cur = 1;
                                if (flag) {
                                    break;
                                }
                            }
                        }
                    }
                }
                if (cur == 1) {
                    cnt[25]++;
                    if (!flag) {
                        flag = true;
                    }
                }
            }
            ans += Math.max(0, cnt[25] - 1);
            System.out.println(ans);
        }
    }
}
