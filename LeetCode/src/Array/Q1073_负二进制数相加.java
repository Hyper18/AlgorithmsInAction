package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * 思路
 * 重点考虑-2为底，进位的情况：
 * 2=110 3=111 4=100
 * <p>
 * 1 + 1 = 110
 * 11 + 1 = 0
 * <p>
 * 当前进位后的值可能是-1, 0, 1, 2或者3。
 * 其中-1,2,3需要再次进位。
 * 2和3下一次进位时进-1。
 * -1下一次进位时进1。
 */
public class Q1073_负二进制数相加 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1[0] == 0) {
            return arr2;
        }
        if (arr2[0] == 0) {
            return arr1;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        int lenMax = Math.max(len1, len2) + 2;
        int[] res = new int[lenMax];

        int i = len1 - 1;
        int j = len2 - 1;
        int k = lenMax - 1;
        while (k >= 2) {
            if (i >= 0 && j >= 0) {
                res[k--] = arr1[i--] + arr2[j--];
            } else if (i >= 0) {
                res[k--] = arr1[i--];
            } else {
                res[k--] = arr2[j--];
            }
        }

        for (i = 2; i < lenMax; i++) {
            if (res[i] == 2) {
                carry(res, i);
            }
        }

        for (i = 0; i < lenMax; i++) {
            if (res[i] != 0) {
                break;
            }
        }
        return i == lenMax ? new int[]{0} : Arrays.copyOfRange(res, i, lenMax);
    }

    private void carry(int[] res, int i) {
        res[i] = 0;
        if (res[i - 1] == 1) {
            res[i - 1] = 0;
        } else {
            res[i - 1] += 1;
            res[i - 2] += 1;
            if (res[i - 2] == 2) {
                carry(res, i - 2);
            }
        }
    }
}
