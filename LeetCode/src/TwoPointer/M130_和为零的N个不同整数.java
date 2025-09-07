package TwoPointer;

/**
 * @author Hyper
 * @date 2025/09/07
 * @file Q130_和为零的N个不同整数.java
 * <p>
 * 思路
 * 双指针
 */
public class M130_和为零的N个不同整数 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int l = 0, r = n - 1, i = 1;
        while (l < r) {
            res[l++] = i;
            res[r--] = -i++;
        }
        return res;
    }
}
