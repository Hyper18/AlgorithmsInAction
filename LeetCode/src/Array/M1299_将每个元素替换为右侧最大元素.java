package Array;

/**
 * @author Hyper
 * @date 2025/02/16
 * @file M1299_将每个元素替换为右侧最大元素.java
 * <p>
 * 思路
 * 模拟
 */
public class M1299_将每个元素替换为右侧最大元素 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                }
            }
        }

        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int n = arr.length;
        int mx = -1;
        for (int i = n - 1; i >= 0; i--) {
            int t = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, t);
        }

        return arr;
    }
}
