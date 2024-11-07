package Week18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/07
 * @file Q119_小红的字符串切割.java
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
