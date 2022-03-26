package Y2016A;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/03/26
 * 首次出现 -- a -> -a
 * 非首次出现 -- 记录相同值在两次出现的间隔中的所有元素种数
 * <p>
 * 模拟
 * 50/100
 */
public class PREV_147 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100000 + 10;
    private static int[] nums = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int res = 0;
            if (!map.containsKey(nums[i])) {
                res = -nums[i];
            } else {
                int lastIdx = map.get(nums[i]);
                Set<Integer> set = new HashSet<>();
                for (int j = lastIdx + 1; j < i; j++) {
                    if (set.add(nums[j])) {
                        res++;
                    }
                }
            }
            map.put(nums[i], i);
            if (i == n - 1) {
                out.print(res);
                break;
            }
            out.print(res + " ");
        }

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
