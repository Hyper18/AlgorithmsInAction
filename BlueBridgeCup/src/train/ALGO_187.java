package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 思路
 * hashmap计数
 */
public class ALGO_187 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int num = Integer.MAX_VALUE;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                num = entry.getKey();
            } else if (entry.getValue() == max && entry.getKey() < num) {
                num = entry.getKey();
            }
        }

        out.println(num);

        in.close();
        out.close();
    }
}
