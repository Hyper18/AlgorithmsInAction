package TwoPointer;

/**
 * @author Hyperspace
 * @date 2022/02/14
 * <p>
 * 思路
 * 1. 双指针
 * 注意Java中字符串不可变因此无法原地操作（字符数组可，见Q344）
 * 2. StringBuilder 拆分逆序再合并
 */
public class Q557_反转字符串中的单词III {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 <= p2) {
            int start = p1;
            while (p1 <= p2 && s.charAt(p1) != ' ') {
                p1++;
            }
            for (int idx = start; idx < p1; idx++) {
                sb.append(s.charAt(start + p1 - 1 - idx));
            }
            while (p1 <= p2 && s.charAt(p1) == ' ') {
                p1++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        String[] ss = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(new StringBuffer(ss[i]).reverse() + " ");
        }
        return sb.toString().trim();
    }
}
