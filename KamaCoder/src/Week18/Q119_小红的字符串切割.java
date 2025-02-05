package Week18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/11/07
 * @file Q119_小红的字符串切割.java
 * <p>
 * 题目描述
 * 小红拿到了一个字符串，她希望你帮她切割成若干子串，满足以下两个条件：
 * 1. 子串长度均为不小于 3 的奇数。
 * 2. 子串内部的字符全部相同。
 * <p>
 * 输入描述
 * 第一行输入一个正整数n，代表字符串长度。第二行输入一个字符串，仅由小写字母组成。
 * <p>
 * 输出描述
 * 如果无解，请输出-1。否则按顺序输出若干个字符串，用空格隔开。
 * <p>
 * 思路
 * 模拟
 * test case5为字符串尾的处理
 */
public class Q119_小红的字符串切割 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        if (n == 1) {
            System.out.println("-1");
        }
        List<String> res = new ArrayList<>();
        int l, r;
        for (l = 0, r = l + 1; r < n; r++) {
            if (cs[r] == cs[r - 1]) {
                continue;
            }
            int len = r - l;
            StringBuilder sb;
            if (len >= 3 && len % 2 == 1) {
                sb = new StringBuilder();
                while (len-- > 0) {
                    sb.append(cs[l]);
                }
                res.add(sb.toString());
            } else if (len > 4) {
                sb = new StringBuilder();
                int i = 0;
                while (i < 3) {
                    sb.append(cs[l]);
                    i++;
                }
                res.add(sb.toString());
                sb = new StringBuilder();
                while (i < len) {
                    sb.append(cs[l]);
                    i++;
                }
                res.add(sb.toString());
            } else {
                System.out.println("-1");
                return;
            }
            l = r;
        }
        int len = r - l;
        StringBuilder sb;
        if (len >= 3 && len % 2 == 1) {
            sb = new StringBuilder();
            while (len-- > 0) {
                sb.append(cs[l]);
            }
            res.add(sb.toString());
        } else if (len > 4) {
            sb = new StringBuilder();
            int i = 0;
            while (i < 3) {
                sb.append(cs[l]);
                i++;
            }
            res.add(sb.toString());
            sb = new StringBuilder();
            while (i < len) {
                sb.append(cs[l]);
                i++;
            }
            res.add(sb.toString());
        } else {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(i == n - 1 ? res.get(i) : res.get(i) + " ");
        }
    }
}
