package Spring2022.Week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/05/01
 * <p>
 * 思路
 * 模拟
 * 比较费劲的一道题
 * 一开始考虑用图论 - 链式向前星 解决，
 * 但是发现题干已经给出"每一次新出现的牛必定已在先前出现过"的限制条件
 * 故可以直接对其生肖差进行模拟
 */
public class Q3370_牛年 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final String[] YEAR = new String[]{"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    private static Map<String, Integer> idxMap = new HashMap<>();
    static int i;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        idxMap.put("Bessie", 0);
        while (n-- > 0) {
            String[] s = in.readLine().trim().split(" ");
            if ("previous".equals(s[3])) {
                for (i = idxMap.get(s[7]) - 1; ; i--) {
                    if (s[4].equals(YEAR[(i % 12 + 12) % 12])) {
                        break;
                    }
                }
                idxMap.put(s[0], i);
            } else {
                for (i = idxMap.get(s[7]) + 1; ; i++) {
                    if (s[4].equals(YEAR[(i % 12 + 12) % 12])) {
                        break;
                    }
                }
                idxMap.put(s[0], i);
            }
        }

        out.println(Math.abs(idxMap.get("Elsie")));

        in.close();
        out.close();
    }
}
