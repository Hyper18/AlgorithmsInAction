package Y2019B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/04/06
 */
public class D数的分解 {
    public static void main(String[] args) {
        int n = 2019;
        Set<int[]> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (!check(i)) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (!check(j)) {
                    continue;
                }
                int k = n - i - j;
                if (check(k) && k > i && k > j) {
                    int[] arr = new int[]{i, j, k};
                    Arrays.sort(arr);
                    set.add(arr);
                }
            }
        }

        System.out.println(set.size());
    }

    private static boolean check(int i) {
        String s = String.valueOf(i);
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '4') {
                return false;
            }
        }
        return true;
    }
}
