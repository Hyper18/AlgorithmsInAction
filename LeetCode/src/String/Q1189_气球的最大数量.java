package String;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/13
 * <p>
 * 思路
 * 枚举种类C各出现次数，取最小值 -- O(n+C)
 */
public class Q1189_气球的最大数量 {
    public int maxNumberOfBalloons(String text) {
        int[] res = new int[5];
        char[] origin = text.toCharArray();
        for (int i = 0; i < origin.length; i++) {
            switch (origin[i]) {
                case 'b':
                    res[0]++;
                    break;
                case 'a':
                    res[1]++;
                    break;
                case 'l':
                    res[2]++;
                    break;
                case 'o':
                    res[3]++;
                    break;
                case 'n':
                    res[4]++;
                    break;
            }
        }
        res[2] /= 2;
        res[3] /= 2;
        return Arrays.stream(res).min().getAsInt();
    }
}
