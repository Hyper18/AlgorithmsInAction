package Y2014B;

/**
 * @author Hyperspace
 * @date 2022/03/20
 */
public class Q4大衍数列 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) //填空
                System.out.println(i * i / 2);
            else
                System.out.println((i * i - 1) / 2);
        }
    }
}
