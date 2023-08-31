package Math;

/**
 * @author Hyperspace
 * @date 2023/08/09
 * @file M1281_整数的各位积和之差.java
 * <p>
 * 秒
 */
public class M1281_整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return product - sum;
    }
}
