package Week18;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/07
 * @file Q120_小红的数字匹配.java
 * <p>
 * 题目描述
 * 定义一个 “模板串“ 为一个由数字字符和 "?" 组成的字符串。
 * 我们可以通过将问号替换成数字字符来得到正整数。显然，一个模板串可能会和多个正整数匹配。
 * 例如: "1?2"可以和 102 或者 132 等正整数匹配。
 * 请注意，匹配的正整数不能包含前导零，例如"??1"可以匹配101，但不能匹配 001。
 * 小红拿到了一个模板串，她想知道，和这个模板串匹配的正整数中，第 k 小的是多少?
 * <p>
 * 输入描述
 * 第一行输入一个正整数 t，代表询问次数。
 * 接下来的 2 * t 行，每两行为一次询问:
 * 第一行输入一个字符串，仅由数字字符和 '?' 组成。
 * 第二行输入一个正整数 k，代表询问的是第 k 小。
 * <p>
 * 输出描述
 * 输出 t 行，每行输出一个答案。
 * 如果一共都没有k个匹配的正整数，则输出 -1。
 * 否则输出第小的匹配的正整数。
 * <p>
 * 思路
 * 模拟
 */
public class Q120_小红的数字匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            String s = in.nextLine();
            int k = Integer.parseInt(in.nextLine());
            char[] cs = s.toCharArray();
            String p = String.valueOf(k - 1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '?') {
                    cs[i] = i != 0 ? '0' : '1';
                }
            }
            int idx = p.length() - 1;
            boolean flag = cs[0] == '0';
            for (int i = s.length() - 1; i >= 0 && idx >= 0; i--) {
                if (s.charAt(i) == '?') {
                    if (i != 0) {
                        cs[i] = p.charAt(idx--);
                    } else {
                        if (p.charAt(idx) == '9') {
                            flag = true;
                            break;
                        }
                        cs[i] = (char) (p.charAt(idx--) + 1);
                    }
                }
            }
            if (idx >= 0) {
                flag = true;
            }
            if (flag) {
                System.out.println(-1);
            } else {
                System.out.println(String.valueOf(cs));
            }
        }
    }
}