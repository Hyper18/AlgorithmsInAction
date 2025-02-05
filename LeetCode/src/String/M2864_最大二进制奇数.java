package String;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/03/13
 * @file M2864_最大二进制奇数.java
 * <p>
 * 思路
 * 模拟，降序排序后将首个元素挪到尾部
 * 1. 朴素 效率最高
 * 2. 转字符数组的做法
 * 3. 不直接转字符数组的做法
 * <p>
 * 注：Java在JDK 11后可使用repeat()函数
 */
public class M2864_最大二进制奇数 {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' == 1) {
                cnt++;
            }
        }
        String ans = "";
        for (int i = 0; i < cnt - 1; i++) {
            ans += "1";
        }
        for (int i = 0; i < n - cnt; i++) {
            ans += "0";
        }

        return ans + "1";
    }

    public String maximumOddBinaryNumber2(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String ss = new StringBuilder(new String(c)).reverse().toString();

        return ss.substring(1) + ss.charAt(0);
    }

    public String maximumOddBinaryNumber3(String s) {
        int n = s.length();
        int cnt = Math.toIntExact(s.chars().filter(c -> c == '1').count());
        StringBuilder ans = new StringBuilder();
        int t = cnt;
        while (t-- > 1) {
            ans.append("1");
        }
        while (n-- - cnt > 0) {
            ans.append("0");
        }

        return ans + "1";
    }

//    public String maximumOddBinaryNumber4(String s) {
//        int cnt = (int) s.chars().filter(c -> c == '1').count();
//        return "1".repeat(cnt - 1) + "0".repeat(s.length() - cnt) + "1";
//    }
}
