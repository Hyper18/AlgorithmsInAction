package Array;

/**
 * @author Hyperspace
 * @date 2023/09/29
 * @file M605_种花问题.java
 * <p>
 * 思路
 * 模拟
 */
public class M605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n <= 0 || (len == 1 && n == 1 && flowerbed[0] == 0)) {
            return true;
        }
        if (n >= len) {
            return false;
        }
        if (flowerbed[1] == 0 && flowerbed[0] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed[len - 2] == 0 && flowerbed[len - 1] == 0) {
            flowerbed[len - 1] = 1;
            n--;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] a = new int[len + 2];
        System.arraycopy(flowerbed, 0, a, 1, len);
        for (int i = 1; i < len + 1; i++) {
            if (a[i] == 0 && a[i - 1] == 0 && a[i + 1] == 0) {
                a[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
