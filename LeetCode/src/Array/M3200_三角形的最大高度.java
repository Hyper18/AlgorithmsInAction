package Array;

/**
 * @author Hyper
 * @date 2024/10/15
 * @file M3200_三角形的最大高度.java
 * <p>
 * 思路
 * 模拟
 */
public class M3200_三角形的最大高度 {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(f(red, blue), f(blue, red));
    }

    private int f(int red, int blue) {
        int base = 1;
        while (red > 0 || blue > 0) {
            if (red - base < 0) {
                break;
            }
            red -= base;
            base++;
            if (blue - base < 0) {
                break;
            }
            blue -= base;
            base++;
        }

        return base - 1;
    }
}
