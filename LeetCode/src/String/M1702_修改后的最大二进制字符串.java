package String;

/**
 * @author Hyperspace
 * @date 2024/04/10
 * @file M1702_修改后的最大二进制字符串.java
 * <p>
 * 思路
 * 一开始想双指针分别从左边和右边往中间缩，有问题
 * 发现本质是不会出现连续的0，如00，并将0尽量往右移动
 * 这里则是贪心的思想，最终使得答案恰含一个0
 * <p>
 * 待优化
 */
public class M1702_修改后的最大二进制字符串 {
    public String maximumBinaryString(String binary) {
        char[] c = binary.toCharArray();
        int n = c.length;
        int l = 0, r = n - 1;
        while (l <= r + 1) {
            if (c[r] == '0' && c[r - 1] != '0') {
                c[r] = '1';
                c[r - 1] = '0';
            }
            if (c[l] == '0' && c[l + 1] != '1') {
                c[l] = '1';
            }
            l++;
            r--;
        }

        return new String(c);
    }

    public String maximumBinaryString2(String binary) {
        int i = binary.indexOf('0');
        if (i < 0) {
            return binary;
        }
        char[] c = binary.toCharArray();
        int n = c.length;
        int cnt = 0;
        for (i++; i < n; i++) {
            cnt += c[i] - '0';
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n - 1 - cnt; j++) {
            sb.append('1');
        }
        sb.append('0');
        for (int j = 0; j < cnt; j++) {
            sb.append('1');
        }

        return sb.toString();
    }
}
