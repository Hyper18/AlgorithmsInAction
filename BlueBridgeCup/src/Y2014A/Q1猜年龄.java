package Y2014A;

/**
 * @author Hyper
 * @date 2022/03/16
 */
public class Q1猜年龄 {
    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            for (int j = Math.max(i - 8, 0); j < i; j++) {
                if (i * j == 6 * (i + j)) {
                    System.out.printf("%d %d\n", i, j);
                    break;
                }
            }
        }
    }
}
