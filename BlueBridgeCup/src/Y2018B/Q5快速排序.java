package Y2018B;

import java.util.Random;

/**
 * @author Hyperspace
 * @date 2022/04/05
 * <p>
 * 标题：快速排序
 * <p>
 * 以下代码可以从数组a[]中找出第k小的元素。
 * 它使用了类似快速排序中的分治算法，期望时间复杂度是O(N)的。
 */
public class Q5快速排序 {
    public static int quickSelect(int a[], int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int x = a[p];
        int tmp = a[p];
        a[p] = a[r];
        a[r] = tmp;
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[i] < x) i++;
            if (i < j) {
                a[j] = a[i];
                j--;
            }
            while (i < j && a[j] > x) j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }
        }
        a[i] = x;
        p = i;
        if (i - l + 1 == k) return a[i];
        // 填空
        if (i - l + 1 < k) return quickSelect(a, i + 1, r, k - (i - l + 1));
        else return quickSelect(a, l, i - 1, k);
    }

    public static void main(String args[]) {
        int[] a = {1, 4, 2, 8, 5, 7};
        System.out.println(quickSelect(a, 0, 5, 4));
    }
}
