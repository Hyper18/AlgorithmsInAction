package practice3;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * <p>
 * 1. 暴力模拟 50/100，内存会超
 * 2. 线段树
 */
public class J_压缩变换 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                out.print(Math.negateExact(nums[i]) + " ");
            } else {
                Set<Integer> set = new HashSet<>();
                int cnt = 0;
                for (int idx = map.get(nums[i]) + 1; idx < i; idx++) {
                    if (set.add(nums[idx])) {
                        cnt++;
                    }
                }
                out.print(cnt + " ");
            }
            map.put(nums[i], i);
        }

        close();
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
