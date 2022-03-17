package Y2014A;

/**
 * @author Hyperspace
 * @date 2022/03/16
 * 这题主要要注意，已经确定了最后一次遇到的是花
 * 因此递归的出口应为剩下一斗酒，碰到花
 */
public class Q2李白打酒 {
    static int ans = 0;

    public static void main(String[] args) {
        walk(2, 5, 10 - 1);
        System.out.println(ans);
    }

    private static void walk(int wine, int stores, int flowers) {
        if (stores == 0 && flowers == 0 && wine == 1) {
            ans++;
        }
        if (stores > 0) {
            walk(wine + wine, stores - 1, flowers);
        }
        if (flowers > 0) {
            walk(wine - 1, stores, flowers - 1);
        }
    }
}
