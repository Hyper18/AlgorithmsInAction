package Greedy;

/**
 * @author Hyper
 * @date 2025/08/16
 * @file M136_只出现一次的数字.java
 * <p>
 * 思路
 * 贪心
 */
public class M1323_6和9组成的最大数字 {
    class Solution1_0 {
        public int maximum69Number(int num) {
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            int i = sb.indexOf("6");
            if (i >= 0) {
                sb.replace(i, i + 1, "9");
            }

            return Integer.parseInt(sb.toString());
        }
    }

    class Solution1_1 {
        public int maximum69Number(int num) {
            char[] cs = String.valueOf(num).toCharArray();
            int n = cs.length;
            for (int i = 0; i < n; i++) {
                if (cs[i] == '6') {
                    cs[i] = '9';
                    break;
                }
            }

            return Integer.parseInt(new String(cs));
        }
    }
}
