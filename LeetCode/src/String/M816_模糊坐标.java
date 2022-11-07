package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/11/07
 * <p>
 * 思路
 * 枚举，
 * 因为给定是二维坐标，
 * 所以可先切分为逗号分隔的左右两个数，
 * 再在每一部分找小数点两侧位置所有可能情况
 */
public class M816_模糊坐标 {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<String> sx = split(s.substring(0, i)), sy = split(s.substring(i));
            for (String x : sx) {
                for (String y : sy) {
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }

        return res;
    }

    private List<String> split(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n == 1) {
            res.add(s);
            return res;
        }

        // 处理0
        if (s.charAt(0) == '0' && s.charAt(n - 1) == '0') {
            return res;
        }
        // 处理多余前置0
        if (s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }
        // 处理多余后置0
        if (s.charAt(n - 1) == '0') {
            res.add(s);
            return res;
        }

        res.add(s);
        for (int i = 1; i < n; i++) {
            res.add(s.substring(0, i) + '.' + s.substring(i));
        }

        return res;
    }
}
