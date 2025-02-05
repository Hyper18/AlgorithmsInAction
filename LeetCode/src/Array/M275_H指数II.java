package Array;

/**
 * @author Hyper
 * @date 2023/10/30
 * @file M275_H指数II.java
 * <p>
 * 思路
 * 乐，同M274
 */
public class M275_H指数II {
    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0] >= 1 ? 1 : 0;
        }
        int n = citations.length;
        for (int i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                return i - 1;
            }
        }

        return n;
    }
}
