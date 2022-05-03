package String;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/05/03
 * <p>
 * 思路
 * 最初考虑先分组在自定义排序
 * 后来发现可直接在自定义排序中处理
 * 作分类讨论，共有4种可能的情况
 */
public class M937_重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] strA = a.split(" ", 2); // 通过指定一个limit，只分割前两个数组
            String[] strB = b.split(" ", 2);
            boolean isDigitA = Character.isDigit(strA[1].charAt(0));
            boolean isDigitB = Character.isDigit(strB[1].charAt(0));

            // 情况1：两篇日志均为字母日志，按照从第二组单词开始的字典序排序
            if (!isDigitA && !isDigitB) {
                if (!strA[1].equals(strB[1])) {
                    return strA[1].compareTo(strB[1]);
                } else {
                    return strA[0].compareTo(strB[0]);
                }
            }

            // 情况2：两篇日志均为数字日志，保留原顺序（置0，则默认两者相等，比较器不对两者做任何处理）
            if (isDigitA && isDigitB) {
                return 0;
            } else if (!isDigitA) { // 情况3：前一篇为字母日志，而后一篇为数字日志：字母日志在数字日志之前
                return -1;
            } else {
                return 1; // 情况4：后一篇为字母日志，而前一篇为数字日志：字母日志在数字日志之前
            }

        });

        return logs;
    }
}
